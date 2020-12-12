package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionsTests extends TestBase {

  @Test
  public void testGroupDeletionsTests(){
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().newGroup();
      app.getGroupHelper().createNewGroup(new GroupData("Nikitosiki", null, null));
      app.getGroupHelper().submitGroupCreation();
      app.getGroupHelper().returnToGroupPage();
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
    app.logout();
  }

}
