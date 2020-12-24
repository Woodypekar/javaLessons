package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationsTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validContactsFromCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))){
      String line = reader.readLine();
      while (line!=null){
        String[] split = line.split(";");
        list.add(new Object[] {new ContactData().withFirstname(split[0]).withLastname(split[1])
                .withAddress(split[2]).withHomePhone(split[3]).withMobilePhone(split[4]).withEmail1(split[5])
                .withEmail2(split[6]).withEmail3(split[7]).withBday(split[8]).withBmonth(split[9])
                .withByear(split[10]).withAday(split[11]).withAmonth(split[12]).withAyear(split[13]).withPhoto(new File(split[15]))});
        line = reader.readLine();
      }
    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }


  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))){
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {}.getType());//List<GroupData>.class
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }



  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) throws Exception {
    Contacts before = app.db().contacts();
    //File photo = new File("src/test/resources/dog.png");
    //ContactData contact = new ContactData().withFirstname("Nikitos").withLastname("Lagutchev").withBday("12").withBmonth("May").withByear("1234")
    //        .withAday("17").withAmonth("November").withAyear("7654").withGroup("Nikitosiki").withPhoto(photo);
    app.goTo().addForm();
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


}