package Day2;

public class StringHelper {
    public String reverseString (String s) {
        char [] ch = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        char temp;
        while(start < end) {
            temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch); // returns a string
    }

    public boolean isPalindrome (String s) {
        String reversed = reverseString(s);
        return reversed.equals(s);
    }

    public int countVowels (String s) {
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == 'a' || s.charAt(i)  == 'e' || s.charAt(i)  == 'i' || s.charAt(i)  == 'o' || s.charAt(i)  == 'u' ||
                    s.charAt(i) == 'A' || s.charAt(i)  == 'E' || s.charAt(i)  == 'I' || s.charAt(i)  == 'O' || s.charAt(i)  == 'U') {
                count = count + 1;
            }
        }
        return count;
    }
}
