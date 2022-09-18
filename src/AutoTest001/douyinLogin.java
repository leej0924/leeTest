package AutoTest001;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class douyinLogin {
    static Logger logger = Logger.getLogger(Log.class);
    otherOperate a = new otherOperate();
    CommonUtils commonUtils = new CommonUtils();

    public void addExpression(int num) throws Exception {

    }

    public void setAttributes(int num, String i, String b) throws Exception {

    }

    public void setOperator(int num, String type, String b) throws Exception {

    }


    public void login1(String Num, String VfCode, String[][] rulesArray2, String[][] rulesArray1) throws Exception {
        // 配置属性、运算符
        for (int i = 0; i < rulesArray2.length; i++) {
            setAttributes(i, rulesArray2[i - 1][0], rulesArray2[i - 1][1]);
            setOperator(i, "LeftValue", rulesArray2[i - 1][2]);
        }

    }

    // 配置表达式
    public void eXpression(int num, String[][] rulesArray, String[][] rulesArray1) throws Exception {
        // 添加表达式
        addExpression(num);
        // 配置左括号
        String arry[] = rulesArray[0];
        for (int i = 0; i < arry.length; i++) {
            logger.info("i");
            logger.info(arry[0]);
            logger.info(arry[1]);
        }


    }

    // 登陆抖音
    public void login(String Num, String VfCode) throws Exception {

        // 设置驱动路径
        System.setProperty("webdriver.chrome.driver", "/Users/xlee/IdeaProjects/AutoTest/libs/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        // 访问抖音官网
        logger.info("进入抖音官网");
        webDriver.get("https://www.douyin.com/");

        logger.info("等待页面加载，等待3秒");
        Thread.sleep(3000);
        // 最大化窗口
        webDriver.manage().window().maximize();
        sleep(2000);

        // 登陆操作
        String loginXpath = "//*[@id='qdblhsHs']/button";
        String mima = "//*[@class='web-login-tab-list__item'][text()='密码登录']";
        WebElement wl = webDriver.findElement(By.xpath(loginXpath));
        if (a.isElementExist(webDriver,By.xpath(mima),5)) {
            logger.info("登录窗口已存在，直接登录操作……");

        }
        else{
            logger.info("点击首页登陆按钮");
            wl.click();
            sleep(1000);

        }

        // 硬等待5秒钟
        sleep(5000);
        logger.info("选择密码登录");
        WebElement mimawl = webDriver.findElement(By.xpath(mima));
        mimawl.click();
        sleep(1000);

        logger.info("输入登陆手机号码：" + Num);
        webDriver.findElement(By.xpath("//*[@placeholder='手机号']")).sendKeys(Num);
        sleep(1000);
        logger.info("输入密码：" + VfCode);
        webDriver.findElement(By.xpath("//*[@placeholder='请输入密码']")).sendKeys(VfCode);
        sleep(1000);
        logger.info("点击登陆按钮");
        webDriver.findElement(By.xpath(commonUtils.getXmlInfo("login"))).click();
        sleep(1000);
    }
}