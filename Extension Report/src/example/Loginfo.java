package example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Loginfo 
{
	public static void main(String[] args) throws IOException {
		ExtentReports er = new ExtentReports();
		ExtentSparkReporter sr = new ExtentSparkReporter("C:\\Users\\91766\\eclipse-workspace\\Extension Report\\reporter.html");
		er.attachReporter(sr);
		
		er.createTest("Test1")
		.log(Status.INFO, "<b>info</b>")
		.log(Status.INFO,"<i>info</i>")
		.log(Status.INFO, "<b><i>info</b></i>");
		
		String xmldata = "<suite name=\"Gmail\">\r\n"
				+ "	<test name=\"verify the text box error message\">\r\n"
				+ "		<classes>\r\n"
				+ "			<class name=\"gamil.CreateAccountErrorMsg\" />\r\n"
				+ "		</classes>\r\n"
				+ "	</test>\r\n"
				+ "</suite>";
		
		String jsn ="{  \r\n"
				+ "    \"employee\": {  \r\n"
				+ "        \"name\":       \"sonoo\",   \r\n"
				+ "        \"salary\":      56000,   \r\n"
				+ "        \"married\":    true  \r\n"
				+ "    }  \r\n"
				+ "}  ";
		
		er.createTest("Test xml")
		.info(MarkupHelper.createCodeBlock(xmldata,CodeLanguage.XML));
		
		er.createTest("Json")
		.log(Status.INFO, MarkupHelper.createCodeBlock(jsn,CodeLanguage.JSON));
		
		List<String> list=new ArrayList<String>();  
		
		 list.add("Mango");  
		 list.add("Apple");  
		 list.add("Banana");  
		 list.add("Grapes"); 
		 
		 er.createTest("List")
		 .info(MarkupHelper.createOrderedList(list))
		 .log(Status.INFO, MarkupHelper.createUnorderedList(list));
		 
		 Set<String> hash_Set = new HashSet<String>(); 
	        // Adding elements to the Set using add() method
	        hash_Set.add("Geeks");
	        hash_Set.add("For");
	        hash_Set.add("Geeks");
	        hash_Set.add("Example");
	        hash_Set.add("Set");
		 
		 er.createTest("set")
		 .info(MarkupHelper.createOrderedList(hash_Set))
		 .log(Status.INFO,MarkupHelper.createUnorderedList(hash_Set));
		 
		 Map<Integer,String> map=new HashMap<Integer,String>();   
		    //Adding elements to map  
		    map.put(1,"Amit");  
		    map.put(5,"Rahul");  
		    map.put(2,"Jai");  
		    map.put(6,"Amit");
		    
		    er.createTest("This is map")
		    .info(MarkupHelper.createOrderedList(map))
		    .log(Status.INFO, MarkupHelper.createUnorderedList(map));
		
		er.flush();
		Desktop.getDesktop().browse(new File("reporter.html").toURI());
	}

}
