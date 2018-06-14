package com.soecode.lyf.service;

import com.soecode.lyf.entity.Appointment;

import java.util.List;

/**
 * Created by sewef on 2018/6/14.
 */
public interface AppointmentOracleService {
    public List<Appointment> quaryAll();

    public Appointment queryById(int id);

    public boolean updateById(int id);

    public boolean deleteById(int id);
}
