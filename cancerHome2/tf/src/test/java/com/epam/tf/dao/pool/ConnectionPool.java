package com.epam.tf.dao.pool;

import com.epam.tf.exception.DAOException;
//
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Hleb_Turchyk on 11/09/2016.
 *
 * The {@code ConnectionPool} class represents an ability to connect with
 * database by means of {@code BlockingQueue} interface's possibility.
 */
public class ConnectionPool {
    private final Logger LOG = LogManager.getLogger();
    private static final int WAITING_TIMEOUT_SEC = 10;
    private static ResourceBundle configBundle = ResourceBundle.getBundle("database");
    private final int DEFAULT_POOL_SIZE = Integer.parseInt(configBundle.getString("defaultPoolSize"));
    private static Lock lock = new ReentrantLock();
    private static AtomicBoolean giveConnection = new AtomicBoolean(true);
    private static AtomicBoolean isNull = new AtomicBoolean(true);
    private static ConnectionPool instance;
    private ArrayBlockingQueue<Connection> pool;

    /**
     * Simple constructor that performs the only initializing method.
     */
    public ConnectionPool() {
        init();
    }

    /**
     * Initializing method that sets up all starting database conditions:
     * login, password, pool size, encoding, etc. Causes {@code RuntimeException}
     * in the case of {@code SQLException} that occurs if any SQL error is faced.
     */
    private void init() {
        pool = new ArrayBlockingQueue<>(DEFAULT_POOL_SIZE);
        try {
      //      DriverManager.registerDriver(new SQLServerDriver());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Properties properties = new Properties();
            properties.setProperty("user", configBundle.getString("login"));
            properties.setProperty("password", configBundle.getString("password"));
            properties.setProperty("useUnicode", configBundle.getString("unicode"));
            properties.setProperty("characterEncoding", configBundle.getString("encoding"));
            for (int i = 0; i <= DEFAULT_POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(configBundle.getString("url"), properties);
                pool.offer(connection);
            }
        } catch (SQLException  | ClassNotFoundException e) {
            LOG.fatal("Exception occurred during connecting to database" + e.getMessage());
            throw new RuntimeException("Exception in init method of connection pool", e);
        }
    }

    /**
     * Represents double-checked singleton pattern that gets the
     * only instance of {@code ConnectionPool}.
     * @return  single instance of {@code ConnectionPool}.
     */
    public static ConnectionPool getInstance() {
        if (isNull.get()) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    isNull.getAndSet(false);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    /**?tance of {@code Connection} from the pool using non-
     * blocking {@code poll()} method.
     * @return  an instance of {@code Connection}.
     * @throws DAOException (self-generated) if {@code InterruptedException}
     *          occurs due to {@code poll()} method used with time-waiting parameter.
     */
    public Connection getConnection() throws DAOException {
        Connection connection = null;
        if (giveConnection.get()) {
            try {
                connection = pool.poll(WAITING_TIMEOUT_SEC, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new DAOException("Exception occurred during getting connection", e);
            }
        }
        return connection;
    }

    /**
     * Gives back a non-null connection to the connection pool through the
     * use of {@code offer()} method.
     * @param   connection is an instance of {@code Connection}.
     */
    public void returnConnection(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }

    /**
     * Shuts down the connection pool by closing all the connections in it.
     * Uses {@code sleep} method for compulsory delay before cleaning the pool.
     */
    public void cleanUp() throws DAOException {
        giveConnection = new AtomicBoolean(false);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new DAOException("InterruptedException occurred during connection pool cleaning", e);
        }
        Iterator<Connection> iterator = pool.iterator();
        while (iterator.hasNext()) {
            Connection connection = iterator.next();
            try {
                connection.close();
            } catch (SQLException e) {
                LOG.error("Exception occurred during connection pool cleaning");
            }
            iterator.remove();
        }
    }
}