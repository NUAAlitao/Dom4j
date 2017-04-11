import java.util.List;

import javax.sound.sampled.LineListener;

import java.io.File;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Template.SystemTemplate;

public class Demo1 {

	//static Integer number = new Integer(0);
	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		
		SAXReader reader = new SAXReader();
		File file = new File("pac1.aaxl2");		
		Document document = reader.read(file);		
		Element root = document.getRootElement();
		Num number = new Num();
		ShowElement(root, number);
		
		
		
	}

	public static void ShowElement(Element node,Num number){
		Element root = node;
		number.number++;
		System.out.println("元素 "+ number.number +" 属性值：");
		List<Attribute> attributesList = root.attributes();     //返回当前元素的属性
		for(Attribute attr : attributesList){
			if(attr.getName().equals("type") && attr.getValue().equals("aadl2:SystemType")){
				for(Attribute attrTemp : attributesList){
					if(attrTemp.getName().equals("name")){
						String systemName = attrTemp.getValue();
						SystemTemplate.systemToCH(systemName);
						SystemTemplate.systemToC(systemName);
						
					}
				}
				
			}
			
		}
		System.out.println("元素 "+ number.number+ " 内容：" + root.getText());
		System.out.println();
		List<Element> childElement = root.elements();
		for(Element ele : childElement){
			ShowElement(ele,number);
		}
	}

}

class Num{
	public int number=0;
}
