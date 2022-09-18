package AutoTest001;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CommonUtils {

    /**
     * properties配置文件信息获取
     */

    public String getProperties(String file, String key) {
        String info = ResourceBundle.getBundle(file).getString(key);
        return info;
    }

    /**
     * xml配置文件信息获取
     */


    public static Document readXml(String filePath) throws DocumentException {
        return readXml(new File(filePath));
    }


    public static Document readXml(File file) throws DocumentException {
        SAXReader reader = new SAXReader();
        return reader.read(file);
    }

    public static Document readXml(InputStream inputStream) throws DocumentException {
        SAXReader reader = new SAXReader();
        return reader.read(inputStream);
    }


    public static Document readXmlFromResources(String resource) throws DocumentException, IOException, URISyntaxException {
        File file = new File(resource);
        SAXReader reader = new SAXReader();
        return reader.read(file);
    }


    public static String getAttribute(Element element, String attrName) {
        return element.attributeValue(attrName);
    }

    public static String getText(Element element) {
        return element.getText();
    }

    public static List<Element> getElements(Element element, String tagName) {
        return element.elements(tagName);
    }

    /**
     * 根据节点名称获取子节点数据
     */
    public static String getElementText(String resource, String qName) throws Exception {

        Element root = readXmlFromResources(resource).getRootElement();
        String text = root.elementText(qName);
        return text.trim();
    }

    /**
     * 根据节点名称获取子节点的子节点数据
     */
    public static String getElementText(String resource, String qName, String SubQName) throws Exception {
        Element root = readXmlFromResources(resource).getRootElement();
        String text = root.element(qName).elementText(SubQName);
        return text.trim();
    }

    /**
     * 根据节点名称获取子节点的子节点的数据列表
     */
    public static List<String> getElementTextList(String resource, String qName) throws Exception {
        List<Element> elementList = readXmlFromResources(resource).getRootElement().element(qName).elements();
        List<String> list = new ArrayList<>();
        for (Element e : elementList) {
            list.add(e.getTextTrim());
        }
        return list;
    }

    // 返回xml文件信息
    public String getXmlInfo(String type) throws Exception {
        String path2 = "/Users/xlee/IdeaProjects/AutoTest/src/douyinLogin.xml";
        String info = getElementText(path2, type);
        return info;
    }


}
