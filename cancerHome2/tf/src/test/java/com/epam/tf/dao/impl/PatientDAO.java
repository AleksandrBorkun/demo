package com.epam.tf.dao.impl;

import com.epam.tf.dao.IDAO;
import com.epam.tf.entity.Patient;
import com.epam.tf.exception.DAOException;
import com.epam.tf.dao.pool.ConnectionPool;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hleb_Turchyk on 11/10/2016.
 */
public class PatientDAO implements IDAO<Patient> {

    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final static String SQL_ADD_PASPORT_DATA = "SET IDENTITY_INSERT [dbo].[OncPasp] ON " +
            "INSERT [dbo].[OncPasp] ([Idn], [NumAmb], [Last_Name], [First_Name], [Patr_Name], [Sex], [DatBirth], [CodeDisp], [DateUch], [NKart], [TerCode], [Resident], [zipcode], [Street], [House], [Building], [Appartmnt], [Ambulance], [Phone], [situation], [ychern], [TerCher], [GrUchet], [inval], [vov], [cnac], [uchfirst], [addinfm], [StateNdyr], [DateOut], [deadsourc], [whereout], [addtxtout], [dgdead], [txtdead], [fiowrite], [vnodead], [VerFio], [PersNumb], [IdN_Ch], [beopen], [datedit], [CodeDB], [Id_STREET]) VALUES (?, N'0491202', ?, ?, ?, ?, ?, N'332', N'19990701', N'00822', N'1533228808081', N'2', N'223910', N'ТРУДОВАЯ УЛ.                                                ', N'28', N'  ', N'', N'02016146000', N'', N'студентка', N' ', N'             ', N' ', N' ', N' ', N'03', N'0', N'', N'5', N'20161230', N'9', N'1530000000000', N'', N'    ', N'', N'', N' ', N' ', ?, N'       ', N' ', N'20140815', N'332', 59034) " +
            "SET IDENTITY_INSERT [dbo].[OncPasp] OFF";
    private final static String SQL_ADD_DIAG = "SET IDENTITY_INSERT [dbo].[OncDiag] ON " +
            "INSERT [dbo].[OncDiag] ([Idn], [NumLoc], [DateDg], [Mkb10], [MkbO], [diagtxt], [Lateral], [TypeDg], [usldg], [ConfirmDg], [GistMkb], [cgist], [txtgist], [ngist], [DateGist], [grade], [Stage], [AddStage], [t], [n], [m], [sourcedg], [whatlpu], [FioFDoc], [TerCode], [Urban], [AddTxt], [DatCancel], [vervozr], [VerVozrG], [VerSexG], [vnocase], [Id], [Stage_Prev], [YAlgLech], [Er], [Er_bal], [Pr], [Pr_Bal], [Ki], [Her2]) VALUES (?, N'01', N'19990601', N'C811', N'2015', N'Lgr с пораж.шейно/надкл.л/у с обеих ст.л/у средост ', N'0', N'1', N'2', N'1', N'96633', N'072', N' ', N'1368-74/99 ', N'        ', N'9', N'2', N' ', N'1', N'1', N'x', N'1', N'           ', N' ', N'1533228808081', N' ', N' ', N'        ', 0, 0, 0, N' ', ?, N' ', N' ', NULL, N' ', NULL, N' ', NULL, N' ') " +
            "SET IDENTITY_INSERT [dbo].[OncDiag] OFF";
    private final static String SQL_ADD_CLINIC = "SET IDENTITY_INSERT [dbo].[ONCKLIN] ON " +
            "INSERT [dbo].[ONCKLIN] ([Idn], [DateSost], [KlGroup], [kldg], [Id]) VALUES (?, N'19990601', N'2', N' ', ?) " +
            "SET IDENTITY_INSERT [dbo].[ONCKLIN] OFF";
    private final static String SQL_ADD_TREATMENT = "SET IDENTITY_INSERT [dbo].[OncGLch] ON " +
            "INSERT [dbo].[OncGLch] ([Idn], [NumLoc], [NumLch], [DatBLech], [DatELech], [svedlech], [CharLech], [kindlech], [typeinst], [placelech], [numhist], [treatnoful], [txtlech], [Id]) VALUES (?, N'01', N'001', N'19990601', N'19990601', N'00', N'00', N'00', N'10', N'02013917000', N'       ', N' ', N' ', ?/*2905306*/) " +
            "SET IDENTITY_INSERT [dbo].[OncGLch] OFF";

    private final static String SQL_DELETE = "DELETE FROM [dbo].[OncPasp] WHERE [Idn] = ? " +
            "DELETE FROM [dbo].[OncDiag] WHERE [Idn] = ? " +
            "DELETE FROM [dbo].[ONCKLIN] WHERE [Idn] = ? " +
            "DELETE FROM [dbo].[OncGLch] WHERE [Idn] = ?";

    @Override
    public List<Patient> findAll() throws DAOException {
        return null;
    }

    @Override
    public void add(Patient patient) {
        Connection con = null;
        try {
            con = connectionPool.getConnection();
            PreparedStatement statementPasp = con.prepareStatement(SQL_ADD_PASPORT_DATA);
            PreparedStatement statementDiag = con.prepareStatement(SQL_ADD_DIAG);
            PreparedStatement statementClinic = con.prepareStatement(SQL_ADD_CLINIC);
            PreparedStatement statementTreatment = con.prepareStatement(SQL_ADD_TREATMENT);
            Long ID = patient.getId();//perhaps it'll be necessary to make different id
            Long IDN = patient.getIdn();
            statementPasp.setLong(1, IDN);
            statementPasp.setString(2, patient.getLastName());
            statementPasp.setString(3, patient.getFirstName());
            statementPasp.setString(4, patient.getPatrName());
            statementPasp.setString(5, patient.getSex().toString());
            statementPasp.setString(6, patient.getBirthDay());
            statementPasp.setString(7, patient.getPersonalNumber());
            statementClinic.setLong(1, IDN);
            statementClinic.setLong(2, ID);
            statementDiag.setLong(1, IDN);
            statementDiag.setLong(2, patient.getIdDiag());
            statementTreatment.setLong(1, IDN);
            statementTreatment.setLong(2, ID);
            statementPasp.execute();
            statementClinic.execute();
            statementDiag.execute();
            statementTreatment.execute();
            LOG.info("patient: " + patient.getLastName() + " " + patient.getFirstName() + " idn: ****"
                    + patient.getIdn() + "**** added in database");
        } catch (DAOException | SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            connectionPool.returnConnection(con);
        }
    }


    @Override
    public Patient findById(Long id) throws DAOException {
        return null;
    }

    @Override
    public Patient findByName(String name) throws DAOException {
        return null;
    }

    @Override
    public void deleteByIdn(Long id) {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, id);
            statement.setLong(2, id);
            statement.setLong(3, id);
            statement.setLong(4, id);
            statement.execute();
            LOG.info("patient with idn: ****" + id + "**** deleted from database");
        } catch (DAOException | SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateById(Long id, Patient patient) throws DAOException {

    }

}
