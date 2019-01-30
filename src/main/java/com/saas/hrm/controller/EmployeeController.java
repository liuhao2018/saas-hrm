package com.saas.hrm.controller;

import com.saas.hrm.dto.EmployeeDTO;
import com.saas.hrm.entity.Employee;
import com.saas.hrm.response.Result;
import com.saas.hrm.response.ResultEnum;
import com.saas.hrm.service.EmployeeService;
import com.saas.hrm.utils.DownloadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 17:55
 * @Description:
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST,name = "API_ADD_EMPLOYEE")
    public Result save(@RequestBody Employee employee) {
        employeeService.save(employee);
        return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),null);
    }


    @GetMapping("/export")
    public void export(HttpServletResponse httpServletResponse) throws Exception {
        ByteArrayOutputStream os = employeeService.export();
        new DownloadUtils().download(os,httpServletResponse);
    }

    @PostMapping("/import")
    public Result importEmployee(@RequestParam("file")MultipartFile multipartFile) throws Exception {
        employeeService.importEmployee(multipartFile.getInputStream());
        return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),null);
    }

}
