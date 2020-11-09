package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationsTests extends TestBase {


  @Test
  public void testGroupCreations() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().newGroup();
    app.getGroupHelper().createNewGroup(new GroupData("Nikitosiki", "test", "testNikitosik"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    app.logout();
  }
}
