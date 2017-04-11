import java.util.List;

import javax.sound.sampled.LineListener;

import java.io.File;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo1 {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		File file = new File("pac1.aaxl2");		
		Document document = reader.read(file);		
		Element root = document.getRootElement();
		root = root.element("ownedPublicSection");
		List<Element> childElements = root.elements();
		
		for(Element child:childElements){
			List<Attribute> attributeList = child.attributes();
			for(Attribute attr : attributeList){
				if(attr.getName().equals("type") && attr.getValue().equals("aadl2:ProcessType")){
					List<Attribute> attrtempList = child.attributes();
					for(Attribute attrtemp : attrtempList){
					System.out.println(attrtemp.getName() + ": " + attrtemp.getValue());
					}
					List<Element> elementList = child.elements();
					for(Element ele : elementList){
						System.out.println(ele.getName() + ": " + ele.getText());
					}
				}
				
			}			
		}
		
	}

	public static void ShowElement(Element node,int count){
		Element root = node;
		int number = count+1;
		System.out.println("元素 "+ number +" 属性值：");
		List<Attribute> attributesList = root.attributes();     //返回当前元素的属性
		for(Attribute attr : attributesList){
			System.out.println(attr.getName() + ": " + attr.getValue());
		}
		List<Element> childElement = root.elements();
		for(Element ele : childElement){
			ShowElement(ele, number);
		}
	}

}
