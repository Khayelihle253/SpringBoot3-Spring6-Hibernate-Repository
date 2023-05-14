package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * For prototype scope, there will be a new object for each injection, unlike singleton which uses
 * or points to only one instance.
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class RugbyCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Play rugby for 1 hour";
    }
}
