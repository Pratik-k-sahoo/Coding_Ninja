import java.util.ArrayList;

public class Solution {

	public static ArrayList<Integer> printMatrix(int[][] mat, int n, int m) {
		// Write your code here
		ArrayList<Integer> list = new ArrayList<>();
		int r = 0, c = 0;
		int inc = 0;

		int min = Math.min(n, m);
		for(int i=1; i<=min; i++){
			for(int j=0; j<i; j++){
				list.add(mat[r][c]);
				if(j+1 == i){
					break;
				}
				if(inc == 1){
					r++;
					c--;
				}else{
					r--;
					c++;
				}
			}

			if(i == min){
				break;
			}
			if(inc == 1){
				r++;
				inc = 0;
			}else{
				c++;
				inc = 1;
			}
		}

		if(r == 0){
			if(c == m - 1){
				r++;
			}else{
				c++;
			}
			inc = 1;
		}else{
			if(r == n - 1){
				c++;
			}else{
				r++;
			}
			inc = 0;
		}

		int max = Math.max(n, m) - 1;
		for(int i, j=max; j>0; j--){
			if(j > min){
				i = min;
			}else{
				i = j;
			}

			for(int k=0; k<i; k++){
				list.add(mat[r][c]);

				if(k+1 == i){
					break;
				}

				if(inc == 1){
					r++;
					c--;
				}else{
					r--;
					c++;
				}
			}

			if(r == 0 || c == m - 1){
				if(c == m - 1){
					r++;
				}else{
					c++;
				}
				inc = 1;
			}else if(c == 0 || r == n - 1){
				if(r == n - 1){
					c++;
				}else{
					r++;
				}
				inc = 0;
			}
		}

		return list;
	}

}
