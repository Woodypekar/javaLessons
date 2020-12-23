package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationsTests extends TestBase {


  @Test
  public void testGroupCreations(){
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().goToAddForm();
    ContactData contact = new ContactData("Nikitos", "Andreevich", "Lagutchev", "Woodypekar", "moka", "NIC", "jopa", "98745", "98745",
            "98745", "98745", "mail.ru", "mail2.ru", "mail3.ru", "popadalavo", "12", "May", "1234", "17", "November", "7654", "Nikitosiki",
            "irapopa", "popaira", "notes");
    app.getContactHelper().addNewContact(contact, true);
    app.getContactHelper().submitNewContact();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getIdOfContact(), g2.getIdOfContact());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}