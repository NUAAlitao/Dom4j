package Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class SystemTemplate {
	private static String systemName;
	private static String fileName_h;
	private static String fileName_c;
	
	public static void systemToCH(String system){
		systemName = system;
		fileName_h = "system"+system+".h";
		File file = new File(fileName_h);
		
		String tempLine = fileName_h.toUpperCase();
		tempLine = tempLine.replace('.', '_');
		String textALL = "#ifndef " + tempLine +'\n';
		textALL += "#define " + tempLine +'\n'+'\n';
		textALL += "#include<stdio.h>\n";
		textALL += "\n#endif";
		
		
		BufferedWriter out = null;
		try {
		    out = new BufferedWriter(new FileWriter(file));
			out.write(textALL);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void systemToC(String system){
		systemName = system;
		fileName_c = "system"+system+".c";
		File file = new File(fileName_c);
		
		String tempLine = fileName_c.toUpperCase();
		tempLine = tempLine.replace('.', '_');
		String textALL = "#include\""+fileName_h+"\"\n";
		
		BufferedWriter out = null;
		try {
		    out = new BufferedWriter(new FileWriter(file));
			out.write(textALL);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
