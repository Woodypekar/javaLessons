package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions (){
        app.goTo().groupPage();
        if (app.db().groups().size()==0){
            app.group().create(new GroupData().withName("test"));
        }
    }

    @Test
    public void testGroupModification() {
        if(Boolean.getBoolean("verifyUI")) {
            Groups before = app.db().groups();
            GroupData modifiedGroup = before.iterator().next();
            GroupData group = new GroupData()
                    .withId(modifiedGroup.getId()).withName("Nikitosiki")
                    .withHeader("nonoka").withFooter("pony");
            app.group().modify(group);
            assertThat(app.group().count(), equalTo(before.size()));
            Groups after = app.db().groups();
            assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
            verifyGroupListInUI();
        }
    }



}
