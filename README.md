# "Selenium" BDD with "Cucumber" and "Serenity"
* This project explains how to perform the API operations by using REST ASSURED with Serenity
Where i followed the BDD Approach pattern for easy understanding and cover the scenarios as per the 
requirement.
* used Maven to install the dependencies and run the tests

## Project Description:
* serenity
* serenity.cucumber
* serenity.restassured
* Makes use of Page Objects.
* Written in Java with Junit, Cucumber & Maven

##API Automation Scenarios
* Covered GET, POST, DELETE operations 
 
## Setup:
* Install [Java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html)
* Install Maven [Maven](https://maven.apache.org/)
* "mvn archetype:generate -Dfilter=net.serenity-bdd:serenity-cucumber-archetype" to setup project from scratch

## Run tests:
* `mvn clean verify` to run test scenarios using.

## View HTML Report
* HTML report will be generated once execution finish -projectfolder\target\site\serenity\index.html
* Open Index.html in browser to see the reports


