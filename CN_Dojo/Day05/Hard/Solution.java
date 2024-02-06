
import java.util.ArrayList;
import java.util.HashMap;

class TrieNode 
{

    //    Each Trie Node contains a HashMap 'children' where each alphabet points to a Trie Node.
    public HashMap<Character, TrieNode> children;

    //    'isEnd' is true if the node represents end of a contact.
    public boolean isEnd;

    //    Constructor
    TrieNode() 
    {
        children = new HashMap<Character, TrieNode>();
        isEnd = false;
    }
}

public class Solution 
{
    public static ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr)
    {
        //    Write your code here.
        TrieNode root = new TrieNode();

        insertList(contactList, root);

        return findQuery(queryStr, root);
    }

    public static void insertList(ArrayList<String> contactList, TrieNode root){
      int len = contactList.size();
      for(int i=0; i<len; i++){

        insert(contactList.get(i), root);
      }
    }

    public static void insert(String str, TrieNode root){
        int len = str.length();

        TrieNode temp = root;

        for(int i=0; i<len; i++){
          TrieNode next = temp.children.get(str.charAt(i));

          if(next == null){
            next = new TrieNode();
            temp.children.put(str.charAt(i), next);
          }

          temp = next;

          if(i == len - 1){
            temp.isEnd = true;
          }
        }
    }

    public static ArrayList<ArrayList<String>> findQuery(String queryStr, TrieNode root){
      TrieNode prev = root;

      StringBuilder prefix = new StringBuilder();

      int len = queryStr.length();

      ArrayList<ArrayList<String>> ans = new ArrayList<>();

      for(int i=0; i<len; i++){
        prefix.append(queryStr.charAt(i));

        char lastCharEntered = prefix.charAt(i);

        TrieNode curr = prev.children.get(lastCharEntered);

        if(curr == null){
          i++;
          break;
        }

        ArrayList<String> list = new ArrayList<>();
        queryAddToList(curr, prefix.toString(), list);

        ans.add(list);

        prev = curr;
      }

      return ans;
    }

    public static void queryAddToList(TrieNode curr, String prefix, ArrayList<String> list){
      if(curr.isEnd){
        list.add(prefix);
      }

      for(char c = 'a'; c<='z'; c++){
        TrieNode next = curr.children.get(c);
        if(next != null){
          queryAddToList(next, prefix + c, list);
        }
      }
    }


}