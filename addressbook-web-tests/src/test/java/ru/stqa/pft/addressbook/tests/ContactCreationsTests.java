package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationsTests extends TestBase {


  @Test
  public void testContactCreations(){
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/dog.png");
    ContactData contact = new ContactData().withFirstname("Nikitos").withLastname("Lagutchev").withBday("12").withBmonth("May").withByear("1234")
            .withAday("17").withAmonth("November").withAyear("7654").withGroup("Nikitosiki").withPhoto(photo);
    app.goTo().addForm();
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


}