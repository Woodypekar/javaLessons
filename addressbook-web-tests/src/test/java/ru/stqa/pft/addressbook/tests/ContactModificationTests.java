package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{


    @BeforeMethod
    public void ensurePrediction(){
        if (app.contact().all().size() == 0) {
            app.goTo().addForm();
            app.contact().createContact(new ContactData().withFirstname("Nikitos").withLastname("Lagutchev"), true);
            app.contact().submit();
            app.goTo().homePage();
        }
    }

    @Test
    public void testModificationsContact(){
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Nikitos").withLastname("Lagutchev").withBday("12").withBmonth("May").withByear("1234")
                .withAday("17").withAmonth("November").withAyear("7654").withGroup("Nikitosiki");
        app.contact().modifyContact(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();

        assertThat(after,equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
