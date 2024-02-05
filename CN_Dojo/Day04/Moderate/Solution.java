import java.util.* ;
import java.io.*; 
public class Solution {

	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

	    // Write your code here.
		Arrays.sort(arr);
		HashSet<ArrayList<Integer>> ans = new HashSet<>();

		for(int i=0; i<n-2; i++){
			int leftPointer = i+1;
			int rightPointer = n-1;
			while(leftPointer < rightPointer){
				int sum = arr[i] + arr[leftPointer] + arr[rightPointer];
				if(sum == K){
					ArrayList<Integer> list = new ArrayList<>();
					list.add(arr[i]);
					list.add(arr[leftPointer]);
					list.add(arr[rightPointer]);
					ans.add(list);
					leftPointer++;
					rightPointer--;
				}
				else if(sum < K){
					leftPointer++;
				}
				else{
					rightPointer--;
				}
			}
		}

		return new ArrayList<>(ans);

	}
}
