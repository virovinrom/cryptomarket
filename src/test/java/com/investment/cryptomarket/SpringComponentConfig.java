package com.investment.cryptomarket;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.investment.cryptomarket.businesslogic"})
public class SpringComponentConfig {
}
