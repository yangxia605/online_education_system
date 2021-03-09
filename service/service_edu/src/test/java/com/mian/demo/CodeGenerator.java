package com.mian.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

//import com.baomidou.mybatisplus.annotation.DbType;
public class CodeGenerator {

    @Test
    public void run(){
        // 1.创建代码生成器
        AutoGenerator mpg = new AutoGenerator(); //代码生成器对象

        //2.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("E:\\java_projects\\online_education_system\\service\\service_edu"+"/src/main/java");//代码输出目录
        gc.setAuthor("test.java");
        gc.setOpen(false);
        gc.setFileOverride(false);
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ID_WORKER);//主键测量
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);

        mpg.setGlobalConfig(gc);

        //3.数据源配置
        DataSourceConfig dsc=new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/education?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("12345678");
        dsc.setDbType(DbType.MYSQL);

        mpg.setDataSource(dsc);

        //4.包配置
        PackageConfig pc=new PackageConfig();
        pc.setModuleName("eduservice");
        pc.setParent("com.example.demo");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");

        mpg.setPackageInfo(pc);

        //5 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("edu_teacher");//表
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);

        //6.执行
        mpg.execute();
    }
}

