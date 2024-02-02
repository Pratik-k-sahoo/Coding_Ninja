import java.util.* ;
import java.io.*;

public class Solution {

	public static ArrayList<ArrayList<Integer>> findGoodMatrix(ArrayList<ArrayList<Integer>> arr) {

		// Write your code here
		int rSize = arr.size();
		int cSize = arr.get(0).size();

		boolean rowZero[] = new boolean[rSize];
		boolean colZero[] = new boolean[cSize];

		for(int i=0; i<rSize; i++){
			for(int j=0; j<cSize; j++){
				if(arr.get(i).get(j) == 0){
					rowZero[i] = true;
					colZero[j] = true;
				}
			}
		}

		for(int i=0; i<rSize; i++){
			for(int j=0; j<cSize; j++){
				if(rowZero[i] || colZero[j]){
					arr.get(i).set(j, 0);
				}
			}
		}

		return arr;
	}
}