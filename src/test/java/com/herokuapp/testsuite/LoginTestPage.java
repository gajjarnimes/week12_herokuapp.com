package com.herokuapp.theinternet.testsuite;

import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.testbase.BaseTest;
import com.herokuapp.theinternet.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestPage extends BaseTest {
    LoginPage loginPage = new LoginPage();
    @Test
    public void UserShouldLoginSuccesfullyWithValidCredentials() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        loginPage.SecureArea();
        String expectedText = "You logged into a secure area!";
        String actualText = loginPage.SecureArea();
        Assert.assertEquals(actualText, expectedText, "You logged into a secure area!");
    }
    @Test
    public void VerifyTheUsernameErrorMessage() {
        loginPage.enterUsername("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        loginPage.getErrorMessage();
        String expectedText = "Your username is invalid!";
        String actualText = loginPage.getErrorMessage();
        Assert.assertEquals(actualText, expectedText, "Your username is invalid!");
    }
    @Test
    public void VerigyThePasswordErrorMessage(){
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        loginPage.getErrorMessage();
        String expectedText ="Your password is invalid!";
        String actualText = loginPage.getErrorMessage();
        Assert.assertEquals(actualText,expectedText,"Your password is invalid!");
    }




    }

