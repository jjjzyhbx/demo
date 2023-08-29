//package com.Chlin.config;
//
//import com.baomidou.mybatisplus.core.injector.ISqlInjector;
//import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@MapperScan("com.Chlin.mapper")
//@EnableTransactionManagement
//@Configuration
//public class MyBatisConfig {
//    //注册乐观锁插件
//    @Bean
//    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor(){
//        return new OptimisticLockerInnerInterceptor();
//    }
//
//    //分页插件
//    @Bean
//    public PaginationInnerInterceptor paginationInnerInterceptor(){
//        return new PaginationInnerInterceptor();
//    }
//
//    //逻辑删除插件
////    @Bean
////    public ISqlInjector sqlInjector(){
////        return new LogicSqlInjector();
////    }
//    //执行效率插件
////    @Bean
////    @Profile({"dev,test"})
////    public
//}
