package co.selenium.automation.webdriver;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeCrm {

	WebDriver driver;
	JavascriptExecutor jse;

	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\Chrome Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://ui.cogmento.com/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("testemail3154@gmail.com");
		Thread.sleep(1000);
		
		driver.findElement(By.name("password")).sendKeys("Mike@07june");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[contains(text(), 'Login')]")).click();
	}

	public static void main(String[] args) {

		FreeCrm myObj = new FreeCrm();
		myObj.invokeBrowser();

	}

}
