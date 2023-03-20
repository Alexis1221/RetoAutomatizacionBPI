package Page;

import Keywords.KeyTest;
import datos.ExcelClass;
import org.openqa.selenium.WebDriver;

public class LoginPage extends KeyTest {


    String tarjeta = "xpath://input[@id=\"25\"]";
    String documento = "xpath://input[@id=\"39\"]";
    String clave = "xpath://input[@id=\"46\"]";
    String ingresar = "xpath://*[@id=\"app\"]/div[2]/div[1]/div[2]/div[2]/div/div/div/div[1]/div/button";
    String contraseña1= "xpath://*[@id=\"app\"]/div[2]/div[1]/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/a[21]/span";
    String contrasena2= "xpath://*[@class=\"character\" and @points=\"27.390625 44 24.484375 44 24.484375 24.734375 18.65625 26.875 18.65625 24.25 26.9375 21.140625 27.390625 21.140625\"]//following::a[1]//preceding::span[1]";
    String recordar="xpath://*[@id=\"app\"]/div[2]/div[1]/div[2]/div[2]/div/div/div/div[1]/div/div[4]/label/span[3]/span";
    String tipo="xpath://*[@id='documentType']/div/div";
    String DNI="xpath://*[@id=\"documentType\"]/ul/li[1]";
    String carga= "xpath://*[@id=\"app\"]/div[2]/div/header/div/div/div[2]/aside/nav/div[2]/ul/div[1]/li/a/span";
    ExcelClass excelClasss = new ExcelClass("Data/dataTest.xlsx");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public static WebDriver driver;
    public void ingresaData(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(tarjeta);
        type("Tarjeta", tarjeta, "CP1" );

        click(tipo);
        String Input = excelClasss.searchCampo("Hoja1", "TipoDocumento", "CP1");
        System.out.println(Input);
        if(Input=="DNI")
        {
            click(DNI);
        }

        type("Documento", documento, "CP1");



        click(clave);
        click(contraseña1);
        click(contrasena2);
        click(contrasena2);
        click(contrasena2);
        click(contrasena2);
        click(contrasena2);
        click(contrasena2);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        click(recordar);
        screenShot("Ingreso de credenciales");

    }

    public void Ingresar(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        click(ingresar);

        waitLoaderVisible(carga,20);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        screenShot("Ingreso a BPI");
        //System.out.println("....1"+elemento.getText());
        //System.out.println("....2"+elemento.getAttribute("value"));

    }
}
