package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.List;

public class DeskTopsTest extends Utility {
//● Create the package name desktops
//1. Create class “DesktopsTest

    @Before
    public void setUp() {
        openBrowser();
    }

    //Write the following Test:
// 1.Test name verifyProductArrangeInAlphabeticalOrder()
    public void selectMenuAndClick(String menu) {
        WebElement menu1 = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).click().build().perform();
    }

    @Test
    public void verifyProductsArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverAndClickOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        //1.2 Click on “Show All Desktops”
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //1.3 Select Sort By position "Name: Z to A"

        selectFromVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

        //  1.4 Verify the Product will arrange in Descending order.
        List<WebElement> productNameElements = driver.findElements(By.xpath(".product-layout .caption h4 a"));

        int count = productNameElements.size();
        for (int i = 0; i < count - 1; i++) {
            String productName1 = productNameElements.get(i).getText();
            String productName2 = productNameElements.get(i + 1).getText();
            Assert.assertTrue(productName1.compareToIgnoreCase(productName2) >= 0);
        }
    }

    @Test
//2. Test name verifyProductAddedToShoppingCartSuccessFully()
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverAndClickOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        //2.2 Click on “Show All Desktops”
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        driver.findElement(By.xpath("//select[@id='input-sort']")).click();
//2.3 Select Sort By position "Name: A to Z"
        selectFromVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");

//2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));

        //2.5 Verify the Text "HP LP3065"
        verifyTextElement("HP LP3065", By.xpath("//h1[contains(text(),'HP LP3065')]"));

        //2.6 Select Delivery Date "2022-11-30"
        driver.findElement(By.xpath("//input[@id='input-option225']")).clear();
        driver.findElement(By.xpath("//input[@id='input-option225']")).sendKeys("2022-11-30");
        Thread.sleep(5000);


        // 2.7 Enter Qty '1' using Select class.
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        //  sendTextFromElement(By.xpath("//input[@id='input-quantity']"), "1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        // 2.9 Verify the Message “Success:
        verifyTextElement("Success: You have added HP LP3065 to your shopping cart!\n" +
                "×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //You have added HP LP3065 to your shopping cart !
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.11 Verify the text "Shopping Cart"
        verifyTextElement("Shopping Cart", By.xpath("//a[contains(text(),'Shopping Cart')]"));

        // 2.12 Verify the Product name "HP LP3065"
        verifyTextElement("HP LP3065", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));

        // 2.13 Verify the Delivery Date "2022-11-30"
        verifyTextElement("Delivery Date:2022-11-30", By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"));

        // 2.14 Verify the Model "Product21"
        verifyTextElement("Product 21", By.xpath("//td[contains(text(),'Product 21')]"));

        //2.15 Verify the Total "£74.73"
        verifyTextElement("$122.00", By.xpath("//tbody/tr[1]/td[6]"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
