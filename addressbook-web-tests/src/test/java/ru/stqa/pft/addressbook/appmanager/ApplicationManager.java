package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost:8080/addressbook");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }


    public void logout() {
      wd.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        wd.quit();
    }

    public void goToHomePage() {
      wd.findElement(By.linkText("home page")).click();
    }

    public void addNewContact(ContactData contactData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
      wd.findElement(By.name("middlename")).clear();
      wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
      wd.findElement(By.name("title")).click();
      wd.findElement(By.name("title")).clear();
      wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
      wd.findElement(By.name("company")).clear();
      wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
      wd.findElement(By.name("work")).clear();
      wd.findElement(By.name("work")).sendKeys(contactData.getWorkPhone());
      wd.findElement(By.name("fax")).clear();
      wd.findElement(By.name("fax")).sendKeys(contactData.getFaxPhone());
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contactData.getEmail1());
      wd.findElement(By.name("email2")).clear();
      wd.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
      wd.findElement(By.name("email3")).clear();
      wd.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
      wd.findElement(By.name("homepage")).clear();
      wd.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
      wd.findElement(By.name("theform")).click();
      wd.findElement(By.name("bday")).click();
      new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
      wd.findElement(By.name("bday")).click();
      wd.findElement(By.name("bmonth")).click();
      new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
      wd.findElement(By.name("bmonth")).click();
      wd.findElement(By.name("byear")).click();
      wd.findElement(By.name("byear")).clear();
      wd.findElement(By.name("byear")).sendKeys(contactData.getByear());
      wd.findElement(By.name("aday")).click();
      new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAday());
      wd.findElement(By.name("aday")).click();
      wd.findElement(By.name("amonth")).click();
      new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAmonth());
      wd.findElement(By.name("amonth")).click();
      wd.findElement(By.name("ayear")).click();
      wd.findElement(By.name("ayear")).clear();
      wd.findElement(By.name("ayear")).sendKeys(contactData.getAyear());
      wd.findElement(By.name("new_group")).click();
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      wd.findElement(By.name("new_group")).click();
      wd.findElement(By.name("address2")).click();
      wd.findElement(By.name("address2")).clear();
      wd.findElement(By.name("address2")).sendKeys(contactData.getAddress2());
      wd.findElement(By.name("phone2")).clear();
      wd.findElement(By.name("phone2")).sendKeys(contactData.getPhone2());
      wd.findElement(By.name("notes")).clear();
      wd.findElement(By.name("notes")).sendKeys(contactData.getNotes());
      wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
