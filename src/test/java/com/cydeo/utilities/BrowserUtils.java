package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    //Methods are static, Because we do not want to create an object to call those methods.
    //We just want to call those methods with class name. That is why they are static type

    /**
     * This method is used to pause the code for given seconds
     * It is static method we can call with class name
     * BrowserUtils.sleep(3)
     *
     * @param seconds
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception happened in sleep method");
        }
    }

    /*
    Method info:
    • Name: verifyTitle()
    • Return type: void
    • Arg1: WebDriver
    • Arg2: String expectedTitle
    public static void verifyTitle()
    BrowserUtils.verifyTitle(driver, "Google");
    */
    public static void verifyTitle(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public static void verifyTitleContains(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
    * This method will accept dropdown as a WebElement and return all options' text in a list of string
     * @return List<String>
    * */
    public static List<String> dropdownOptionsAsString(WebElement dropdown){
        Select select = new Select(dropdown);

        // List of all actual month <options> as a WebElement
        List<WebElement> options = select.getOptions();

        // List of all actual month options as a String
        List<String> optionsAsString = new ArrayList<>();

        // With using for loop we will convert each WebElement of options to String with using getText() method
        // With using add() method we will add each String option in List<string> actual options as a String
        for (WebElement option : options) {
            optionsAsString.add(option.getText());
        }

        return optionsAsString;
    }


    /**
     * This method will accept a group of radio buttons as a List<WebElement>
     * It will loop through the List, and click to the radio buttons with provide attribute value
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons,String attributeValue){
        for (WebElement element : radioButtons) {
            if (element.getAttribute("value").equalsIgnoreCase(attributeValue)){
                element.click();
            }
        }
    }

}
