package com.german.spring.microservices.demo.pricing;

import com.german.spring.microservices.demo.pricing.webservices.PortfolioRequests;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PricingServiceImpl implements PricingService, InitializingBean {

    Map<String, Double> pricingMap = new HashMap<>();

    /**
     * Look up the share prices, and return a list of Strings, formatted as
     * ticker, shares, price, total
     * @param url
     * @return
     */
    @Override
    public List<String> getPortfoliosWithPrices(String url) {
        Object[] portfolio = PortfolioRequests.getPortfolios(url);

        List<String> collect = Arrays.stream(portfolio).map(position -> {
            String ticker = ((List<String>) position).get(0);
            int shares = ((List<Integer>) position).get(1);
            double price = getPrice(ticker);
            double total = shares * price;
            return String.format("ticker: %s, shares: %d, price: %f, total: %f", ticker, shares, price, total);
        }).collect(Collectors.toList());
        return collect;
    }

    /**
     * Utility to get price given input ticker
     * @param ticker
     * @return price
     */
    private double getPrice(String ticker) {
        return pricingMap.get(ticker);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        pricingMap.put("MMM", 201.81);
        pricingMap.put("AXP", 85.11);
        pricingMap.put("AAPL", 161.04);
        pricingMap.put("BA", 236.32);
        pricingMap.put("CAT", 118.02);
        pricingMap.put("CVX", 111.31);
        pricingMap.put("CSCO", 31.7);
        pricingMap.put("KO", 46.00);
        pricingMap.put("DIS", 101.92);
        pricingMap.put("XOM", 78.7);
        pricingMap.put("GE", 24.9);
        pricingMap.put("GS", 217.62);
        pricingMap.put("HD", 155.82);
        pricingMap.put("IBM", 144.29);
        pricingMap.put("INTC", 35.66);
        pricingMap.put("JNJ", 130.8);
        pricingMap.put("JPM", 89.75);
        pricingMap.put("MCD", 159.81);
        pricingMap.put("MRK", 63.89);
        pricingMap.put("MSFT", 73.65);
        pricingMap.put("NKE", 52.78);
        pricingMap.put("PFE", 33.92);
        pricingMap.put("PG", 92.79);
        pricingMap.put("TRV", 117.00);
        pricingMap.put("UTX", 110.12);
        pricingMap.put("UNH", 198.00);
        pricingMap.put("VZ", 47.05);
        pricingMap.put("V", 103.34);
        pricingMap.put("WMT", 80.05);

    }

}
