package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.Hook;

public class BoardPage {
    @FindBy(how = How.XPATH, using = "//a[@class='board-header-btn board-header-btn-name no-edit']")
    private WebElement boardName;
    @FindBy(how = How.XPATH, using = "//div[div[textarea[@aria-label='To Do']]]/a")
    private WebElement toDoList;
    @FindBy(how = How.XPATH, using = "")
    private WebElement addCardButton;
    @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Insira um título para este cartão...']")
    private WebElement txtComment;

    String cardName;

    public BoardPage(){
        PageFactory.initElements(Hook.getDriver(), this);
    }

    public BoardPage accessBoard(){
        Hook.getDriver().get("https://trello.com/b/ICLxsmNI/automationprime");
        return this;
    }

}
