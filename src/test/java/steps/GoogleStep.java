package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import page.HomePage;

public class GoogleStep {

    HomePage homePage = new HomePage();


    @Dado("o usuario acessa {string}")
    public void o_usuario_acessa(String url) throws Exception {
        homePage.iniciar(url);
    }

    @Dado("faz uma pesquisa pelo produto {string}")
    public void faz_uma_pesquisa_pelo_produto(String produto) {
        homePage.pesquisar(produto);
    }

    @Entao("verifica se o produto retornado")
    public void verifica_se_o_produto_retornado() {
        homePage.validaCampo();


    }

}
