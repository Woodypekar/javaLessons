package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.mantis.model.Users;
import ru.stqa.pft.mantis.model.UsersData;

import java.util.List;

public class UsersHelper extends HelperBase {

    private Users usersCache = null;

    public UsersHelper(ApplicationManager app) {
        super(app);
    }

    public void loginAs(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login.php");
        type(By.name("username"), username);
        click(By.xpath("//input[@type='submit']"));
        type(By.name("password"), password);
        click(By.xpath("//input[@type='submit']"));
    }

    public void openUserSettings() {
        click(By.id("menu-toggler"));
        click(By.xpath("//span[text()[contains(.,'Управление')]]"));
        click(By.xpath("//a[text()[contains(.,'Управление пользователями')]]"));
    }

    public void resetUserPassword(String username) {
        click(By.xpath(String.format("//a[contains(text(),'%s')]", username)));
        click(By.xpath("//input[@value='Сбросить пароль']"));
    }

    public void passwordResetConfirmation(String confirmationLink, String username, String password) {
        wd.get(confirmationLink);
        type(By.name("realname"), username);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.xpath("//button[@type='submit']"));
    }

    public Users all() {
        if (usersCache != null) {
            return new Users(usersCache);
        }
        
        usersCache = new Users();
        WebElement table = wd.findElement(By.xpath("//table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            String username = cols.get(0).getText();
            String email = cols.get(2).getText();
            UsersData user = new UsersData().withUsername(username).withEmail(email);
            usersCache.add(user);
        }
        return new Users(usersCache);
    }
}