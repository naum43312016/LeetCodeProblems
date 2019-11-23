package naum.asafov.com.StringCompression443;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    }
}
class Solution {
    private static int compress(char[] chars)
    {
        // check if character array is null or empty
        if (chars == null || chars.length == 0)
        {
            return 0;
        }

        int i = 1; // for counting the number of repeated characters
        int j = 0; // to get the index of the character which should be changed
        int count = 1;
        while (i < chars.length)
        {
            // if it's a repeated character increase the count and index and continue
            if (chars[i - 1] == chars[i])
            {
                count++;
                i++;
                continue;
            }

            // if count is greater than 1 increment the j pointer and assign the characters in count
            if (count > 1)
            {
                String countString = Integer.toString(count);

                int length = countString.length();

                // if the count is greater than 10 it shoudl assign it as two separate charcters
                for (int k = 0; k < length; k++)
                {
                    chars[++j] = countString.charAt(k);
                }
                chars[++j] = chars[i];
                count = 1;
                i++;
            }

            else
            {
                chars[++j] = chars[i];
                i++;
            }
        }

        // if the count is greater than 1 on the last characteruse the same logic
        if (count > 1)
        {
            String countString = Integer.toString(count);
            int length = countString.length();
            for (int k = 0; k < length; k++)
            {
                chars[++j] = countString.charAt(k);
            }
        }

        chars = Arrays.copyOf(chars, j + 1);

        return chars.length;
    }
}