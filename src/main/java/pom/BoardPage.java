package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.Hook;

import static util.Tools.waitBy;

public class BoardPage {
    @FindBy(how = How.XPATH, using = "//a[@class='board-header-btn board-header-btn-name no-edit']")
    private WebElement boardName;

    public BoardPage(){
        PageFactory.initElements(Hook.getDriver(), this);
    }

    public BoardPage accessBoard(){
        Hook.getDriver().get("https://trello.com/b/ICLxsmNI/automationprime");
        return this;
    }

    public String checkBoardPage(){
        return waitBy(boardName).findElement(By.tagName("span")).getText();
    }

}
