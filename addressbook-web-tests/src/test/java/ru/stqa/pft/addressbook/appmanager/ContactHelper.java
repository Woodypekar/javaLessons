package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

  public void initModificationContact(int index) {
    wd.findElements(By.xpath("(//img[@alt='Edit'])")).get(index).click();

  }

  public void submitModificationContact() {
    wd.findElement(By.xpath("(//input[@name='update'])[2]")).click();
  }

  public void deleteSelectedContact(int index){
      wd.findElements(By.name("selected[]")).get(index).click();
      wd.findElement(By.xpath("//input[@value='Delete']")).click();
      wd.switchTo().alert().accept();
    }
    public boolean isThereAContact(){
      return isElementPresent(By.name("selected[]"));
    }


    public List<ContactData> getContactList() {
      List<ContactData> contacts = new ArrayList<ContactData>();
      List<WebElement> elements = wd.findElements(By.xpath("//tr[contains(@name ,'entry')]"));
      for (WebElement element : elements){
        String firstname = element.findElements(By.tagName("td")).get(2).getText();
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));//?
        String lastname = element.findElement(By.xpath("//td[2]")).getText();
        ContactData contact = new ContactData(id, firstname, lastname,null,null,null,null,null,null);
        contacts.add(contact);
      }
      return contacts;
    }
}
