package solutions.carl.hashtable;

public class RansomNote383 {
    /*
    给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。



示例 1：

输入：ransomNote = "a", magazine = "b"
输出：false
示例 2：

输入：ransomNote = "aa", magazine = "ab"
输出：false
示例 3：

输入：ransomNote = "aa", magazine = "aab"
输出：true


提示：

1 <= ransomNote.length, magazine.length <= 105
ransomNote 和 magazine 由小写英文字母组成
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomArray = new int[26];
        int[] magazineArray = new int[26];

        for (char c : ransomNote.toCharArray()) {
            ransomArray[c-'a']++;
        }

        for (char c : magazine.toCharArray()) {
            magazineArray[c-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(ransomArray[i]>magazineArray[i]){
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] magazineArray = new int[26];


        for (char c : magazine.toCharArray()) {
            magazineArray[c-'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            magazineArray[c-'a']--;
            if(magazineArray[c-'a']<0){
                return false;
            }
        }

        return true;
    }
}
