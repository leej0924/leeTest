package AutoTest001;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class otherOperate {
    static org.apache.log4j.Logger logger = Logger.getLogger(Log.class);

    // 关闭浏览器，kill掉当前所有谷歌浏览器进程
    public static void closeBrowser() throws Exception {
        String cmds[] = {"killall", "Google Chrome"};
        Runtime.getRuntime().exec(cmds);
        logger.info("========关闭chrome浏览器========");
    }

    // 判断界面元素是否存在，超时判断
    public static boolean isElementExist(WebDriver driver, By locator, int timeoutSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 判断界面元素是否存在
    public boolean isExistElement(WebDriver driver, String by) {
        List<WebElement> list = driver.findElements(By.xpath(by));
        if (!list.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }


}
