package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver wd) {

        super (wd);
    }

    public void login(String logName, String password) {
        type(By.name("user"), logName);
        type(By.name("pass"), password);
    }

    public void submitLogin() {
        wd.findElement(By.id("LoginForm")).submit();
    }
}
