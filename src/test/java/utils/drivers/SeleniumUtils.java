package utils.drivers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hook;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils extends DriverManager {

    public static WebElement enviaDados(WebDriver driver, By by, String valor, int delay) {
        WebElement element = null;
        try {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(delay));
            Espera.until(ExpectedConditions.presenceOfElementLocated(by));
            Espera.until(ExpectedConditions.elementToBeClickable(by));
            element = driver.findElement(by);
            element = driver.findElement(by);
            element.click();
            element.clear();
            element.sendKeys(valor.trim());
        } catch (Exception e) {
            System.err
                    .println("Ação input, elemento - " + by + " não encontrado, " + "tempo de espera = " + delay + "s: " + e.toString());

            Assert.fail("Ação input, elemento - " + by + " não encontrado, " + "tempo de espera = " + delay + "s: " + e.toString());
        }
        return element;
    }

    public static void clickjs(WebDriver driver, By locator, int time) {
        WebDriverWait EsperaJS = new WebDriverWait(driver, Duration.ofSeconds(time));
        EsperaJS.until(ExpectedConditions.presenceOfElementLocated(locator));
        EsperaJS.until(ExpectedConditions.elementToBeClickable(locator));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public static void click(WebDriver driver, By by, int delay) {
        try {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(delay));
            Espera.until(ExpectedConditions.presenceOfElementLocated(by));
            Espera.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            System.err
                    .println("Ação click, elemento - " + by + " não encontrado, " + "tempo de espera = " + delay + "s" + " Erro: " + e.toString());
            Assert.fail("Ação click, elemento - " + by + " não encontrado, " + "tempo de espera = " + delay + "s" + " Erro: " + e.toString());

        }
        try {
            WebElement element = driver.findElement(by);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        } catch (Exception e) {
            System.err.println("Ação click, elemento - " + by + " interceptado, " + e);
            Assert.fail("Ação click, elemento - " + by + " interceptado, " + e);
        }
    }

    public static boolean elementoEstaPresente(WebDriver driver, By by, int tempoEspera) {
        boolean isPresente;
        try {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            Espera.until(ExpectedConditions.presenceOfElementLocated(by));
            WebElement element = driver.findElement(by);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            isPresente = true;
        } catch (Exception e) {
            isPresente = false;
        }
        return isPresente;
    }

    public static boolean elementoEstaPresente(WebDriver driver, By by, int tempoEspera, boolean MoverElemento) {
        boolean isPresente;
        try {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            Espera.until(ExpectedConditions.presenceOfElementLocated(by));
            WebElement element = driver.findElement(by);
            if (MoverElemento) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            }
            isPresente = true;
        } catch (Exception e) {
            isPresente = false;
        }
        return isPresente;
    }

    public static boolean elementoPresente(WebDriver driver, By by, int timeout) {
        try {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            Espera.until(ExpectedConditions.presenceOfElementLocated(by));
            Espera.until(ExpectedConditions.elementToBeClickable(by));
            WebElement element = driver.findElement(by);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void enviarDadosJS(WebDriver driver, By locator, String text, int time) {

        WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(time));
        Espera.until(ExpectedConditions.presenceOfElementLocated(locator));

        WebElement element = driver.findElement(locator);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value='" + text + "'", element);
    }

    public static String obterAtributo(WebDriver driver, String atributo, By by) {
        WebElement element = null;
        String elementText = "";
        try {
            element = driver.findElement(by);
            elementText = element.getAttribute(atributo);
        } catch (Exception e) {
            System.err.println("Elemento não encontrado");
            System.out.println(e);
        }

        return elementText;
    }

    public static void abrirURL(WebDriver driver, String url) {
        Hook.driver.get(url);
    }

    public static void rolagem(WebDriver driver, int ammount) {
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("window.scrollBy(0," + ammount + ")", "");
    }

    public static void selecionarPorTexto(WebDriver driver, By by, String texto, int tempoEspera) {
        try {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            Espera.until(ExpectedConditions.presenceOfElementLocated(by));
            Espera.until(ExpectedConditions.elementToBeClickable(by));

            WebElement elemento = driver.findElement(by);
            Select dropdown = new Select(elemento);
            try {
                dropdown.selectByVisibleText(texto);
            } catch (Exception e) {
                dropdown.selectByVisibleText(texto);
            }
        } catch (Exception e) {
            System.out.println(e);
            Assert.fail("Erro ao selecionar por texto visivel no locator: " + e.getMessage());
        }

    }

    public static void selecionarPorValor(WebDriver driver, By by, String value, int tempoEspera) {
        try {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            Espera.until(ExpectedConditions.presenceOfElementLocated(by));
            Espera.until(ExpectedConditions.elementToBeClickable(by));
            WebElement elemento = driver.findElement(by);
            Select dropdown = new Select(elemento);
            dropdown.selectByValue(value);
        } catch (Exception e) {
            System.out.println(e);
            Assert.fail("Erro ao selecionar por valor visivel no locator: " + e.getMessage());
        }
    }

    public static void click(WebDriver driver, By by, int tempoEspera, int quantidadeTentativas) throws InterruptedException {
        boolean isRealizado = false;
        String mensagemErro = "Nenhum";
        try {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            Espera.until(ExpectedConditions.presenceOfElementLocated(by));
            Espera.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            System.err.print("Erro ao aguardar elemento se tornar visível/clicavel: " + by.toString() + " Mensagem erro: " + e.toString());
            Assert.fail("Erro ao aguardar elemento se tornar visível/clicavel: " + by.toString() + " Mensagem erro: " + e.toString());
        }
        for (int i = 0; i < quantidadeTentativas; i++) {
            try {
                WebElement elemento = driver.findElement(by);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
                elemento.click();
                isRealizado = true;
                break;
            } catch (Exception e) {
                mensagemErro = e.toString();
                TimeUnit.SECONDS.sleep(2);
            }
        }

        if (isRealizado == false) {
            System.err.print("Erro ao clicar no elemento: " + by.toString() + " Mensagem erro: " + mensagemErro);
            Assert.fail("Erro ao clicar no elemento: " + by.toString() + " Mensagem erro: " + mensagemErro);
        }
    }

    public static WebElement EnviaDados(WebDriver driver, By by, String texto, int tempoEspera, int quantidadeTentativas) throws InterruptedException {
        boolean isRealizado = false;
        String mensagemErro = "Nenhum";
        WebElement elemento = null;
        try {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            Espera.until(ExpectedConditions.presenceOfElementLocated(by));
            Espera.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            System.err.print("Erro ao aguardar elemento se tornar visível/clicavel: " + by.toString() + " Mensagem erro: " + e.toString());
            Assert.fail("Erro ao aguardar elemento se tornar visível/clicavel: " + by.toString() + " Mensagem erro: " + e.toString());
        }

        for (int i = 0; i < quantidadeTentativas; i++) {
            try {
                elemento = driver.findElement(by);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
                elemento.click();
                elemento.clear();
                elemento.sendKeys(texto);
                isRealizado = true;
                break;
            } catch (Exception e) {
                mensagemErro = e.toString();
                TimeUnit.SECONDS.sleep(2);
            }
        }

        if (isRealizado == false) {
            System.err.print("Erro ao preencher elemento: " + by.toString() + " Mensagem erro: " + mensagemErro);
            Assert.fail("Erro ao preencher elemento: " + by.toString() + " Mensagem erro: " + mensagemErro);
        }

        return elemento;
    }

    public  static boolean elementoClicavel(WebDriver driver, By by, int tempoEspera){
        try
        {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            Espera.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public String obterAtributo(WebDriver driver, By by, String atributo,int tempoEspera) {
        boolean isPresente = elementoEstaPresente(driver, by, tempoEspera);
        String valorObtido = "";

        if (isPresente) {
            WebElement element = driver.findElement(by);
            valorObtido = element.getAttribute(atributo);
            return valorObtido;
        } else {
            Assert.fail("Erro ao procurar elemento");
            return valorObtido;
        }
    }

    public String obterTexto(WebDriver driver, By by, int tempoEspera) {
        boolean isPresente = elementoEstaPresente(driver, by, tempoEspera);
        String valorObtido = "";

        if (isPresente) {
            WebElement element = driver.findElement(by);
            valorObtido = element.getText();
            return valorObtido;
        } else {
            Assert.fail("Erro ao procurar elemento");
            return valorObtido;
        }
    }
    public static void clickComum(WebDriver driver, By by, int tempoEspera, int quantidadeTentativas) throws InterruptedException {
        boolean isRealizado = false;
        String mensagemErro = "Nenhum";
        try {
            WebDriverWait Espera = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
            Espera.until(ExpectedConditions.presenceOfElementLocated(by));
            Espera.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            System.err.print("Erro ao aguardar elemento se tornar visível/clicavel: " + by.toString() + " Mensagem erro: " + e.toString());
            Assert.fail("Erro ao aguardar elemento se tornar visível/clicavel: " + by.toString() + " Mensagem erro: " + e.toString());
        }
        for (int i = 0; i < quantidadeTentativas; i++) {
            try {
                WebElement elemento = driver.findElement(by);
                elemento.click();
                isRealizado = true;
                break;
            } catch (Exception e) {
                mensagemErro = e.toString();
                TimeUnit.SECONDS.sleep(2);
                System.out.println(mensagemErro + isRealizado);
            }
        }
    }
}
