import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Steps {

    private WebDriver driver;
    @Dado("^que estou acessando a aplicação$")
    public void queEstouAcessandoAAplicação() throws Throwable {
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
    }

    @Quando("^informo o usuário \"([^\"]*)\"$")
    public void informoOUsuário(String arg1) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(arg1);
    }

    @Quando("^a senha \"([^\"]*)\"$")
    public void aSenha(String arg1) throws Throwable {
        driver.findElement(By.name("senha")).sendKeys(arg1);
    }

    @Quando("^seleciono entrar$")
    public void selecionoEntrar() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("^visualizo a página inicial$")
    public void visualizoAPáginaInicial() throws Throwable {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, Mateus!", texto);
    }

    @Quando("^seleciono Contas$")
    public void selecionoContas() throws Throwable {
        driver.findElement(By.linkText("Contas")).click();
    }

    @Quando("^seleciono Adicionar$")
    public void selecionoAdicionar() throws Throwable {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("^informo a conta \"([^\"]*)\"$")
    public void informoAConta(String arg1) throws Throwable {
        driver.findElement(By.id("nome")).sendKeys(arg1);
    }

    @Quando("^seleciono Salvar$")
    public void selecionoSalvar() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("^recebo a mensagem \"([^\"]*)\"$")
    public void receboAMensagem(String arg1) throws Throwable {
        String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
        Assert.assertEquals(arg1, texto);
    }

    @After(order = 1)
    public void screenshot(Scenario cenario) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getId() + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After(order = 0)
    public void fecharBrowser(){
        driver.quit();
    }
}
