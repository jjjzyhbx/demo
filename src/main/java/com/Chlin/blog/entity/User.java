package com.Chlin.blog.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
//@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String realName;

//        @ApiModelProperty(value = "用户类型:0-学生,1-员工")
        private Integer type;

    private String studentId;

    private String employeeId;

    private Integer departmentId;

    private Integer grade;

    private BigDecimal balance;

    private Date registerTime;

    private Date lastLoginTime;


    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public User setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public User setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getStudentId() {
        return studentId;
    }

    public User setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public User setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public User setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public Integer getGrade() {
        return grade;
    }

    public User setGrade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public User setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public User setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public User setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", realName=" + realName +
        ", type=" + type +
        ", studentId=" + studentId +
        ", employeeId=" + employeeId +
        ", departmentId=" + departmentId +
        ", grade=" + grade +
        ", balance=" + balance +
        ", registerTime=" + registerTime +
        ", lastLoginTime=" + lastLoginTime +
        "}";
    }
}
