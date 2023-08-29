package com.Chlin.blog.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Chlin
 * @since 2023-08-29
 */
@ApiModel(value="Dish对象", description="")
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer categoryId;

    private Integer monthlySales;

    private Integer inventory;

        @ApiModelProperty(value = "状态:0-下架,1-上架")
        private Integer status;

    private Date createTime;

    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public Dish setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dish setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Dish setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Dish setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getMonthlySales() {
        return monthlySales;
    }

    public Dish setMonthlySales(Integer monthlySales) {
        this.monthlySales = monthlySales;
        return this;
    }

    public Integer getInventory() {
        return inventory;
    }

    public Dish setInventory(Integer inventory) {
        this.inventory = inventory;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Dish setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Dish setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Dish setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String toString() {
        return "Dish{" +
        "id=" + id +
        ", name=" + name +
        ", price=" + price +
        ", categoryId=" + categoryId +
        ", monthlySales=" + monthlySales +
        ", inventory=" + inventory +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
