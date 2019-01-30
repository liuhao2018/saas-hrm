package com.saas.hrm.service;

import com.saas.hrm.dto.EmployeeDTO;
import com.saas.hrm.entity.Employee;
import com.saas.hrm.mapper.EmployeeMapper;
import com.xuxueli.poi.excel.ExcelExportUtil;
import com.xuxueli.poi.excel.ExcelImportUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 18:00
 * @Description:
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    private String[] employeeFiled = {"ID","姓名"};


    public int save(Employee employee) {
        return employeeMapper.insertSelective(employee);
    }

    public List<Employee> findAll() {
        return employeeMapper.selectAll();
    }

    public ByteArrayOutputStream export() throws Exception {
        Workbook workbook = ExcelExportUtil.exportWorkbook(findAll());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        workbook.write(os);
        return os;
    }

    public void importEmployee(InputStream is) {
        List<Object> employeeList = ExcelImportUtil.importExcel(is,EmployeeDTO.class);
        System.out.println(employeeList);
    }
}
