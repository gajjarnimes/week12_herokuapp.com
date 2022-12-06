package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By Username = By.id("username");
    By Password = By.id("password");
    By LoginButton = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
    By YouloggedintoSecurarea =By.xpath("//div[@ class='flash success']");
    By errorMessage = By.xpath("//div[@ class='flash error']");

    public void enterUsername(String UsernameText) {
        sendTextToElement(Username, UsernameText);
    }

    public void enterPassword(String PasswordText) {
        sendTextToElement(Password, PasswordText);
    }

    public void clickOnLoginButton() {
        clickOnElement(LoginButton);
    }
    public String SecureArea(){
        return getTextFromElement(YouloggedintoSecurarea);
    }

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }
}





