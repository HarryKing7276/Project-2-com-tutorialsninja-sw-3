package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;
//● Create package myaccounts
//1. Create the class MyAccountsTest

public class MyAccountsTest extends Utility {
    @Before
    public void setUp() {
        openBrowser();
    }

    @After
    public void TearDown() {
        //    closeBrowser();
    }

    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option) {
        //1.2 This method should click on the menu whatever name is passed as parameter.
        //(Hint: Handle List of Element and Select options)
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//a[@title='My Account']"));

    }


// Write the following test

    /**
     * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
     * 1.1 Clickr on My Account Link.
     * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
     * “Register”
     * 1.3 Verify the text “Register Account”.
     */
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        // 1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        //selectMyAccountOptions("Register");
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Register']"));

        //1.3 Verify the text “Register Account”.
        verifyTextElement("Register Account", By.xpath("//h1[normalize-space()='Register Account']"));
    }

    //2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login"
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
        // 2.3. Verify the text “Returning Customer”.
        verifyTextElement("Returning Customer", By.xpath("//h2[normalize-space()='Returning Customer']"));

    }

    @Test
//3. Test name verifyThatUserRegisterAccountSuccessfully()
    public void verifyUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter "Register"
        mouseHoverAndClickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "PrimeP");
//3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Pattel");
//3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "PppprimeP123@gmail.com");
        //  3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "786786786");
        //  3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "PrimeP1234");
//3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "PrimeP1234");
//3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));
        //3.12 Verify the message “Your Account Has Been Created!”
        verifyTextElement("Your Account Has Been Created!", By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        //3.13    3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Click on My Account Link
        clickOnElement(By.xpath("//span[@class='caret']"));
//3.15 Call the method “selectMyAccountOptions” method and pass the parameter "Logout"
        mouseHoverAndClickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));
//3.16 Verify the text “Account Logout”
        verifyTextElement("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"));
        // 3.17    3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    // 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        // 4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
//  4.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login"
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
//4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "PppprimeP123@gmail.com");
//4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "PrimeP1234");
//4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
//4.7 Verify text “My Account”
        verifyTextElement("My Account", By.xpath("//h2[contains(text(),'My Account')]"));
//4.8 Click on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
//4.9 Call the method “selectMyAccountOptions” method and pass the parameter "Logout"
        mouseHoverAndClickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));
//4.10 Verify the text “Account Logout”
        verifyTextElement("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"));
//4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }
}



