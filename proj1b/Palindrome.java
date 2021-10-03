public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        //Character.toString(text.charAt(0)) @from internet
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        int j = word.length() - 1;
        for (int i = 0; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if(word.length() <= 1) {
            return true;
        }
        int j = word.length() - 1;
        for (int i = 0; i < j; i++, j--) {
            if(!cc.equalChars(word.charAt(i), word.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
