package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Evidencias;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class seleniumAula {

    WebDriver driver;
    Evidencias evidencias;
    String dataHora = new SimpleDateFormat("yy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

    @Test
    public void consultarCurso() throws IOException {
    String casoDeTeste = "consultarCurso";

        System.setProperty("webdriver.chrome.driver", "drivers/chrome/99/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        evidencias = new Evidencias();

        driver.get("https://www.iterasys.eadplataforma.com/");
        evidencias.prints(driver,dataHora,"casoDeTeste", "Passo1 - Abriu o site");
        driver.manage().window().maximize();
        //driver.findElement(By.cssSelector("i[class='far fa-university']")).click();

        driver.findElement(By.id("searchtext")).click();
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys("teste");
        evidencias.prints(driver,dataHora,"casoDeTeste","Passo2 - digitou teste");
        driver.findElement(By.id("btn_form_search")).click();
        //assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos › \"teste\"");
        assertTrue(driver.findElement(By.cssSelector(("h3"))).getText().contains("teste"));
        evidencias.prints(driver,dataHora,"casoDeTeste","Passo3 - Abriu a tela");

        driver.quit();
    }
}