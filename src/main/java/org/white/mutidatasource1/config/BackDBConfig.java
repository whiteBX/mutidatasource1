package org.white.mutidatasource1.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * <p></p >
 *
 * @author baixiong
 * @version $Id: BackDBConfig.java, v 0.1 2018年09月05日 15:53:00 baixiong Exp$
 */
@Configuration
@MapperScan(basePackages = "org.white.mutidatasource1.dao.back", sqlSessionFactoryRef = "backSqlSessionFactory")
public class BackDBConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource backDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.back.jdbcUrl"));
        dataSource.setUsername(env.getProperty("spring.datasource.back.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.back.password"));
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager backTransactionManager(@Qualifier("backDataSource") DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory backSqlSessionFactory(@Qualifier("backDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean
            .setConfigLocation(new ClassPathXmlApplicationContext().getResource("classpath:db-mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate backSqlSessionTemplate(@Qualifier("backSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }

}
