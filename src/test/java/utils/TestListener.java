package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        try {
            Field field = testInstance.getClass().getSuperclass().getDeclaredField("driver");
            field.setAccessible(true);
            WebDriver driver = (WebDriver) field.get(testInstance);
            ScreenshotUtil.takeScreenshot(driver, result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
