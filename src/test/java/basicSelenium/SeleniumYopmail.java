package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class SeleniumYopmail {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        // implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // page load wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://yopmail.com/es/");
    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void verifyCRUDProject() throws InterruptedException {
        // login
        driver.findElement(By.xpath("//input[@title='Login']")).click();
        driver.findElement(By.xpath("//input[@title='Login']")).sendKeys("prueba1");
        driver.findElement(By.xpath("//button[@title='Revisa el correo @yopmail.com']")).click();
        driver.findElement(By.id("newmail")).click();
       /* int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        for(int i=0; i<=size; i++){
            driver.switchTo().frame(i);
            int total=driver.findElements(By.xpath("//div[@class='hc']")).size();
            System.out.println(total);
            driver.switchTo().defaultContent();}*/
        driver.switchTo().frame(2);
        driver.findElement(By.cssSelector("[aria-label=Recipient]")).click();
        driver.findElement(By.cssSelector("[aria-label=Recipient]")).sendKeys("prueba2");
        driver.findElement(By.cssSelector("[aria-label=Asunto]")).click();
        driver.findElement(By.cssSelector("[aria-label=Asunto]")).sendKeys("prueba2");
        driver.findElement(By.xpath("//div[@class='hc']")).click();
        driver.findElement(By.xpath("//div[@class='hc']")).sendKeys("message");
        driver.findElement(By.xpath("//span[text()='Enviar el mensaje']")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[@class='hlink bl']")).click();
        driver.findElement(By.xpath("//input[@title='Login']")).click();
        driver.findElement(By.xpath("//input[@title='Login']")).clear();
        driver.findElement(By.xpath("//input[@title='Login']")).sendKeys("prueba2");
        driver.findElement(By.xpath("//button[@title='Revisa el correo @yopmail.com']")).click();
        Thread.sleep(5000);
        //span[text()='Enviar el mensaje']
        Thread.sleep(2000);


        /*
        // login
        driver.findElement(By.xpath("//img[contains(@src,'pagelogin')]")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("bootcamp@mojix44.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        // Explicit Wait
        //Thread.sleep(5000);
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")));

        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed()
                ,"ERROR login was incorrect");

        // create
        String nameProject="Mojix"+new Date().getTime();
        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        driver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(1000);
        int actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not created");
        // create task
        driver.findElement(By.id("NewItemContentInput")).sendKeys("Eynar");
        driver.findElement(By.id("NewItemAddButton")).click();
        // create update
        driver.findElement(By.xpath("//div[@class=\"ItemContentDiv\" and text()='Eynar']")).click();
        driver.findElement(By.id("ItemEditTextbox")).clear();
        driver.findElement(By.id("ItemEditTextbox")).sendKeys("Update\n");
        Thread.sleep(5000);

    }
    */
    }
}
