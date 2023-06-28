package arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrrayUniqueElements {

	public static void main(String[] args) {
		//uniqueArrayUsingList();
		arrayUniqueElement();
	}

	private static void uniqueArrayUsingList() {
		int arr[] = { 3, 1, 2, 5, 4, 2, 2, 9, 3, 9, 5, 3 };// 1,2,5,4,9,3
		List<Integer> uniqueValues = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (!uniqueValues.contains(arr[i])) {
				uniqueValues.add(arr[i]);
			}
		}
		uniqueValues.stream().forEach(s -> System.out.println(s));
	}
	private static void arrayUniqueElement() {
		//create an integer array having some duplicate elements   
        int arrayWithDuplicates[] = { 10, 3, 5, 3, 9, 22, 4, 3, 1, 5, 6 };  
          
        //calculate length of the arrayWithDuplicates array   
        int len = arrayWithDuplicates.length;   
          
        //create an integer array to store distinct elements   
        int[] distinctArray = new int[len];  
          
        //integer variable to increment array index  
        int index = 0;  
          
        // outermost loop to take element one by one from the leftmost side  
        for (int i = 0; i < len; i++)   
        {   
            int flag = 0;  
            //innermost loop to make comparision between elemnts and skip duplicate elements  
            for (int j = 0; j < i; j++){  
                if (arrayWithDuplicates[i] == arrayWithDuplicates[j]){   
                    flag = 1;  
                    break;   
                }  
            }  
            //store or print the element if it is not present in the distinctArray  
            if (flag == 0){   
                distinctArray[index] = arrayWithDuplicates[i];  
                index++;    //increment index value  
            }  
        }  
        //print distinctArray   
        for(int i = 0; i < index; i++)  
            System.out.print( distinctArray[i] + " ");  
	}
}
