## README
#### Prerequisites
* Maven 3.6
* Java 1.8 
#### Installation
* Clone project 
#### Previos to run the tests
* Since we are using remote web driver, you must have already and up and running instance of selenium server with hub as a role

        java -jar selenium-server-standalone-_._._.jar -role hub
* Also you should have an up and running driver of the browser you will need pointing to the selenium server

        java -Dwebdriver.BROWSER.driver="PATH_TO_DRIVER/DRIVER" -jar selenium-server-standalone-_._._.jar -role webdriver -hub http://SERVER_ADDRESS:4444/grid/register -port PORT_NUMBER     

#### How to run tests
Basically there are 3 different scripts in the scripts folder (You may have to give execution permission to scripts on the first use. Use chmod +x script.sh) 
  * Run all the tests in one thread. 
          
        ./scripts/run-test.sh BROWSER SERVER 
        
       BROWSER: We are supporting for now firefox and chrome driver
       SERVER: Local selenium server url, like http://yourserver:4444/wd/hub
  * Run all the tests in parallel.  

         ./scripts/run-test.sh BROWSER SERVER THREADS
          
       BROWSER: We are supporting for now firefox and chrome driver
       SERVER: Local selenium server url, like http://yourserver:4444/wd/hub
       THREADS: Number of threads

#### Reports and Logs
* Since we are using allure reports, we should use the next script to bring up the local allure server. After that you can use ctrl-c to stop the server.

        ./scripts/show-reports.sh 

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
    - By far one of the best IDEs for java based projects 


