
/**
 * Write a description of class Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 extends Part3 {
    public int howMany(String a, String b) {
        int count = 1;
        int index = b.indexOf(a);
        while(index != -1) {
            index = b.indexOf(a,index);
            count++;
        }
        return count;
    }
    
    
}
