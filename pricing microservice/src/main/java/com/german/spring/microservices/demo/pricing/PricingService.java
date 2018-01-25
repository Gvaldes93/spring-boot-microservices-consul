package com.german.spring.microservices.demo.pricing;

import java.util.List;

public interface PricingService {
    List<String> getPortfoliosWithPrices(String url);
}
