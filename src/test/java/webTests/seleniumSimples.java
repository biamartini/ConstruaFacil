package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class seleniumSimples {

    WebDriver driver;  //declarar selenium webdriver

    @Test
    public void consultarCurso(){

        //parte1 - inicio (qual navegador)(prepara/executa e valida)
        System.setProperty("webdriver.chrome.driver","drivers/chrome/99/chromedriver.exe"); //aponta apra onde esta o driveer do chrome
        //instacioa(liga) o objeto chrome como um controlador do chrome

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

        //realizar o teste

        driver.get("https://www.iterasys.com.br");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a[class='button  button-default']")).click();
        driver.findElement(By.id("auto-2")).click();
        driver.findElement(By.id("auto-2")).sendKeys("ctfl");
        driver.findElement(By.cssSelector(("a[href='/pt/cursos/preparatorio-ctfl-exame-brightest']"))).click();

        assertEquals(driver.findElement(By.name("h1")).getText(),"ctfl");



    }

}
