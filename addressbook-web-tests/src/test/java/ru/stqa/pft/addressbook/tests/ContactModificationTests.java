package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{


    @Test
    public void testModificationsContact(){
        app.getContactHelper().initModificationContact();
        app.getContactHelper().modificationContact(new ContactData("Nikitos", "Andreevich", "Lagutchev", "Woodypekar", "moka", "NIC", "jopa", "98745", "98745",
                "98745", "98745", "mail.ru", "mail2.ru", "mail3.ru", "popadalavo", "12", "May", "1234", "17", "November", "7654", "Nikitosiki",
                "irapopa", "popaira", "notes"));
        app.getContactHelper().submitModificationContact();
        app.goToHomePage();
        app.logout();
    }
}
