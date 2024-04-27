import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class DemoQaTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions actions =new Actions(driver);

        driver.get("https://demoqa.com/");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
        Thread.sleep(1000);
        WebElement elements = driver.findElement(By.xpath("//h5[normalize-space()='Elements']"));
        elements.click();
        Thread.sleep(2000);

        // Text Box Test
        
        WebElement textBox = driver.findElement(By.xpath("(//li[@id='item-0'])[1]"));
        textBox.click();

        driver.findElement(By.id("userName")).sendKeys("erensonmez");
        Thread.sleep(1000);
        driver.findElement(By.id("userEmail")).sendKeys("erensonmezselenium@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("currentAddress")).sendKeys("Zonguldak ");
        Thread.sleep(1000);
        driver.findElement(By.id("permanentAddress")).sendKeys("Malatya Yesilyurt");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        WebElement submitTextBox = driver.findElement(By.id("submit"));
        submitTextBox.click();
        Thread.sleep(1000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("Screenshot//informationTextBox.png"));
        Thread.sleep(1000);


        // Check Box Text
        WebElement checkBox = driver.findElement(By.xpath("(//li[@id='item-1'])[1]"));
        checkBox.click();

        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[name()='svg'][@class='rct-icon rct-icon-expand-close'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[name()='svg'][@class='rct-icon rct-icon-uncheck'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@title=\"Expand all\"]")).click();
        Thread.sleep(1000);

        //Radio Button Test

        WebElement radioButton = driver.findElement(By.xpath("(//li[@id='item-2'])[1]"));
        radioButton.click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,500)");
        WebElement impressiveRadioButton = driver.findElement(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[2]"));
        impressiveRadioButton.click();
        Thread.sleep(1000);
        WebElement yesRadioButton = driver.findElement(By.xpath("(//label[normalize-space()='Yes'])[1]"));
        yesRadioButton.click();
        Thread.sleep(1000);

        // Web Tables Test

        WebElement webTables = driver.findElement(By.xpath("(//li[@id='item-3'])[1]"));
        webTables.click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,500)");
        WebElement addNewRecord = driver.findElement(By.cssSelector("#addNewRecordButton"));
        addNewRecord.click();
        Thread.sleep(1000);

        driver.findElement(By.id("firstName")).sendKeys("Eren");
        Thread.sleep(1000);
        driver.findElement(By.id("lastName")).sendKeys("Sonmez");
        Thread.sleep(1000);
        driver.findElement(By.id("userEmail")).sendKeys("erensonmezseleniumtest@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("age")).sendKeys("20");
        Thread.sleep(1000);
        driver.findElement(By.id("salary")).sendKeys("40000");
        Thread.sleep(1000);
        driver.findElement(By.id("department")).sendKeys("Test Automation Engineer");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);

        //Buttons Test

        WebElement  buttons = driver.findElement(By.xpath("(//li[@id='item-4'])[1]"));
        buttons.click();
        Thread.sleep(1000);

        actions.scrollByAmount(0,421);
        Thread.sleep(1000);
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClick).perform();
        Thread.sleep(1000);

        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClick).perform();
        Thread.sleep(1000);

        WebElement click = driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[1]"));
        actions.click(click).perform();
        Thread.sleep(1000);

        // Links Test

        WebElement links = driver.findElement(By.xpath("(//li[@id='item-5'])[1]"));
        links.click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        

    }
}
