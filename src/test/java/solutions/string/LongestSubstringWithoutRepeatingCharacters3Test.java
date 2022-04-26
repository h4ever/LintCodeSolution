package solutions.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharacters3Test {

    @Test
    public void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters3 testInstance = new LongestSubstringWithoutRepeatingCharacters3();
        int x = testInstance.lengthOfLongestSubstring("aabccbadedcabefg");
        System.out.println(x);
    }
}