import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cenarios.feature",
//        glue = "steps",
        tags = {"~@ignore"},
        plugin = {"pretty", "html:target/report-html","json:target/report.json"}, //Deixa bonitinho, coloca a documentação na pasta report, documentação em estado bruto (.json)
        monochrome = true, //Tira as cores
        snippets = SnippetType.CAMELCASE, //Coloca os STEPS em Camel Case
        dryRun = false, //Mostra os steps faltantes
        strict = false // Aumenta o rigor da plotagem
)
public class RunnerTest {
    @BeforeClass
    public static void reset(){
    WebDriver driver = new ChromeDriver();
    driver.get("https://seubarriga.wcaquino.me/");
    driver.findElement(By.id("email")).sendKeys("mateus@teste123.com");
    driver.findElement(By.name("senha")).sendKeys("teste123");
    driver.findElement(By.tagName("button")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("reset")).click();
    driver.quit();

    }

}
