package br.com.arphoenix.apis.msrab.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.arlepton.apis.framework", "br.com.arphoenix.apis.msrab"} )
@EntityScan(basePackages = {"com.arlepton.apis.framework", "br.com.arphoenix.apis.msrab"})
public class JpaConfig {

}
