package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * using the @Primary will allow this class to run when having multiple coach implementations
 *  - when @Primary is used along with @Qualifier when injecting the Coach dependency, the @Qualifier has the higher priority
 *
 *  using @Primary can lead to some error when having multiple classes marked a primary, so it's better to stick with using @Qualifier
 *
 */
@Primary
@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Played  baseball for 2 hours";
    }
}
