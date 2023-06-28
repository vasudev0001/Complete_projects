package setExamples;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class BasicsLinkedHashSet {
	
	public static void main(String[] args) {
	
		LinkedHashSet<Object> l = new LinkedHashSet<>();
		System.out.println(""+l.isEmpty());
		l.add('a');
		l.add("java");
		l.add("c language");
		l.add("python");
		l.add("c++");
		System.out.println("return value for adding element: "+l.add('@'));
		System.out.println("return value for adding duplicate element: "+l.add('@'));
		
		System.out.println("size of linked list: "+l.size());
		System.out.println("remove element from the linked hashSet: "+l.remove("c language"));
		System.out.println("remove element that is not present in linked hashSet: "+l.remove("c language"));
		
		System.out.println("chech the element is present: "+l.contains("java"));
		System.out.println("check for element that is not present: "+l.contains("c language"));
		
		Iterator<Object> itr=l.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  
		
		
		
		
		
		
		System.out.println("print list: "+l);
		
		
		
		
	}

}
