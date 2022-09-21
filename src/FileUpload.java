import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String downloadPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\625337\\Documents\\Personal\\Trainings\\Selenium\\Downloads\\chromedriver_win32\\chromedriver.exe");//webdriver.chrome.driver->value of path
		ChromeOptions options= new ChromeOptions();
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver= new ChromeDriver(options);// to invoke chrome browser (launch)
		driver.get("https://www.adobe.com/acrobat/online/pdf-to-jpg.html");	
		driver.findElement(By.id("lifecycle-nativebutton")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\625337\\Documents\\Personal\\Trainings\\Selenium\\Documents\\FileUpload\\fileUpload.exe");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='spectrum-Button spectrum-Button--cta LifecycleExportSettings__buttonStyle___1M6En']")));
		
		driver.findElement(By.cssSelector("button[class='spectrum-Button spectrum-Button--cta LifecycleExportSettings__buttonStyle___1M6En']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test-id='download']")));
		driver.findElement(By.cssSelector("button[data-test-id='download']")).click();
		
		File f= new File(downloadPath + "\\PDF-Example.zip");
		Thread.sleep(3000);
		if(f.exists())
		{
			System.out.println("File is found");
			Assert.assertTrue(f.exists());
			if(f.delete())
				System.out.println("File is deleted");				
		}
		else
		{
			System.out.println("File is NOT found");
		}
	}
}
