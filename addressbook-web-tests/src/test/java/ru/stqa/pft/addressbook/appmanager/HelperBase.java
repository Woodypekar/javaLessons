package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.tests.TestBase;

public class HelperBase extends TestBase {

    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd=wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null){
            String existingText = wd.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public void list(By locator, String text) {
      wd.findElement(locator).click();
      new Select(wd.findElement(locator)).selectByVisibleText(text);
      wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        try{
          wd.findElement(locator);
          return true;
        } catch (NoSuchElementException ex) {
          return false;
        }
    }
}
