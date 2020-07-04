package com.tom.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

@Component
public class Driver {

    @Autowired
    private Vehicle vehicle;

    @Autowired
    public Driver(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Autowired
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Scheduled(fixedRate = 10000)
    @Scheduled(cron = "0 * * * * MON-FRI")
    public void checkVehicle() {
    }

    @Schedules({
            @Scheduled(fixedRate = 10000),
            @Scheduled(cron = "0 * * * * MON-FRI")
    })
    void checkVehicle2() {
        // ...
    }
}
