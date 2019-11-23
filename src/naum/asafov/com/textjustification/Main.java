package naum.asafov.com.textjustification;

import java.util.ArrayList;
import java.util.List;
/*
Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example:
Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
kajdaya stroka doljna imet 16 simvolov
 */
public class Main {
    public static void main(String[] args) {
        /*String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;*/
        String[] words ={"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
        int maxWidth = 30;
        List<String> list = new Solution().fullJustify(words,maxWidth);
        System.out.println(list.toString());
    }
}

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words==null || words.length<1){
            return new ArrayList<>();
        }
        if (maxWidth==0){
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        for (int i = 0;i<words.length;i++){
            int sum = words[i].length();
            if (i==words.length-1) {
                addToList(maxWidth,words,list,i,i);
            }else if (sum == maxWidth){
                addToList(maxWidth,words,list,i,i);
            }else {
                int j = i + 1;
                for (; j < words.length; j++) {
                    sum++;//space
                    sum+=words[j].length();
                    if (sum == maxWidth){
                        addToList(maxWidth,words,list,i,j);
                        i = j;
                        break;
                    }
                    if (sum > maxWidth){
                        addToList(maxWidth,words,list,i,--j);
                        i=j;
                        break;
                    }
                }
                if (j==words.length){
                    addToList(maxWidth,words,list,i,--j);
                    i=j;
                }
            }
        }

        return list;
    }

    void addToList(int maxWidth,String[] words,List<String> list,int left,int right){//including right
        StringBuilder str = new StringBuilder();
        boolean last = false;
        int countW = right-left;
        if (right==words.length-1) last=true; //if right is last word in arr last is true
        if (left==right){
            str.append(words[left]);
            int i = words[left].length();
            for (;i<maxWidth;i++){
                str.append(" ");
            }
        }else if (countW==1 && !last){

            int l = left;
            int sum = 0;//sum of all chars in str
            while (l <= right) {
                sum += words[l].length();
                l++;
            }
            int spaces = maxWidth - sum;
            l = left;
            str.append(words[left]);
            for (int i = 0;i<spaces;i++){
                str.append(" ");
            }


            str.append(words[right]);

        }else {
            int l = left;
            if (last){
                //Add spaces between words
                while (l<right){
                    str.append(words[l]);
                    str.append(" ");
                    l++;
                }
                str.append(words[right]);
                int i = str.toString().length();
                for (;i<maxWidth;i++){
                    str.append(" ");
                }
            }else {
                int wordCount = right - left;
                //Add spaces between words
                //0=2
                int sum = 0;//sum of all chars in str
                while (l <= right) {
                    sum += words[l].length();
                    l++;
                }
                //sum=10
                boolean even = false;
//max = 30;//wordc=5//sum=3+7+1+3+4+5=23//spaces=7
                int spaces = maxWidth - sum;//need 7 spaces

                if (spaces - wordCount == 1) {
                    spaces = spaces / wordCount;
                    l = left;
                    while (l < right) {
                        str.append(words[l]);
                        if ( l == left) {
                            for (int j = 0; j <= spaces; j++) {
                                str.append(" ");
                            }
                        } else {
                            for (int j = 0; j < spaces; j++) {
                                str.append(" ");
                            }
                        }
                        l++;
                    }
                } else {
//max = 30;//wordc=5//sum=3+7+1+3+4+5=23//spaces=7
                    if (spaces % wordCount == 0) {
                        even = true;
                    }else {
                        even=false;
                    }
                    int sp = spaces;
                    spaces = spaces / wordCount;

                    //

                    l = left;
                    //int sp = spaces;

                    while (l < right) {
                        str.append(words[l]);
                        if (!even && l != right - 1 && sp>wordCount) {
                            for (int j = 0; j <= spaces; j++) {
                                str.append(" ");
                                //
                                sp--;
                            }
                        } else {
                            for (int j = 0; j < spaces; j++) {
                                //System.out.println("sp="+sp+":words="+words[l]);
                                str.append(" ");
                                sp--;
                            }
                        }

                        wordCount--;
                        /*if ((sp-wordCount)<=spaces+1){
                            sp=0;
                        }*/
                        if(spaces*wordCount == sp){
                            sp=0;
                        }
                        l++;
                    }
                }

                str.append(words[right]);
            }

        }



        //String s = str.toString();
        //System.out.println(s +"="+s.length());
        list.add(str.toString());
        //System.out.println("L="+left+":R="+right);
    }
}