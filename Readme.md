#This tutorial is intended to show the integration of Spring Boot and micro services.
 simple stock market portfolio management application that clients can call to price their stock portfolio (stock tickers and quantities). The portfolio microservice will retrieve the clients portfolio, send it to a pricing microservice to apply the latest pricing, and then return the fully priced and subtotaled portfolio, exposing all that via a rest call.

The micro services are using Service discovery to communicate with each other powered by Consul.io 
Refer to this link to see the entire tutorial material:
https://www.infoq.com/articles/Microservices-SpringBoot


* install consul.io and start an instance 
* navigate into the two folders containing the microservices sources and start them.

To see microservices in consul navigate to : http://localhost:8500/ui/#/dc1/services

