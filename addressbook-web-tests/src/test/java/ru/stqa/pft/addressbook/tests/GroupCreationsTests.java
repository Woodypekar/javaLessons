package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationsTests extends TestBase {


  @Test
  public void testGroupCreations() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().newGroup();
    GroupData group = new GroupData().withName("Nikitosiki");
    app.group().create(group);
    app.group().submit();
    app.group().returnToGroupPage();
    Groups after = app.group().all();

    assertThat(after.size(),equalTo( before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}
