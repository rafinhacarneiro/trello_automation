package pom;

import com.google.common.base.Objects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.Hook;

import java.util.List;

import static util.Tools.waitBy;

public class CardList {

    @FindBy(how = How.XPATH, using = "//div[div[textarea[@aria-label='To Do']]]/a")
    private WebElement addCardButton;
    @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Insira um título para este cartão...']")
    private WebElement txtComment;
    @FindBy(how=How.XPATH, using = "//input[@value='Adicionar Cartão']")
    private WebElement submitButton;
    @FindBy(how=How.XPATH,using = "//div[div/h2[text()='To Do']]//span[contains(@class, 'list-card-title')]")
    private List<WebElement> cardsToDo;

    String cardName;

    public CardList(){
        PageFactory.initElements(Hook.getDriver(), this);
    }

    // Cria um card
    public CardList createCard(String cartaoNome){
        waitBy(addCardButton).click();

        cardName = cartaoNome;
        waitBy(txtComment).sendKeys(cartaoNome);
        waitBy(submitButton).click();

        return this;
    }

    // Verifica se o card foi criado
    public Boolean checkCreatedCard(){
        Boolean exists = false;

        for(WebElement e : cardsToDo){
            if(Objects.equal(cardName, e.getText())){
                exists = true;
            }
        }

        return exists;
    }

    // Verifica se um card específico existe
    public Boolean checkFor(String card){
        Boolean exists = false;

        for(WebElement e : cardsToDo){
            if(Objects.equal(card, e.getText())){
                exists = true;
            }
        }

        return exists;
    }

}
