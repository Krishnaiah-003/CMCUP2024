package CMsCupApplicationRegistration;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VCMDLogin {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);

	@BeforeTest
	public void NavigateToApplication() {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cmcup2024.telangana.gov.in/");
		driver.findElement(By.linkText("Login")).click();

	}
	@Test(priority=1)
	public void Login() throws Exception {

		driver.findElement(By.id("dyso_cont_no")).sendKeys("vcmd");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("vcmd@123");
		Thread.sleep(1000);
		System.out.print("Enter Captcha for VCMD Login : ");
		String captcha = scanner.next();
		driver.findElement(By.id("captcha")).sendKeys(captcha, Keys.ENTER);
		Thread.sleep(1000);        
	}
	@AfterTest
	public void Logout(){
		driver.close();
	}
}