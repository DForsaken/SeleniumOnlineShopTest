## README
#### Prerequisites
* Maven 3.6
* Java 1.8 
* Selenium server standalone 3.141.59
* Gecko driver v0.25.0
* Chrome driver v80.0.3987.106

NOTES: 
    * This could work with different versions but we cannot assure it will
    * For this challenge testing purposes we included this driver versions on the src/test/resources directory for both linux64 and macos, feel free to use 
        them for your own tests

#### Installation
* Clone project 
#### Previous to run the tests
* Since we are using remote web driver, you must have already an up and running instance of selenium server with hub as role

        java -jar selenium-server-standalone-_._._.jar -role hub
        
* Also you should have an up and running driver of the browser(s) you will need, pointing to the selenium server

        java -Dwebdriver.BROWSER.driver="PATH_TO/DRIVER" -jar selenium-server-standalone-_._._.jar -role webdriver -hub http://SERVER_ADDRESS:4444/grid/register -port PORT_NUMBER     

#### How to run tests
Basically there are 2 different scripts in the scripts folder (You may have to give execution permission to scripts on the first use. Use chmod +x script.sh) 
  * Run all the tests in one thread. 
          
        ./scripts/run-test.sh BROWSER
        
       BROWSER: We are supporting for now firefox and chrome driver
       
  * Run all the tests in parallel.  

         ./scripts/run-test.-parallel.sh BROWSER THREADS
          
       BROWSER: We are supporting for now firefox and chrome driver

       THREADS: Number of threads

NOTE: By default Selenium server address is set to http://127.0.0.1:4444/wd/hub. If you need to modify it for you local 
address then you should modify that in the /scripts/run-test.-parallel file

#### Reports and Logs
* Since we are using allure reports, we should use the next script to bring up the local allure server. After that you can use ctrl-c to stop the server.

        ./scripts/show-reports.sh 
        
        
     ![Alt text](samplereport.png?raw=true "Title")
        
   
* Make sure to go the package section where you will be able to check on the reports with detail.

* You will find the logs on the target folder by the name test-automation.log

#### Explanation on used dependencies

* Maven with surefire plugin. 
    - Maven makes easy to manage the dependencies, set properties, and environment variables.
    - Surefire plugin made it easier to execute tests, and handle parallel execution as well
* Allure reports
    - Easy dependency to add, very nice UI for presenting reports, easy to integrate with TestNG for logging, 
    screen capturing, recording, etc.
* Log4j for logging
    - Pretty standard and straightforward for logging, easy to configure and set up.
* TestNG.
    - Standard for managing test suite structures with Java
* Hamcrest matchers
    - Good library for managing matchers on java, helps to define a standar way to use assertions with a lot of useful matches and easy to extend to create new custom matchers. 
* IntelliJ IDE
* This was tested on a Ubuntu/Linux environment as I did not have access to Mac environment

* Missing functionality: When Running in multiple threads we still need to do some extra 
configuration on Log4j and Allure reports to avoid any side problems that comes with running
tests in parallel.