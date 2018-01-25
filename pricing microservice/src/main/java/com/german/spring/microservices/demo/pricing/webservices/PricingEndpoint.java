package com.german.spring.microservices.demo.pricing.webservices;

import com.german.spring.microservices.demo.pricing.PricingService;
import com.german.spring.microservices.demo.pricing.ServiceDiscoverer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pricing")
public class PricingEndpoint {

    @Autowired
    ServiceDiscoverer serviceDiscoverer;

    @Autowired
    PricingService pricingServiceImpl;


    @ApiOperation(value = "Retrieves a fully priced portfolio",
            notes = "Retrieves fully priced portfolio given customer id and portfolio id")
    @GetMapping("/customer/{customerId}/portfolio/{portfolioId}")
    public List<String> getPricedPortfolio(@PathVariable("customerId") int customerId,
                                           @PathVariable("portfolioId") int portfolioId) {

        ServiceInstance instance = serviceDiscoverer.getServiceInstance("portfolio-service");

        String url = String.format("%s/portfolios/customer/%d/portfolio/%d",
                instance.getUri(), customerId, portfolioId);

        return pricingServiceImpl.getPortfoliosWithPrices(url);
    }

}
