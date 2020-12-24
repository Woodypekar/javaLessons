package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePrediction(){
        if (app.db().contacts().size() == 0) {
            app.goTo().addForm();
            app.contact().createContact(new ContactData().withFirstname("Nikitos").withLastname("Lagutchev").withBday("12").withBmonth("May").withByear("1234")
                    .withAday("17").withAmonth("November").withAyear("7654").withGroup("Nikitosiki"), true);
            app.contact().submit();
            app.goTo().homePage();
        }
    }

    @Test
    public void testDeletionContact(){

        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().contacts();

        assertThat(after,equalTo(before.without(deletedContact)));
    }
}
