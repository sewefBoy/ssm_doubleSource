package com.soecode.lyf.service.impl;

import com.soecode.lyf.dao.AppointmentDao;
import com.soecode.lyf.entity.Appointment;
import com.soecode.lyf.service.AppointmentOracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sewef on 2018/6/14.
 */
@Service
public class AppointmentOracleServiceImpl implements AppointmentOracleService{
    @Autowired
    public AppointmentDao appointmentDao;

    @Override
    public List<Appointment> quaryAll() {
        return null;
    }

    @Override
    public Appointment queryById(int id) {
        return appointmentDao.queryById(id);
    }

    @Override
    public boolean updateById(int id) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
