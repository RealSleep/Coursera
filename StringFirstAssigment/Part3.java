
/**
 * Write a description of class Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String pattern, String str) {
        int index = str.indexOf(pattern);
        int indexSecond = str.indexOf(pattern,index+pattern.length());
        int i = (index>0)? 1:0;
        i = (indexSecond>0)? i+1:i;
        return (i>=2);
    }
    public String lastPart(String a, String b) {
        int index = b.indexOf(a);
        if(index<0) {
            return b;
        }
        return b.substring(index+a.length());
    }
    public void testing() {
        System.out.println(lastPart("an", "banana"));
        System.out.println(lastPart("zoo", "forest"));
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana")); 
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
    }
}
