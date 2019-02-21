package com.saas.hrm.service;

import com.saas.hrm.entity.Employee;
import com.saas.hrm.mapper.EmployeeMapper;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.saas.hrm.utils.OSSUtil;

import java.util.HashMap;
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


    public int save(Employee employee) {
        return employeeMapper.insertSelective(employee);
    }

    public String generatePDF() throws Exception{
        Resource resource = new ClassPathResource("templates/test02.jasper");
        List<Employee> list = employeeMapper.selectAll();
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);
        JasperPrint jasperPrint = JasperFillManager.fillReport
                (resource.getInputStream(),new HashMap<>(),ds);
        byte[] uploadBytes  = JasperExportManager.exportReportToPdf(jasperPrint);
        String key = OSSUtil.upload(uploadBytes,"employee.pdf");
        return key;
    }

}
