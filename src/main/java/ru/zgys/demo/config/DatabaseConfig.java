package ru.zgys.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author U.Goryntsev 29.08.2017
 */
@Configuration
@EnableJpaRepositories("ru.zgys.demo.repository")
@EnableTransactionManagement
@ConfigurationProperties(prefix = "spring.datasource")
public class DatabaseConfig extends HikariConfig {
	private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Bean
	public DataSource dataSource() {
		this.addDataSourceProperty("url", this.getUrl());
		return new HikariDataSource(this);
	}
}
