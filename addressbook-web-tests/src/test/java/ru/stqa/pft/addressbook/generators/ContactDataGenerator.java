package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContact(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if ((format.equals("xml"))) {
            saveAsXml(contacts, new File(file));
        } else if ((format.equals("json"))) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }


    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        try (Writer writer = new FileWriter(file)){
            for (ContactData contact : contacts) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n"
                        , contact.getFirstname(), contact.getLastname()
                        , contact.getAddress(), contact.getHomePhone(), contact.getMobilePhone(), contact.getEmail1()
                        , contact.getEmail2(), contact.getEmail3(), contact.getBday(), contact.getBmonth()
                        , contact.getByear(), contact.getAday(),contact.getAmonth(),contact.getAyear(),contact.getPhoto()));
            }
        }
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)){
            writer.write(xml);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson =new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try(Writer writer = new FileWriter(file)){
            writer.write(json);
        }
    }

    private List<ContactData> generateContact(int count) {
        File photo = new File("src/test/resources/dog.png");
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstname(String.format("Nikitos %s", i)).withLastname(String.format("Lagutchev %s", i))
                    .withAddress(String.format("Asd %s", i)).withHomePhone(String.format("111 %s", i))
                    .withMobilePhone(String.format("231 %s", i)).withWorkPhone(String.format("321 %s", i)).withEmail1(String.format("hghggh@mail.ru %s", i))
                    .withEmail2(String.format("vbvbv@mail.ru %s", i)).withEmail3(String.format("ajdjhaljs@mail.ru %s", i))
                    .withBday("12").withBmonth("May").withByear("1234").withAday("15").withAmonth("November").withAyear("7654")
                    .withPhoto(photo));
        }
        return contacts;
    }
}
