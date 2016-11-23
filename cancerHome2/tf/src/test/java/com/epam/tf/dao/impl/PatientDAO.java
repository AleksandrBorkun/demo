package com.epam.tf.dao.impl;

import com.epam.tf.dao.BaseDAO;
import com.epam.tf.dao.entity.Patient;
import com.epam.tf.dao.exception.DAOException;

import java.util.List;

/**
 * Created by Hleb_Turchyk on 11/10/2016.
 */
public class PatientDAO implements BaseDAO<Patient> {
    @Override
    public List<Patient> findAll() throws DAOException {
        return null;
    }

    @Override
    public void add(Patient patient) throws DAOException {

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
    public void deleteById(Long id) throws DAOException {

    }

    @Override
    public void updateById(Long id, Patient patient) throws DAOException {

    }
}
