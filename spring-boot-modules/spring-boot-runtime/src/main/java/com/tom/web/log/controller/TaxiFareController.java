package com.tom.web.log.controller;

import com.tom.web.log.data.RateCard;
import com.tom.web.log.data.TaxiRide;
import com.tom.web.log.service.TaxiFareCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TaxiFareController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaxiFareController.class);
    @Autowired
    private TaxiFareCalculatorService taxiFareCalculatorService;

    @GetMapping("/taxifare/get/")
    public RateCard getTaxiFare() {
        LOGGER.debug("getTaxiFare() - START");
        return new RateCard();
    }

    @PostMapping("/taxifare/calculate/")
    public String calculateTaxiFare(@RequestBody @Valid TaxiRide taxiRide) {
        LOGGER.debug("calculateTaxiFare() - START");
        String totalFare = taxiFareCalculatorService.calculateFare(taxiRide);
        LOGGER.debug("calculateTaxiFare() - Total Fare : {}", totalFare);
        LOGGER.debug("calculateTaxiFare() - END");
        return totalFare;
    }

}
