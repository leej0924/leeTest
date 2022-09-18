package AutoTest001;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class element {
    /**
     * 定义抖音登录界面元素element
     * @param driver
     * @return
     */

    public WebElement loginbtn(WebDriver driver) {
        WebElement login = otherOperate.getElement("//*[@class=\"web-login-button\"][text()='登录']", driver);
        return login;

    }
    public WebElement mima(WebDriver driver) {
         WebElement login2 = otherOperate.getElement("//*[@class=\"web-login-button\"][text()='登录']", driver);
        return login2;

    }
}
