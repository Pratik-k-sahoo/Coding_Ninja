public class Solution {

  public static int numsWithProductK(int l, int r, int k) {

      // Write your code here
      int count = 0;
      for(int i=l; i<=r; i++){
          if(checkProduct(i, k)){
              count++;
          }
      }

      return count;
  }

  public static boolean checkProduct(int num, int k){
      int p = 1;
      while(num > 0){
          int r = num % 10;
          p *= r;
          num /= 10;
      }
      if(p == k){
          return true;
      }
      return false;
  }
}