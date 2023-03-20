package StepsDefinition;

import Page.CerrarSesionPage;
import Page.LoginPage;
import datos.ExcelClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class inicioSesion {

    public static WebDriver driver;
    private WebDriver driver1;
    ExcelClass excelClass;
    LoginPage loginPage;
    CerrarSesionPage cerrarSesionPage;
    @Given("^me encuentro en el sitio$")
    public void me_encuentro_en_el_sitio() {

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://bancaporinternetuat.interbank.pe/login");

        loginPage = new LoginPage(driver);
    }

    @When("^ingreso las credenciales$")
    public void ingreso_las_credenciales() {
        loginPage.ingresaData();
        loginPage.Ingresar();
    }

    @When("^cierro sesion$")
    public void cierro_sesion() {

       // WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/header/div/div/div[2]/aside/nav/div[2]/ul/div[1]/li/a/span")));

        //capturar objeto

        WebElement menu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/header/div/div/div[4]/div/a"));

        //Creando objeto de una clase de Acciones
        Actions action = new Actions(driver);

        //Realización de la acción de desplazamiento del mouse sobre el elemento de destino.
        action.moveToElement(menu).perform();

        //cerrarSesionPage.cerrarSesion();

        WebElement submenu = driver.findElement(By.xpath("//*[@class=\"header__profile-submenu header__profile-submenu--active\"]"));

        action.moveToElement(submenu).perform();

        WebElement opcion = driver.findElement(By.xpath("//*[@class=\"header__profile-submenu header__profile-submenu--active\"]/*[4]"));

        action.moveToElement(opcion).click().perform();
    }
    @Then("^me muestra los datos guardados$")
    public void me_muestra_los_datos_guardados() throws IOException {


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File screnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screnshot, new File("C:\\Users\\andy.alayo\\Desktop\\Automatizacion\\RetoAutomatizacionBPI\\Imagenes\\TarjetaGuardada.png"));
        driver.close();
    }


}
