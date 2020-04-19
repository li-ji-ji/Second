package cn.second.lhj.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"cn.second.lhj.asso.mapper","cn.second.lhj.stuinfo.mapper"}, sqlSessionTemplateRef  = "cspSqlSessionTemplate")
public class DataSourceCspConfig {

    @Bean(name = "cspDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.csp")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "cspSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("cspDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapxml/csp/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "cspTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("cspDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "cspSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("cspSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
