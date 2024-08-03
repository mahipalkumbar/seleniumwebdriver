package pitfeo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Fitpeo{

	public static void main(String[] args) throws InterruptedException  {
		// 1.Navigate to the FitPeo Homepage:

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//2.Navigate to the Revenue Calculator Page:

		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		Thread.sleep(3000);
		
		//3.Scroll Down to the Slider section:
		WebElement der=driver.findElement(By.xpath("//h5[text()='Total Gross Revenue Per Year']"));
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", der);
		
		//4.Adjust the Slider:
		WebElement slider=driver.findElement(By.xpath("//input[@aria-orientation='horizontal']"));
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.clickAndHold(slider);
		act.moveByOffset(94, 0).perform();
		Thread.sleep(3000);
		WebElement input=driver.findElement(By.xpath("//input[@aria-invalid='false']"));
		if(input.getAttribute("Value").equals("823")) {
			System.out.println("TC4:-Ajust the slider TC passed");
		}else {
			System.out.println("C4:-Ajust the slider TC Failed");
		}
		
		//5.Update the Text Field:
		Thread.sleep(3000);
		driver.navigate().refresh();
		WebElement ele=driver.findElement(By.id(":R57alklff9da:"));
		ele.sendKeys(Keys.ALT.DELETE);
		ele.sendKeys(Keys.ALT.DELETE);
		ele.sendKeys("560");
		
		
		//6.Validate Slider Value:
		WebElement slider1=driver.findElement(By.xpath("//input[@aria-orientation='horizontal']"));
		if(slider1.getAttribute("Value").equals("560")) {
			System.out.println("TC6:-Validate slider value TC passed");
		}else {
			System.out.println("TC6:-Validate slider value TC failed");
		}
		
		//7.Select CPT Codes:
		Thread.sleep(3000);
		WebElement cpt1=driver.findElement(By.xpath("//p[text()='CPT-99091']"));
		JavascriptExecutor jse1=(JavascriptExecutor) driver;
		jse1.executeScript("arguments[0].scrollIntoView(true)", cpt1);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/label/span[1]/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/label/span[1]/input")).click();
		
		//8. Validate Total Recurring Reimbursement:
		Actions act1=new Actions(driver);
		WebElement tab=driver.findElement(By.xpath("//header[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation4 MuiAppBar-root MuiAppBar-colorDefault MuiAppBar-positionFixed mui-fixed css-nq2yav']"));
		act1.moveToElement(tab).perform();
		String TotalRevenue=driver.findElement(By.xpath("//p[text()='817146.40']")).getText().substring(1);
		String otroap=driver.findElement(By.xpath("//p[text()='10746.40']")).getText().substring(1);
		String tippm=driver.findElement(By.xpath("//p[text()='560']")).getText();
		String trrfappm=driver.findElement(By.xpath("//p[text()='67200']")).getText().substring(1);
		
		
		//9. Verify that the header displaying Total Recurring 
		int su=Integer.parseInt(trrfappm);
		System.out.println("TC9:-Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110700.	\r\n"
					+ su);
		
		
		
	}

}
