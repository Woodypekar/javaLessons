package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationsTests extends TestBase {


  @Test
  public void testGroupCreations() {
    int before = app.getGroupHelper().getGroupCount();
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().newGroup();
    app.getGroupHelper().createNewGroup(new GroupData("Nikitosiki", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
    app.logout();
  }
}
