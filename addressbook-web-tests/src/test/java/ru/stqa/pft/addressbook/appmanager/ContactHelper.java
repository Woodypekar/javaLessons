package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void addNewContact(ContactData contactData, boolean creation) {
      type(By.name("firstname"), contactData.getFirstname());
      type(By.name("middlename"), contactData.getMiddlename());
      type(By.name("lastname"), contactData.getLastname());
      type(By.name("nickname"), contactData.getNickname());
      type(By.name("title"), contactData.getTitle());
      type(By.name("company"), contactData.getCompany());
      type(By.name("address"), contactData.getAddress());
      type(By.name("home"), contactData.getHomePhone());
      type(By.name("mobile"), contactData.getMobilePhone());
      type(By.name("work"), contactData.getWorkPhone());
      type(By.name("fax"), contactData.getFaxPhone());
      type(By.name("email"), contactData.getEmail1());
      type(By.name("email2"), contactData.getEmail2());
      type(By.name("email3"), contactData.getEmail3());
      type(By.name("homepage"), contactData.getHomepage());
      list(By.name("bday"), contactData.getBday());
      list(By.name("bmonth"), contactData.getBmonth());
      type(By.name("byear"), contactData.getByear());
      list(By.name("aday"), contactData.getAday());
      list(By.name("amonth"), contactData.getAmonth());
      type(By.name("ayear"), contactData.getAyear());
      if (creation){
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
      type(By.name("address2"), contactData.getAddress2());
      type(By.name("phone2"), contactData.getPhone2());
      type(By.name("notes"), contactData.getNotes());
    }


  public void submitNewContact() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void initModificationContact() {
    wd.findElement(By.xpath("(//img[@alt='Edit'])")).click();

  }

  public void submitModificationContact() {
    wd.findElement(By.xpath("(//input[@name='update'])[2]")).click();
  }

  public void deleteSelectedContact(){
      wd.findElement(By.name("selected[]")).click();
      wd.findElement(By.xpath("//input[@value='Delete']")).click();
      wd.switchTo().alert().accept();
    }
    public boolean isThereAContact(){
      return isElementPresent(By.name("selected[]"));
    }


}
