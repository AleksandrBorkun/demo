package com.epam.tf.dao;

import com.epam.tf.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Hleb_Turchyk on 11/09/2016.
 * The {@code InterfaceDao} interface enumerates all the necessary methods
 * for manipulation with data in database.
 */
public interface BaseDAO<T> {
    Logger LOG = LogManager.getLogger();
    List<T> findAll() throws DAOException;
    void add(T t) throws DAOException;
    T findById(Long id) throws DAOException;
    T findByName(String name) throws DAOException;
    void deleteById(Long id) throws DAOException;
    void updateById(Long id, T t) throws DAOException;
}
