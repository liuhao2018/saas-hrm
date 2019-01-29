package com.saas.hrm.service;

import com.saas.hrm.entity.Employee;
import com.saas.hrm.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 18:00
 * @Description:
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    public int save(Employee employee) {
        return employeeMapper.insertSelective(employee);
    }

}
