package com.Chlin.blog.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

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
//@ApiModel(value="Order对象", description="")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer dishId;

    //购买数量
    private Integer count;

    //单个金额
    private BigDecimal amount;

    //支付金额paid=count+amount
    private BigDecimal paidAmount;

//        @ApiModelProperty(value = "状态:0-未付款,1-已付款")
        private Integer status;

//        @ApiModelProperty(value = "支付类型:1-余额;2-现金")
        private Integer payType;

    private Date completeTime;

    private Date createTime;


    public Integer getId() {
        return id;
    }

    public Orders setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Orders setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getDishId() {
        return dishId;
    }

    public Orders setDishId(Integer dishId) {
        this.dishId = dishId;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public Orders setCount(Integer count) {
        this.count = count;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Orders setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public Orders setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Orders setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getPayType() {
        return payType;
    }

    public Orders setPayType(Integer payType) {
        this.payType = payType;
        return this;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public Orders setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Orders setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "Orders{" +
        "id=" + id +
        ", userId=" + userId +
        ", dishId=" + dishId +
        ", count=" + count +
        ", amount=" + amount +
        ", paidAmount=" + paidAmount +
        ", status=" + status +
        ", payType=" + payType +
        ", completeTime=" + completeTime +
        ", createTime=" + createTime +
        "}";
    }
}
