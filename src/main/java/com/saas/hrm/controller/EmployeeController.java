package com.saas.hrm.controller;

import com.saas.hrm.entity.Employee;
import com.saas.hrm.response.Result;
import com.saas.hrm.response.ResultEnum;
import com.saas.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pdf")
    public Result generatePDF() throws Exception{
        String key = employeeService.generatePDF();
        if (StringUtils.isEmpty(key)) {
            return new Result(ResultEnum.FAIL.getCode(),ResultEnum.FAIL.getMessage(),null);
        }
        return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),null);
    }
}
