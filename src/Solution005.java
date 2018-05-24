
/*
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
输入: "babad"
输出: "bab"
注意: "aba"也是一个有效答案。

输入: "cbbd"
输出: "bb"
 */
public class Solution005 {
    public int start = 0;
    public int len = 0;

    public static void main(String[] args) {
        System.out.println(new Solution005().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }

        return s.substring(start, start + len);
    }

    public void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (len < right - left - 1) {
            start = left+1;
            len = right - left - 1;
        }
    }

}
