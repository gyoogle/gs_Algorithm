import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class  {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        quickSort(numbers, 0, numbers.length-1);
        
        if(numbers[numbers.length-1] == 0) return "0";
        
        for (int i = numbers.length-1; i >= 0; i--) {
			sb.append(numbers[i]);
		}
        
        answer = sb.toString();
        
        return answer;
    }
	
	static void quickSort(int[] arr, int start, int end) {
		
		if(start >= end) return;
		
		if(start < end) {
			
			int i = start-1;
			int j = end+1;
			int pivot = arr[(start+end)/2];
			
			while(true) {
				
				while(Integer.parseInt(Integer.toString(arr[++i])+Integer.toString(pivot)) < Integer.parseInt(Integer.toString(pivot)+Integer.toString(arr[i]))) {}
				while(Integer.parseInt(Integer.toString(arr[--j])+Integer.toString(pivot)) > Integer.parseInt(Integer.toString(pivot)+Integer.toString(arr[j]))) {}
				
				if(i >= j) break;
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
			quickSort(arr, start, i-1);
			quickSort(arr, j+1, end);
			
		}
		
		
	}
}
