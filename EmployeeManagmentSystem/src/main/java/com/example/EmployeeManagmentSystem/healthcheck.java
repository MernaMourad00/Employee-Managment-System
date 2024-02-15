package com.example.EmployeeManagmentSystem;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class healthcheck implements HealthIndicator {
    @Override
    public Health health() {
       long freeMemory =Runtime.getRuntime().freeMemory();
       long totslMemory=Runtime.getRuntime().totalMemory();
       double freeMemoryPercent=((double)freeMemory /(double) totslMemory)* 100;
       if(freeMemoryPercent >25){
           return Health.up()
                   .withDetail("free memory: ",freeMemory +" bytes")
                   .withDetail("total memory: ",totslMemory +" bytes")
                   .withDetail(" memory percentage : ",freeMemoryPercent +" bytes")
                   .build();
       }
       else {
           return Health.down()
                   .withDetail("free memory: ", freeMemory + " bytes")
                   .withDetail("total memory: ", totslMemory + " bytes")
                   .withDetail(" memory percentage : ", freeMemoryPercent + " bytes")
                   .build();
       }
    }
}
