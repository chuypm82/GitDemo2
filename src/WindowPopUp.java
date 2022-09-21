import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\625337\\Documents\\Personal\\Trainings\\Selenium\\Downloads\\chromedriver_win32\\chromedriver.exe");//webdriver.chrome.driver->value of path
		WebDriver driver= new ChromeDriver();// to invoke chrome browser (launch)
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		//
		//
		// now more steps
		System.out.println("Test 1st line added to update 1.1 GitHub");
		System.out.println("Test 2nd line added to update 1.1 GitHub");
		//
		//
		// now more steps
		System.out.println("Test 1st line added to update 1.2 GitHub");


	}
}
