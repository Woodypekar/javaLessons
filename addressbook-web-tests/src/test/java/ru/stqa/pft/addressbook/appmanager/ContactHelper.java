package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void createContact(ContactData contactData, boolean creation) {
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


  public int count() {
    return wd.findElements(By.xpath("//tr[@name='entry']")).size();
  }

  public void submit() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void modify(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();

  }

  public void submitModify() {
    wd.findElement(By.xpath("(//input[@name='update'])[2]")).click();
  }

  public void delete(ContactData contact){
      selectContactById(contact.getId());
      wd.findElement(By.xpath("//input[@value='Delete']")).click();
      wd.switchTo().alert().accept();
      contactCache = null;
    }
  public void modifyContact(ContactData contact) {
    modify(contact.getId());
    createContact(contact,false);
    contactCache = null;
    submitModify();
  }

  public void create(ContactData contact) {
    app.contact().createContact(contact, true);
    app.contact().submit();
    contactCache = null;
  }
    public boolean isThereAContact(){
      return isElementPresent(By.name("selected[]"));
    }

  private Contacts contactCache = null;

    public Contacts all() {

      if (contactCache != null) {
        return new Contacts(contactCache);
      }

      contactCache = new Contacts();
      List<WebElement> elements = wd.findElements(By.xpath("//tr[contains(@name ,'entry')]"));
      for (WebElement element : elements){
        String firstname = element.findElements(By.tagName("td")).get(2).getText();
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));//?
        String lastname = element.findElement(By.xpath("//td[2]")).getText();
        ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
        contactCache.add(contact);
      }
      return new Contacts(contactCache);
    }
}
