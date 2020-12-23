package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

<<<<<<< HEAD
import java.util.Comparator;
import java.util.List;

=======
>>>>>>> parent of b9dea0b... 4.9 работает
public class GroupCreationsTests extends TestBase {


  @Test
  public void testGroupCreations() {
    int before = app.getGroupHelper().getGroupCount();
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().newGroup();
    app.getGroupHelper().createNewGroup(new GroupData("Nikitosiki", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
<<<<<<< HEAD
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getIdOfGroup(), g2.getIdOfGroup());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
=======
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
>>>>>>> parent of b9dea0b... 4.9 работает
    app.logout();
  }
}
