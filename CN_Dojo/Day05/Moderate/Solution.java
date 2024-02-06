public class Solution {
	public static int findMin(int []arr) {
			// Write your code here.
			int i=0; int j=arr.length-1;
			while(i<j){
					int mid = i + (j-i)/2;
					if(arr[j]<arr[mid]){
							i = mid + 1;
					}else{
							j = mid;
					}
			}

			return arr[i];
	}
}