package co.selenium.automation.webdriver;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassTest {
	
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\Chrome Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get("http://sarathi.parivahan.gov.in/sarathiservice/stateSelection.do");
			
			System.out.println("hello my name is");
			System.out.println("ritu");
			
			
			searchCource();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void searchCource() throws InterruptedException {

		driver.findElement(By.xpath("//span[@id='select2-stfNameId-container']")).click();
		Thread.sleep(1000);
        driver.findElement(By.name("stName"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//option[@value='MH']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@src='images/shaps/status-icon3.png']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("applNum")).sendKeys("457531221");
        driver.findElement(By.id("dateOfBirth")).sendKeys("12-04-1996");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active ui-state-hover']")).click();
        Thread.sleep(1000);
        String capthaVal = JOptionPane.showInputDialog("Please enter the Captha Value:");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='entcaptxt']")).sendKeys(capthaVal);
        Thread.sleep(3000);driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("submit")).click();
        
		jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 1600)");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("1089979921")).click();

	}
	
	public static void main(String[] args) {
		
		ClassTest myObj = new ClassTest();
		myObj.invokeBrowser();

	}

}

