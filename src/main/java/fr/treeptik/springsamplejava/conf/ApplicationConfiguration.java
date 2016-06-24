package fr.treeptik.springsamplejava.conf;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:/config.properties")
@ComponentScan(basePackages = { "fr.treeptik.springsample.dao", "fr.treeptik.springsample.service" }) //scan des package contenant les beans : bonne pratique être le plus précis possible pour éviter un scan long et inutile de toutes les classes (autre libraire y compris)
public class ApplicationConfiguration {
	@Autowired
	private Environment environment;

	@Value("${db.driverclassname}")
	private String driverClassName;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource dataSource() {

		System.out.println("VALEUR driverclassname avec @Value = " + driverClassName);

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("db.driverClassName"));
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));
		return dataSource;
	}

}
