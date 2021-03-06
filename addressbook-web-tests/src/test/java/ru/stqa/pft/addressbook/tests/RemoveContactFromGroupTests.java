package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test 1"));
            app.goTo().home();
        }
        if (app.db().contacts().size() == 0) {
            app.goTo().addForm();
            app.contact().create(new ContactData().withFirstname("Nikitos").withLastname("Lagutchev"));
        }

    }
        @Test
        public void testRemoveContactFromTheGroup () {
            Contacts beforeContacts = app.db().contacts();
            ContactData selectContact = beforeContacts.iterator().next();
            Groups beforeGroups = app.db().groups();
            GroupData selectGroup = beforeGroups.iterator().next();
            if (selectContact.getGroups().isEmpty() || !selectContact.getGroups().contains(selectGroup)) {
                app.contact().selectGroupByName("[all]");
                app.contact().add(selectContact, selectGroup);
                assertThat(selectContact.getGroups().withAdded(selectGroup), equalTo(app.db().contacts().stream()
                        .filter((c) -> c.getId() == selectContact.getId()).collect(Collectors.toList()).get(0).getGroups()));
                app.goTo().home();
            }
            app.contact().remove(selectContact, selectGroup);
            app.goTo().home();
            app.contact().selectGroupByName("[all]");
            assertThat(selectContact.getGroups().without(selectGroup), equalTo(app.db().contacts().stream().
                    filter((c) -> c.getId() == selectContact.getId()).collect(Collectors.toList()).get(0).getGroups()));
        }
    }