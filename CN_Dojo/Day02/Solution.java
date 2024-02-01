import java.util.HashMap;
import java.util.Map;

public class Solution 
{
	public static int elementThatAppearsOnce(int[] arr) 
	{
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		for(Map.Entry<Integer, Integer> e : map.entrySet()){
			if(e.getValue() == 1){
				return e.getKey();
			}
		}

		return -1;
	}
}