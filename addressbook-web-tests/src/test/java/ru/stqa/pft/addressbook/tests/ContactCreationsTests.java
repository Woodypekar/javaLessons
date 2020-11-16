package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationsTests extends TestBase {


  @Test
  public void testGroupCreations(){
    app.getNavigationHelper().goToAddForm();
    app.getContactHelper().addNewContact(new ContactData("Nikitos", "Andreevich", "Lagutchev", "Woodypekar", "moka", "NIC", "jopa", "98745", "98745",
            "98745", "98745", "mail.ru", "mail2.ru", "mail3.ru", "popadalavo", "12", "May", "1234", "17", "November", "7654", "irapopa",
            "popaira", "notes"));
    app.getContactHelper().addContactToGroup("Nikitosiki");
    app.getContactHelper().submitNewContact();
    app.goToHomePage();
    app.logout();
  }

}