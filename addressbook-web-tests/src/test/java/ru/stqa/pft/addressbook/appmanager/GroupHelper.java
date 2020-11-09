package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase{

    public GroupHelper(FirefoxDriver wd) {

        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void createNewGroup(GroupData groupData) {
      type(By.name("group_name"), groupData.getNameOfGroup());
      type(By.name("group_header"), groupData.getHeaderOfGroup());
      type(By.name("group_footer"), groupData.getFooterOfGroup());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void newGroup() {
        click(By.name("new"));
    }
}
