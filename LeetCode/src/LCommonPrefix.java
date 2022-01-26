/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
* */
public class LCommonPrefix {
    public static void main(String[] args) {
        LCommonPrefix prefix = new LCommonPrefix();
        prefix.longestCommonPrefix(new String[] {"a"});
    }

    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        boolean exist = true;

        for (int i = 0; i < strs[0].length(); i++) {  //charAt index
            for (int st = 1; st < strs.length; st++) {  //String[] index
                if ( i >= strs[st].length() || strs[st].charAt(i) != strs[0].charAt(i)) {
                    exist = false;
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
