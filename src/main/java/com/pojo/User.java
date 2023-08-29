package com.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @TableId(value="Userid")
//    @TableId(type = IdType.AUTO);
    private int Userid;
    private String Username;
    private String Password;
    private String Name;
    private String Email;
    private String Phone;

    @TableField(fill = FieldFill.INSERT)
    private Date Registrationdate;

}
