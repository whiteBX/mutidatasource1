package org.white.mutidatasource1.config;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * <p></p >
 *
 * @author baixiong
 * @version $Id: FrontDBConfig.java, v 0.1 2018年09月05日 15:53:00 baixiong Exp$
 */
@Configuration
@MapperScan(basePackages = "org.white.mutidatasource1.dao.front", sqlSessionFactoryRef = "frontSqlSessionFactory")
public class FrontDBConfig {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource frontDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.front.jdbcUrl"));
        dataSource.setUsername(env.getProperty("spring.datasource.front.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.front.password"));
        return dataSource;
    }

    @Bean
    @Primary
    public DataSourceTransactionManager frontTransactionManager(@Qualifier("frontDataSource") DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionFactory frontSqlSessionFactory(@Qualifier("frontDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean
            .setConfigLocation(new ClassPathXmlApplicationContext().getResource("classpath:db-mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate frontSqlSessionTemplate(@Qualifier("frontSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }
}
