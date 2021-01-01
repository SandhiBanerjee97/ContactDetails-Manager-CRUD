package com.sandhi.user.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sandhi.user.dao.UserDAO;
import com.sandhi.user.dao.UserDAOImpl;

@PropertySource("classpath:database.properties")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sandhi.user")
public class AppConfig implements WebMvcConfigurer
{
	@Value("${mysql.userName}")
	private String userName;
	
	@Value("${mysql.password}")
	private String password;
	
	@Value("${mysql.url}")
	private String url;
	
	@Value("${mysql.driver}")
	private String driver;
	
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public ViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public UserDAO getUserDAO()
	{
		UserDAO dao=new UserDAOImpl();
		return dao;
	}
	@Bean
	public JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate jdbcTemplate= new JdbcTemplate(getDataSource());
		return jdbcTemplate;
	}
}
