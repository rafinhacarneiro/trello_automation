package pom;

import com.google.common.base.Objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.Hook;

import java.util.List;

import static util.Tools.waitBy;

public class SelectedCard {

    @FindBy(how = How.XPATH, using = "//div[@class='card-detail-window u-clearfix']//div[contains(@class, 'current-comment')]//p")
    private List<WebElement> commentsOnCard;
    @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Escrever um comentário...']")
    private WebElement textarea;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'comment-controls')]/input[@value='Salvar']")
    private WebElement submitButton;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'window-wrapper')]/a")
    private WebElement closeCardButton;
    @FindBy(how = How.XPATH, using = "//p[contains(@class, 'quiet')]/a[contains(@class, 'quiet-button')]")
    private WebElement cardOptions;
    @FindBy(how = How.XPATH, using = "//a[@class='js-delete']")
    private WebElement deleteOption;
    @FindBy(how = How.XPATH, using = "//input[@value='Excluir']")
    private WebElement confirmDelete;

    String comment;

    public SelectedCard(){
        PageFactory.initElements(Hook.getDriver(), this);
    }

    // Método para abrir um card
    public SelectedCard clickOn(String cardName){
        // XPATH do link do card
        String aXPATH = "//div[div/h2[text()='To Do']]//a[div[span[text()='"+ cardName +"']]]";
        WebElement e = Hook.getDriver().findElement(By.xpath(aXPATH));
        // Clica no card escolhido
        waitBy(e).click();

        return this;
    }

    // Método para comentar um card
    public SelectedCard writeComment(String text){
        this.comment = text;
        // Comenta no card
        waitBy(textarea).sendKeys(text);
        // Envia o comentário
        waitBy(submitButton).click();
        // Fecha o card
        waitBy(closeCardButton).click();

        return this;
    }

    // Método para verificar se o comentário foi feito
    public Boolean checkComment(){
        Boolean exists = false;

        for(WebElement e : commentsOnCard){
            if(Objects.equal(comment, e.getText())){
                exists = true;
            }
        }

        return exists;
    }

    // Método para excluir um card
    public void deleteCard() {
        // Clica em "Compartilhar e mais"
        waitBy(cardOptions).click();
        // Clica em excluir
        waitBy(deleteOption).click();
        // Confirma a exclusão
        waitBy(confirmDelete).click();
    }
}
