package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationsTests extends TestBase {


  @Test
  public void testGroupCreations() {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().newGroup();
    GroupData group = new GroupData("Nikitosiki2", null, null);
    app.getGroupHelper().createNewGroup(group);    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getIdOfGroup(), g2.getIdOfGroup());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);


    app.logout();
  }
}
