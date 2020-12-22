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
    app.getGroupHelper().createNewGroup(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.setIdOfGroup(after.stream().max((o1, o2) -> Integer.compare(o1.getIdOfGroup(), o2.getIdOfGroup())).get().getIdOfGroup());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    app.logout();
  }
}
