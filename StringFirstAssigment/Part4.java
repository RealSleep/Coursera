import edu.duke.*;
/**
 * Write a description of class Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public void testing() {
        URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String line : url.lines()) {
            if(line.toLowerCase().contains("youtube.com")){
                int indexStart = line.indexOf("\"h");
                int indexLast = line.indexOf("\"",indexStart+2);
                System.out.println(line.substring(indexStart,indexLast+1));
            }
        }       
    }
}
