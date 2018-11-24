package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.Hook;

public class LoginPage {
    @FindBy(how = How.ID, using = "user")
    private WebElement userInput;
    @FindBy(how = How.ID, using = "password")
    private WebElement passwordInput;
    @FindBy(how = How.ID, using = "login")
    private WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//a[@aria-label='Página Inicial do Trello']")
    private WebElement initialPage;

    public LoginPage(){
        PageFactory.initElements(Hook.getDriver(), this);
    }

    public LoginPage access(){
        Hook.getDriver().get("https://trello.com/login");
        return this;
    }

    public LoginPage doLogin(String user, String pass){
        userInput.sendKeys(user);
        passwordInput.sendKeys(pass);
        loginButton.click();
        return this;
    }

    public String checkInitialPage(){
        return initialPage.getAttribute("aria-label");
    }
}
