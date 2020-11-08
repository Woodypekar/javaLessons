package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class ContactCreationsTests extends TestBase{


  @Test
  public void testGroupCreations() throws Exception {
    goToAddForm();
    addNewContact(new ContactData("Nikitos", "Andreevich", "Lagutchev", "Woodypekar", "moka", "NIC", "jopa", "98745", "98745", "98745", "98745", "mail.ru", "mail2.ru", "mail3.ru", "popa", "10", "May", "1234", "17", "November", "7654", "Nikitosiki", "irapopa", "popaira", "notes"));
    goToHomePage();
    logout();
  }

}