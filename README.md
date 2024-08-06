
# Offical NSW Government Media Releases from different Ministers

A brief description of what this project does and who it's for


## Documentation

Used Tools such as Selenium WebDriver, TestNG to create a framework and Java as the programming language.

*HOW TO RUN THE PROJECT

Right click on testng.xml file and run as TestNG Suite

*STRUCTURE OF THE FRAMEWORK 

Under com.nsw.gov.framework package, we have the below classes.

The Base Class will call the WebDWebdriverInitializer class methods using webDriver to open the Chrome Browser and also Initalize the config.properties(contains URL, browser - key value pairs) and object.properties files(contains locators in a key value format).

The CommonFunction class launches the application URL using the ConfigData class which in turn uses the config.proerties object reference to fetch the link. 

PropertiesReader class to read the config.properites and object.properties files.

Under com.nsw.gov.pages package, we have the below application page classes that identifies webelements and actions are performed on these elements using the methods.

Under src/main/resounces, we have chrome driver.exe and config.properites and object.properites files

Under src/test/java, we have the test class which contains 2 test scripts for the 2 tasks. 

*POM.xml 

There are 2 dependencies used in the pom.xml file.

*testng

*selenium java






