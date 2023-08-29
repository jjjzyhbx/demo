package com;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.val;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 代码自动生成器
 */
public class ClinCode {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        property=property+"/src/main/java";
//        FastAutoGenerator fastAutoGenerator = FastAutoGenerator.create("url", "username", "password")
//
//                .globalConfig(builder -> {
//                    builder.author("Chlin") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
//                            .outputDir("D://"); // 指定输出目录
//                });
//        System.out.println(property);
        AutoGenerator  autoGenerator = new AutoGenerator();

        //配置策略
        //全局配置
        GlobalConfig gc=new GlobalConfig();
        gc.setAuthor("Chlin");
        gc.setOutputDir(property);
        gc.setOpen(false);
        gc.setFileOverride(false);
        gc.setServiceName("%sService");
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);

        autoGenerator.setGlobalConfig(gc);

        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/meal_card_management?characterEncoding=UTF-8&serverTimezone=UTC");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("2605274496");
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");

        autoGenerator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setModuleName("blog");
        packageConfig.setParent("com.Chlin");
        packageConfig.setEntity("entity");
        packageConfig.setService("service");
        packageConfig.setController("controller");
        packageConfig.setMapper("mapper");

        autoGenerator.setPackageInfo(packageConfig);

        //策略配置
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setInclude("department","dish","order","user");//要映射的表名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityBuilderModel(true);
        strategyConfig.setLogicDeleteFieldName("deleted");

        //自动填充配置
        TableFill gmtCreate=new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified=new TableFill("gmt_modified",FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills=new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategyConfig.setTableFillList(tableFills);

        strategyConfig.setVersionFieldName("version");
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);

        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }
}
