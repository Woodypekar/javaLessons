package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{


    @Test
    public void testModificationsContact(){
        if (! app.getContactHelper().isThereAContact()) {
            app.goTo().goToAddForm();
            app.getContactHelper().addNewContact(new ContactData("Nikitos", "Andreevich", "Lagutchev", "Woodypekar", "moka", "NIC", "jopa", "98745", "98745",
                    "321315", "156465", "asdasd.ru", "fafsa.ru", "wqe.ru", "popadalavo", "12", "May", "1234", "17", "November", "7654", "Nikitosiki",
                    "irapopa", "popaira", "notes"), true);
            app.getContactHelper().submitNewContact();
            app.goTo().goToHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initModificationContact(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getIdOfContact(),"Nikitos", "Lagutchev","12","May","1234","17","November","7654");
        app.getContactHelper().addNewContact(contact,false);
        app.getContactHelper().submitModificationContact();
        app.goTo().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getIdOfContact(), c2.getIdOfContact());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
