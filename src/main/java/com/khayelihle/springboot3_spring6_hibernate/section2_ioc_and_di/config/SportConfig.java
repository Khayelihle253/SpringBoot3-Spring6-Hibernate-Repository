package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.config;

import com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common.Coach;
import com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    /**
     * The whole idea of using a configuration class and the @Bean annotation is to take an
     * existing third-party class (because is has no @Component defined hence it cannot be scanned)
     * and expose it or wrap it as a bean, so that we can use in the spring application.
     *
     * we can also use the bean id by @Bean("bean_id") to change the default method name bean id.
     *
     */
    @Bean("swimmingTrainer")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
