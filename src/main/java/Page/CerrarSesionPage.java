package Page;

import Keywords.KeyTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CerrarSesionPage extends KeyTest {

    String menu="xpath://*[@id=\"app\"]/div[2]/div/header/div/div/div[4]/div/a";
    WebDriver driver;
    public CerrarSesionPage(WebDriver driver) {
        super(driver);
    }




}
