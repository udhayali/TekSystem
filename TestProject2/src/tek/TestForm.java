package tek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestForm {

	WebDriver driver;

	// (Valid input data)

	@Test(priority = 1, enabled = true)

	public void TC001() throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.16.1-win32/geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
		driver.get("file:///C:/Users/rayya/Desktop/test.html");

		driver.findElement(By.xpath(".//*[@id='fname']")).sendKeys("James");
		driver.findElement(By.xpath(".//*[@id='lname']")).sendKeys("Alberto");
		driver.findElement(By.xpath(".//*[@id='phone']")).sendKeys("1234567890");
		driver.findElement(By.xpath(".//*[@id='submit']")).click();

		Thread.sleep(5000);

		String expected = driver.findElement(By.xpath("html/body/p")).getText();
		String actual = "Form submitted!";
		Assert.assertEquals(actual, expected);

		System.out.println(expected);

		driver.close();
	}

	@Test(priority = 2, enabled = true)
	
	//Negative Test (First Name = 26 charactors ,Last Name = 26 charactors,Phone = 12345 digits)

	public void TC002(){
		
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.16.1-win32/geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
		driver.get("file:///C:/Users/rayya/Desktop/test.html");

		driver.findElement(By.xpath(".//*[@id='fname']")).sendKeys("abcdefghijklmnopqrstuvxyz");
		driver.findElement(By.xpath(".//*[@id='lname']")).sendKeys("abcdefghijklmnopqrstuvxyz");
		driver.findElement(By.xpath(".//*[@id='phone']")).sendKeys("12345678901");

		driver.findElement(By.xpath(".//*[@id='submit']")).click();


		// verification for First Name  

		String expectedFN = driver.findElement(By.xpath(".//*[@id='fname-error']")).getText();
		String actualFN = "The max length of first name is 20";
		Assert.assertEquals(actualFN, expectedFN);

		System.out.println(expectedFN);

		// verification for  Last Name 

		String expectedLN = driver.findElement(By.xpath(".//*[@id='lname-error']")).getText();
		String actualLN = "The max length of first name is 20";
		Assert.assertEquals(actualLN, expectedLN);

		System.out.println(expectedLN);

		// verification for  Phone

		String expectedPH = driver.findElement(By.xpath(".//*[@id='phone-error']")).getText();
		String actualPH = "Phone is incorrect";
		Assert.assertEquals(actualPH, expectedPH);

		System.out.println(expectedPH);

		driver.close();
	}

	@Test(priority = 3, enabled = true)

	//Blanks Fields ( Validated with No data input )

	public void TC003(){

		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.16.1-win32/geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
		driver.get("file:///C:/Users/rayya/Desktop/test.html");

		driver.findElement(By.xpath(".//*[@id='fname']")).sendKeys("");
		driver.findElement(By.xpath(".//*[@id='lname']")).sendKeys("");
		driver.findElement(By.xpath(".//*[@id='phone']")).sendKeys("");

		driver.findElement(By.xpath(".//*[@id='submit']")).click();


		// verification for FirstName, LastName, PhoneNember

		String expectedFN = driver.findElement(By.xpath(".//*[@id='fname-error']")).getText();
		String actualFN = "First name is a required field";
		Assert.assertEquals(actualFN, expectedFN);

		System.out.println(expectedFN);

		String expectedLN = driver.findElement(By.xpath(".//*[@id='lname-error']")).getText();
		String actualLN = "Last name is a required field";
		Assert.assertEquals(actualLN, expectedLN);

		System.out.println(expectedLN);

		String expectedPH = driver.findElement(By.xpath(".//*[@id='phone-error']")).getText();
		String actualPH = "Phone number is a required input";
		Assert.assertEquals(actualPH, expectedPH);

		System.out.println(expectedPH);

		driver.close();
	}


	@Test(priority = 4, enabled = true)

	// Validated with Special charactors

	public void TC004(){

		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.16.1-win32/geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
		driver.get("file:///C:/Users/rayya/Desktop/test.html");

		driver.findElement(By.xpath(".//*[@id='fname']")).sendKeys("askdj674][");
		driver.findElement(By.xpath(".//*[@id='lname']")).sendKeys("askdj674%$32");
		driver.findElement(By.xpath(".//*[@id='phone']")).sendKeys("kjhfhf67");

		driver.findElement(By.xpath(".//*[@id='submit']")).click();

		// verification for FirstName, LastName, Phone 

		String expectedFN = driver.findElement(By.xpath(".//*[@id='fname-error']")).getText();
		String actualFN = "First name can only be characters";
		Assert.assertEquals(actualFN, expectedFN);

		System.out.println(expectedFN);

		String expectedLN = driver.findElement(By.xpath(".//*[@id='lname-error']")).getText();
		String actualLN = "Last name can only be characters";
		Assert.assertEquals(actualLN, expectedLN);


		String expectedPH = driver.findElement(By.xpath(".//*[@id='phone-error']")).getText();
		String actualPH = "Phone is incorrect";
		Assert.assertEquals(actualPH, expectedPH);

		driver.close();
	}

	// Invalid data space as a charactors

	@Test(priority = 5, enabled = true)

	public void TC005(){

		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.16.1-win32/geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
		driver.get("file:///C:/Users/rayya/Desktop/test.html");

		driver.findElement(By.xpath(".//*[@id='fname']")).sendKeys("a  dj  t");
		driver.findElement(By.xpath(".//*[@id='lname']")).sendKeys("a kdj nm");
		driver.findElement(By.xpath(".//*[@id='phone']")).sendKeys("kjhfhf");

		driver.findElement(By.xpath(".//*[@id='submit']")).click();

		// verification for FirstName, LastName, Phone 

		String expectedFN = driver.findElement(By.xpath(".//*[@id='fname-error']")).getText();
		String actualFN = "First name can only be characters";
		Assert.assertEquals(actualFN, expectedFN);

		System.out.println(expectedFN);

		String expectedLN = driver.findElement(By.xpath(".//*[@id='lname-error']")).getText();
		String actualLN = "Last name can only be characters";
		Assert.assertEquals(actualLN, expectedLN);


		String expectedPH = driver.findElement(By.xpath(".//*[@id='phone-error']")).getText();
		String actualPH = "Phone is incorrect";
		Assert.assertEquals(actualPH, expectedPH);

		driver.close();
	}

	}	

