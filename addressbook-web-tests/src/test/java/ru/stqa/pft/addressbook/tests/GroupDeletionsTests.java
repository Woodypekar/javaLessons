package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions (){
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().newGroup();
      app.group().create(new GroupData().withName("Nikitosiki"));
      app.group().submit();
      app.group().returnToGroupPage();
    }
  }

  @Test
  public void testGroupDeletionsTests(){
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().all();

    assertEquals(after.size(), before.size() - 1);
    assertThat(after,equalTo(before.without(deletedGroup)));
  }


}
