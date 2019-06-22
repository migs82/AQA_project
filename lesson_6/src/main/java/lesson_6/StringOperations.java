package lesson_6;

import java.lang.String;

public class StringOperations {
    String str1;
    String str2;
    int n = 0;

    public String getConcat(String str1, String str2) {
        //return str1+str2;
        return str1.concat(str2);
    }

    public int stringToInt(String str) {
        return Integer.parseInt(str);
    }

    public char charAtString(String str, int i) {
        return str.charAt(i);
    }

    public int getLength(String str) {
        return str.length();
    }

    public String replaceChar(String old, char a, char b) {
        return old.replace(a, b);
    }

    public boolean endWith(String str, String str2) {
        return str.endsWith(str2);
    }

    public boolean empty(String str){
        return str.isEmpty();
    }

}
