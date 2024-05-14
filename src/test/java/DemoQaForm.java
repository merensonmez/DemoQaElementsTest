import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DemoQaForm {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions actions =new Actions(driver);


        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

        driver.findElement(By.id("firstName")).sendKeys("Eren");
        Thread.sleep(1000);
        driver.findElement(By.id("lastName")).sendKeys("Sonmez");
        Thread.sleep(1000);
        driver.findElement(By.id("userEmail")).sendKeys("erensonmezselenium@gmail.com");
        Thread.sleep(1000);
        actions.scrollByAmount(0,1000).perform();
        WebElement gender = driver.findElement(By.xpath("(//label[normalize-space()='Male'])[1]"));
        gender.click();
        Thread.sleep(1000);

        driver.findElement(By.id("userNumber")).sendKeys("05456651111");
        Thread.sleep(1000);

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@aria-label='Choose Friday, May 24th, 2024'])[1]")).click();
        Thread.sleep(1000);


//       WebElement subjects = driver.findElement(By.xpath("(//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3'])[1]"));
//
//        subjects.sendKeys("English");
//        subjects.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("(//label[normalize-space()='Sports'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//label[normalize-space()='Reading'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//label[normalize-space()='Music'])[1]")).click();
        Thread.sleep(1000);

        WebElement uploadFile = driver.findElement(By.id("uploadPicture"));
        uploadFile.sendKeys("C:\\Users\\LENOVO\\Desktop\\yazılım\\logo.png");
        Thread.sleep(1500);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Zonguldak Kozlu");
        actions.scrollByAmount(0,200).perform();
        Thread.sleep(1000);

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        WebElement submittedMessage = driver.findElement(By.xpath("//div[@id=\"example-modal-sizes-title-lg\"]"));
        if (submittedMessage.isDisplayed()){
            System.out.println("Thanks for submitting the form");
        }else {
            System.out.println("Thanks for submitting the form is NOT verified");
        }


    }
}
