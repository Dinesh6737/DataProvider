package org.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FaceBook extends DataExcel {
	@Test(dataProvider = "res",dataProviderClass=DataExcel.class)
	public void testcase(String s1,String s2) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\eclipse-workspace\\Dinesh\\DataproviderwithExcelsheet\\Driver up\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(s1);
		driver.findElement(By.id("pass")).sendKeys(s2);
		driver.findElement(By.id("u_0_b")).click();
	}

}
