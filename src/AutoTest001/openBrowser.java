package AutoTest001;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class openBrowser {
    static Logger logger = Logger.getLogger(Log.class);
    /**
     * @param browserType 指定打开浏览器类型，暂时本地仅支持谷歌
     */

    public static WebDriver browser(String browserType) {
        if ("chrome".equals(browserType)) {
            logger.info("打开谷歌浏览器");
            System.setProperty("webdriver.chrome.driver", "/Users/xlee/IdeaProjects/AutoTest/libs/chromedriver");
            return new ChromeDriver();
        }
        else if("firefox".equalsIgnoreCase(browserType)){
            logger.info("打开火狐浏览器");
            System.setProperty("webdriver.gecko.driver","src\\test\\resources\\geckodriver.exe");
            return new FirefoxDriver();
        }else if("ie".equalsIgnoreCase(browserType)){
            logger.info("打开IE浏览器");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            // 忽略掉浏览器缩放设置问题
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            // 表示让我们脚本使用对应的驱动程序iedriver.exe
            System.setProperty("webdriver.ie.driver","src\\test\\resources\\IEDriverServer.exe");
            return new InternetExplorerDriver(capabilities);
        }else {
            System.out.println("浏览器不支持，请确认你的浏览器名是否正确");
            return null;
        }
    }
}