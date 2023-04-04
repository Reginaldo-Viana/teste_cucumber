package page;



import org.junit.Assert;
import org.openqa.selenium.By;
import steps.Hook;
import utils.drivers.SeleniumUtils;

public class HomePage extends SeleniumUtils {


	public static final By campoPesquisar = By.name("q");

	public static final By campoAproximadamente = By.id("result-stats");


	public void iniciar(String url) throws Exception {
		try {
			abrirURL(Hook.driver, url);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public void pesquisar(String Produto){
		enviaDados(Hook.driver, campoPesquisar, Produto, 60 ).submit();

	}

	public void validaCampo(){
		String valor = obterTexto(Hook.driver, campoAproximadamente, 60);
		System.out.println("Valor obtido: " + valor);
		if(valor.contains("Aproximadamente")){
			System.out.println("Teste finalizado com sucesso!");
		}else {
			System.out.println("Não foi possível validar a página de teste!");
			Assert.fail();
		}
	}
}
