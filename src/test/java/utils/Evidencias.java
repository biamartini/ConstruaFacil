package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Evidencias {

    public void prints(WebDriver driver,String dataHora,String casoDeTeste ,String nomePrint) throws IOException {
     File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println("dataHora:" + dataHora);
        FileUtils.copyFile(foto, new File("target/prints/"+ dataHora +"/" + casoDeTeste +"/"+ nomePrint +".png"));
    }
}
