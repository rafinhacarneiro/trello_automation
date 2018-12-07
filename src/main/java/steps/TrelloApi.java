package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class TrelloApi {
    final String BASE_URL = "http://api.trello.com/1/";
    final String AUTH = "key=cb05262f1cc2a9b9caae0d77fbf9e9fe&token=2016b9f7190d236364f929567c1a8520050dc796321dec229581273bfd9b7a7a";
    final String BOARD_ID = "ICLxsmNI";
    final String TODO_ID = "5c0afd8c98b7b41d1dcf54d9";
    private Response response;
    private String cardID;

    @Dado("^que acesse aAPI com sucesso$")
    public void queAcesseAAPIComSucesso() {
        response = given().get(BASE_URL+"boards/"+BOARD_ID+"?"+AUTH);
        Assert.assertEquals(200, response.statusCode());
    }

    @Quando("^crio um card com o nome \"([^\"]*)\" usando a API$")
    public void crioUmCardComONomeUsandoAAPI(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        response = given().contentType("application/json").post(BASE_URL+"cards?name="+arg0+"&idList="+TODO_ID+"&keepFromSource=all&key="+AUTH);
        Map<String, String> card = response.jsonPath().getMap("$");
        cardID = card.get("id");
        Assert.assertEquals(200, response.statusCode());
    }

    @E("^comento \"([^\"]*)\" no card gerado$")
    public void comentoNoCardGerado(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("comentoNoCardGerado");
    }

    @Entao("^o card deve ser criado com sucesso$")
    public void oCardDeveSerCriadoComSucesso() {
        System.out.println("oCardDeveSerCriadoComSucesso");
    }

    @Quando("^excluo usando a API$")
    public void excluoUsandoAAPI() {
        System.out.println("excluoUsandoAAPI");
    }

    @Entao("^eu tenho o resultado com status \"([^\"]*)\"$")
    public void euTenhoOResultadoComStatus(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("euTenhoOResultadoComStatus");
    }
}
