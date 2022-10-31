package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "join_neu_email_field")
    public WebElement usernameText;

    @FindBy(id = "join_neu_password_field")
    public WebElement passwordText;

    @FindBy(xpath = "//button[@class='wt-btn wt-btn--primary wt-width-full']")
    public WebElement loginButton;


    /**
    * This method will accept username and password and login to app
    * @param username
    * @param password
    * */
    public void login(String username,String password){
        usernameText.sendKeys(username);
        passwordText.sendKeys(password);
        loginButton.click();
    }

}
