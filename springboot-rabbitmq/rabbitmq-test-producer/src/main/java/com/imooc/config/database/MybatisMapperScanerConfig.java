package com.imooc.config.database;


import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//标识数据源类加载完成后才加载该类
@AutoConfigureAfter(MybatisDataSourceConfig.class)
public class MybatisMapperScanerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.imooc.mapper");
        return mapperScannerConfigurer;
    }
}
