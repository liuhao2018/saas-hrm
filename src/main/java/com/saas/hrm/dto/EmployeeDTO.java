package com.saas.hrm.dto;

import com.xuxueli.poi.excel.annotation.ExcelField;
import com.xuxueli.poi.excel.annotation.ExcelSheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.hssf.util.HSSFColor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelSheet(name = "Sheet0",headColor = HSSFColor.HSSFColorPredefined.LIGHT_GREEN)
public class EmployeeDTO {

    @ExcelField(name = "ID")
    private Double id;

    @ExcelField(name = "姓名")
    private String username;

}
