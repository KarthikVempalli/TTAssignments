Steps to execute
________________

Pre Requisites

1) Make sure application URL https://www.saucedemo.com/ up and running
2) Make sure TTAssignments is downloaded from GitHub to a workspace
3) Using Eclipse IDE import Maven Project selecting pom.xml file in TTAssignment 


Configuration to run Saucedemo shopping cart testcase and API posts testcase
___________________________________________________________________________

1) Configure SauceDemo_URL with application URL,Browser type with chrome or firefox or ie in the ProjectConfig.properties
2) Configure Jsonplaceholder_URL with https://jsonplaceholder.typicode.com/posts in the ProjectConfig.properties
3) Open RunManager.xls file from TTAssignments/Execution folder,
   i) In WEB_APP excel sheet make sure column "Run" is configured with "Yes" to run desired testcase(s)
  ii) In WEB_APP_TD excel sheet, to run Saucedemo shopping cart testcase provide test data in columns UserName, Password, First Name, Last Name, Postal Code.
 iii) In WEB_APP_TD excel sheet, to run  API posts testcase provide test data in columns UserId, id, title, body.

4) Run TestSuiteCreator.java file in the path "src\main\java\automation\core\frameworkExecution\TestSuiteCreator.java", As Java Application.
5) Run executionUpdate.xml from TTAssignments/Execution folder as TestNG Suite.

Verifying test run Reports
_______________________

1) Check and open HTML report genrated in the path TTAssignments\Reports for example :Test-Output20220702124824.html.


