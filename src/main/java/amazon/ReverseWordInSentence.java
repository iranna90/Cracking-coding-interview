package amazon;

import java.util.Stack;

/*
Reverse Words in a Sentence
Reverse the order of words in a given sentence (an array of characters).

"Hello World"  ----> "World Hello"
 */
public class ReverseWordInSentence {

    public static void main(String[] args) {
        System.out.println(reverseWord("Hello world"));
        System.out.println(reverseWord("abcdefgh"));
        System.out.println(reverseWord("a b c d e f g h"));
    }

    // start from end once you reach white space add that word to builder
    // time is n ans space is n
    // Hello World"  ----> "dlroW olleH"
    private static String reverseWord(String sentence) {
        int end = sentence.length() - 1;
        StringBuilder result = new StringBuilder();
        Stack<Character> subWord = new Stack<>();
        while (end >= 0) {

            char charAt = sentence.charAt(end);

            if (charAt == ' ') {
                while (!subWord.empty()) {
                    result.append(subWord.pop());
                }
                result.append(' ');
            } else {
                subWord.push(charAt);
            }

            end--;
        }

        while (!subWord.empty()) {
            result.append(subWord.pop());
        }

        return result.toString();
    }
}
