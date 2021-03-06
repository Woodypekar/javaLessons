package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver wd) {
        super (wd);

    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
      click(By.linkText("groups"));
    }

    public void home() {

        wd.findElement(By.linkText("home")).click();
    }
    public void homePage() {

        wd.findElement(By.linkText("home page")).click();
    }


    public void addForm() {
      click(By.linkText("add new"));
    }
}
