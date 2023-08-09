package egg;

import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;


class ApplicationTest {

    private static WebDriver miDriver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup(); // Configurar el controlador de Chrome
        // miDriver = new ChromeDriver(); // Inicializar el WebDriver
    }

    @BeforeEach
    void lalala(){
        miDriver = new ChromeDriver();
    }

    @AfterEach
    void lololo(){

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        miDriver.close();
    }

    @Test
    void ejercicioCssSelector1() {
        miDriver.get("https://www.google.com");
        // TAG + ID
        WebElement buscador = miDriver.findElement(By.cssSelector("textarea#APjFqb"));

        Assertions.assertNotEquals(null, buscador);
    }

    @Test
    void ejercicioCssSelector2(){
        miDriver.get("https://github.com/");
        // TAG + CLASSNAME
        WebElement elBotonMagicoDelGit = miDriver.findElement(By.cssSelector("button.HeaderMenu-link"));
        elBotonMagicoDelGit.click();

        WebElement enlaceReLoco = miDriver.findElement(By.cssSelector("a.HeaderMenu-dropdown-link"));
        enlaceReLoco.click();

        Assertions.assertNotEquals(null, elBotonMagicoDelGit);
        Assertions.assertNotEquals(null, enlaceReLoco);
    }
    
    @Test
    void ejercicioCssSelector3(){
        miDriver.get("https://twitter.com/");
        // TAG + ATRIBUTE
        WebElement elBotonDeSinUP = miDriver.findElement(By.cssSelector("a[data-testid=signupButton]"));
        elBotonDeSinUP.click();
        Assertions.assertNotEquals(null, elBotonDeSinUP);
    }
    
    @Test
    void ejercicioCssSelector4(){
        miDriver.get("https://www.linkedin.com/");
        // TAG + CLASSNAME + ATRIBUTE
        WebElement elBotonDelAlzheimer = miDriver.findElement(By.cssSelector(
            "a.sign-in-form__forgot-password--full-width[data-id=sign-in-form__forgot-password]"
            ));
        elBotonDelAlzheimer.click();

        Assertions.assertNotEquals(null, elBotonDelAlzheimer);
    }

    @Test
    void ejercicioCssSelector5(){
        miDriver.get("https://medium.com/");

        // XPATH
        String xpathDelArticulo = "//*[@id='root']/div/div[4]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[2]/a";
        WebElement elArticuloConRutaFea = miDriver.findElement(By.xpath(xpathDelArticulo));
        elArticuloConRutaFea.click();

        Assertions.assertNotEquals(null, elArticuloConRutaFea);
    }
    
    @Test
    // 6. Etiqueta + Clase: Encuentra y haz clic en el enlace "Contact" en el pie de página del sitio Stack Overflow.
    void ejercicioCssSelector6(){
        miDriver.get("https://es.stackoverflow.com/");
        // TAG + CLASSNAME
        List<WebElement> anchorFeoDeS = miDriver.findElements(By.cssSelector("a.js-gps-track"));
        WebElement contactoDelStackOverflow = anchorFeoDeS.get(46);
        contactoDelStackOverflow.click();
        Assertions.assertNotEquals(null, contactoDelStackOverflow);
    }
    
    @Test
    // 7. Etiqueta + ID: Encuentra y muestra la descripción del primer producto en la página de inicio de Amazon.
    void ejercicioCssSelector7(){
        miDriver.get("https://www.amazon.com/");
        // TAG + ID
        // List<WebElement> carruselDeAmazon = miDriver.findElements(By.cssSelector("div#685bf823-01f6-4791-8e4f-27661a121844"));
        // WebElement contactoDelStackOverflow = miDriver.findElements(By.cssSelector("div#685bf823-01f6-4791-8e4f-27661a121844")).get(1);
        WebElement elemento = miDriver.findElement(By.cssSelector("img.product-image[alt='SAMSUNG 980 PRO SSD with Heatsink 2TB PCIe Gen 4 NVMe M.2 Internal Solid State Drive + 2mo Adobe CC Photography, Heat...']"));
        
        String descripcion = elemento.getAttribute("alt");
        Assertions.assertEquals("SAMSUNG 980 PRO SSD with Heatsink 2TB PCIe Gen 4 NVMe M.2 Internal Solid State Drive + 2mo Adobe CC Photography, Heat...", descripcion);
    }
}
