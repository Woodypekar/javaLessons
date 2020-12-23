package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

=======
>>>>>>> parent of b9dea0b... 4.9 работает
=======
>>>>>>> parent of b9dea0b... 4.9 работает
=======
>>>>>>> parent of b9dea0b... 4.9 работает
public class GroupModificationTests extends TestBase{
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().newGroup();
            app.getGroupHelper().createNewGroup(new GroupData("Nikitosiki", null, null));
            app.getGroupHelper().submitGroupCreation();
            app.getGroupHelper().returnToGroupPage();
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().createNewGroup(new GroupData("Nikitosiki", "test", "testNikitosik"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getIdOfGroup(), g2.getIdOfGroup());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
=======
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
>>>>>>> parent of b9dea0b... 4.9 работает
=======
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
>>>>>>> parent of b9dea0b... 4.9 работает
=======
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
>>>>>>> parent of b9dea0b... 4.9 работает
        app.logout();
    }

}
