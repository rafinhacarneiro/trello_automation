package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pom.BoardPage;
import pom.CardList;
import pom.LoginPage;
import pom.SelectedCard;

public class TrelloStep {
    LoginPage loginPage;
    String cardName;

    @Dado("^que esteja logado no Trello$")
    public void queEstejaLogadoNoTrello() {

        // Abre a página de login
        loginPage = new LoginPage();
        loginPage.access();
        // Faz o login
        loginPage.doLogin("rafinhacarneiro@outlook.com", "trakinas06");
        // Verifica se o login foi realizado com sucesso
        Assert.assertEquals("Página Inicial do Trello", loginPage.checkInitialPage());
    }

    @E("^acesse o board$")
    public void acesseOBoard() {
        // Abre o board do curso
        BoardPage boardPage = new BoardPage();
        boardPage.accessBoard();
        // Verifica se o board foi acessado
        Assert.assertEquals("Automation_prime",boardPage.checkBoardPage() );
    }

    @Quando("^crio um card com o nome \"([^\"]*)\"$")
    public void crioUmCardComONome(String arg0){
        cardName = arg0;

        // Cria um card na lista "To Do"
        CardList cardList = new CardList();
        cardList.createCard(arg0);
        // Verifica se o card foi criado (se aparece na lista de cards)
        Assert.assertEquals(true, cardList.checkCreatedCard());
    }

    @E("^comento \"([^\"]*)\"$")
    public void comento(String arg0){
        // Abre o card
        SelectedCard selectedCard = new SelectedCard();
        selectedCard.clickOn(cardName);
        // Comenta no card selecionado
        selectedCard.writeComment(arg0);
    }

    @Entao("^o card deve estar na lista$")
    public void oCardDeveEstarNaLista() {
        // Abre o card
        CardList cardList = new CardList();
        // Verifica se o comentário foi feito
        Assert.assertEquals(true, cardList.checkFor(cardName));
    }

    @Quando("^excluo o card$")
    public void excluoOCard() {
        // Abre o card
        SelectedCard selectedCard = new SelectedCard();
        selectedCard.clickOn(cardName);
        // Exclui o card
        selectedCard.deleteCard();
    }

    @Entao("^o card nao existe mais$")
    public void oCardNaoExisteMais() {
        CardList cardList = new CardList();
        // Verifica se o card foi criado (se aparece na lista de cards)
        Assert.assertEquals(false, cardList.checkFor(cardName));
    }
}
