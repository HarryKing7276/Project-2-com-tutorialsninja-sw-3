package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

/**
 * ● Create the package homepage
 * 1. create class "TopMenuTest
 */

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser();
    }
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type String
    //1.2 This method should click on the menu whatever name is passed as parameter.

    public void selectMenuAndClick(String menu) {
        WebElement menu1 = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).click().build().perform();
    }

    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverAndClickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenuAndClick("Show AllDesktops");
        //   1.3 Verify the text ‘Desktops’
        verifyTextElement("Desktops", By.xpath("//h2[contains(text(),'Desktops')]"));
    }

    //  2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNoteBooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenuAndClick("Show AllLaptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyTextElement("Laptops & Notebooks", By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'Laptops & Notebooks')]"));
    }

    //3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    @Test
    public void VerifyUserShouldNavigateToComponentsPageSuccessfully() {
        //  3.1 Mouse hover on “Components” Tab and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Components']"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenuAndClick("Show AllComponents");
        //3.3 Verify the text ‘Components
        verifyTextElement("Components", By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'Components')]"));


    }


    @After
    public void tearDown() {
        //closeBrowser();

    }
}