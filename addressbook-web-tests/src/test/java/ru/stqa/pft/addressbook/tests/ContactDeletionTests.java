package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testDeletionContact(){
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToAddForm();
            app.getContactHelper().addNewContact(new ContactData("Nikitos", "Andreevich", "Lagutchev", "Woodypekar", "moka", "NIC", "jopa", "98745", "98745",
                    "321315", "156465", "asdasd.ru", "fafsa.ru", "wqe.ru", "popadalavo", "12", "May", "1234", "17", "November", "7654", "Nikitosiki",
                    "irapopa", "popaira", "notes"), true);
            app.getContactHelper().submitNewContact();
            app.getNavigationHelper().goToHomePage();
        }
        app.getContactHelper().deleteSelectedContact();
        app.logout();
    }
}
