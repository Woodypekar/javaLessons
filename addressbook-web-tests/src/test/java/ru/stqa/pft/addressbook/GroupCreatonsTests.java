package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreatonsTests extends TestBase {


  @Test
  public void testGroupCreatons() throws Exception {
    goToGroupPage();
    createNewGroup(new GroupData("Nikitosiki", "test", "testNikitosik"));
    returnToGroupPage();
    logout();
  }
}
