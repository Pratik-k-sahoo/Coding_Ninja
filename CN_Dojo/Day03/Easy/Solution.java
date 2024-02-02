import java.util.* ;
import java.io.*; 
public class Solution {
	public static int slotScore(String original, String guess) {
		// Write your code here.
		int sum = 0;
		HashMap<Character, Integer> ogMap = new HashMap<>();
		HashMap<Character, Integer> gMap = new HashMap<>();

		for(int i=0; i<4; i++){
			char ogChar = original.charAt(i);
			char gChar = guess.charAt(i);
			if(ogChar == gChar){
				sum += 2;
			}
			else{
				ogMap.put(ogChar, ogMap.getOrDefault(ogChar, 0)+1);
				gMap.put(gChar, gMap.getOrDefault(gChar, 0)+1);
			}
		}

		for(char color : gMap.keySet()){
			if(ogMap.containsKey(color)){
				sum += Math.min(ogMap.get(color), gMap.get(color));
			}
		}

		return sum;
	}
}