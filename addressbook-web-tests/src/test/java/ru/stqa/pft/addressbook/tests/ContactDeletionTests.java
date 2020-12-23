package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testDeletionContact(){
        if (! app.getContactHelper().isThereAContact()) {
            app.goTo().goToAddForm();
            app.getContactHelper().addNewContact(new ContactData("Nikitos", "Andreevich", "Lagutchev", "Woodypekar", "moka", "NIC", "jopa", "98745", "98745",
                    "321315", "156465", "asdasd.ru", "fafsa.ru", "wqe.ru", "popadalavo", "12", "May", "1234", "17", "November", "7654", "Nikitosiki",
                    "irapopa", "popaira", "notes"), true);
            app.getContactHelper().submitNewContact();
            app.goTo().goToHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().deleteSelectedContact(before.size() - 1);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);
    }
}
