/*
 *AutoTestDemo by lee 2021
 */

package AutoTest001;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class test001 {
    static final Logger logger = Logger.getLogger(String.valueOf(Log.class));
    douyinLogin a = new douyinLogin();
    otherOperate quit = new otherOperate();
    CommonUtils commonUtils = new CommonUtils();

    @Before
    public void setA() {

    }

    @Test
    public void run() throws Exception {

        // 获取
        String path2 = "/Users/xlee/IdeaProjects/AutoTest/src/sql2.xml";
        String s = commonUtils.getElementText(path2, "insert_1");
        logger.info(s);

        List<String> list = commonUtils.getElementTextList(path2, "del_group");
        logger.info(String.valueOf(list));

        String s2 = commonUtils.getElementText(path2, "del_group_2", "del_2");
        logger.info(s2);

       /* String info = commonUtils.getProperties("even", "eveninfo");
        logger.info("环境信息是："+info);*/

        // a.login("14413439159", "0099333333");


    }

    @After
    public void end() throws Exception {
        //  quit.closeBrowser();

    }

}