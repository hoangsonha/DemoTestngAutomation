[![Java CI with Maven](https://github.com/hoangsonha/DemoTestngAutomation/actions/workflows/maven.yml/badge.svg)](https://github.com/hoangsonha/DemoTestngAutomation/actions/workflows/maven.yml)

# Welcome to testNG Repository

## User Guides

### To create project Maven to use testNG in Netbeans 21

#### Step 1 : File -> New Project -> Choose Java with Maven -> Java Application -> Fill some infor such as : Name, Version, Location, ...

#### Step 2 : Import Dependances in Maven Repo, include testng (to use testNG), selenium (to test and demo the action of user in Web Browser), webdrivermanager (to manager driver such as chromedriver) in file pom.xml

#### Step 3 : Create testNG by right-click on your project and click New -> Other -> Choose Unit Tests -> TestNG Test Case

#### Step 4 : Add anotation @Test above method you want to test. In method, you can test some method in src of your project and this method will send you neither red or green when you run this method which contains @Test at the top

## Main function

#### Unit test
- Test function calculate the amount of day in year, input is today with 6 test case and return well

#### Test automation
- Test login with 3 test case for user login with their role success or fail
- Test add cart with 1 test case for user add 1 product into cart success
- Test add cart with 1 test case for user add multiple products into cart success
- Test update quantity product in cart with 1 test case for user update quantity product in cart success
- Test delete cart with 1 test case for user delete 1 product in cart success
- Test search with 2 test case for search success or fail
- Test create order when user create order success or fail

## Screenshots

### Login when email and password is correct

![Source code and test script](https://github.com/hoangsonha/DemoTestngAutomation/blob/main/screenshots/testLoginWithEmailAndPassCorrect.png)

### Connect me via: hoangsonhadev@gmail.com

#### &#169; 2024 Son Ha



