package com.german.spring.microservices.demo.pricing.webservices;

import org.springframework.web.client.RestTemplate;

public class PortfolioRequests {

    /**
     * query for the portfolios, returned as an array of List
     * of size 2, containing a ticker and a position (# of shares)
     * @param url
     * @return
     */
    public static Object[] getPortfolios(String url) {
        Object[] portfolio = new RestTemplate().getForObject(url, Object[].class);
        return portfolio;
    }

}
