package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void switchWindowToChild()
	{
		Set<String> i1 = driver.getWindowHandles();
		Iterator<String> s1 = i1.iterator();
		String parentWindow = s1.next();
		String childWindow = s1.next();
		driver.switchTo().window(childWindow);
	}

}
