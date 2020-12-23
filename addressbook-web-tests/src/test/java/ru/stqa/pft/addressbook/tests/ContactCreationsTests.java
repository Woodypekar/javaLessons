package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationsTests extends TestBase {


  @Test
  public void testGroupCreations(){
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Nikitos").withLastname("Lagutchev").withBday("12").withBmonth("May").withByear("1234")
            .withAday("17").withAmonth("November").withAyear("7654").withGroup("Nikitosiki");
    app.goTo().addForm();
    app.contact().create(contact, true);
    app.contact().submit();
    app.goTo().homePage();
    Contacts after = app.contact().all();

    assertThat(after.size(),equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


}