import edu.duke.*;
import java.io.*;
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        int start = dna.indexOf("ATG");
        if(start == -1) {
            return "";
        }
        int end = dna.indexOf("TAA",start+3);
        if(end == -1) {
            return "";
        }
        
        if((end-start)%3!=0) {
            return "";
        }
        return dna.substring(start,end+3);
    }
    public void testSimpleGene() {
        String dna = "ATAATGCGATAGTAATGC";
        System.out.println("GENE "+findSimpleGene(dna));
        dna = "TAATAA";
        System.out.println("GENE "+findSimpleGene(dna));
        dna = "ATGATG";
        System.out.println("GENE "+findSimpleGene(dna));
        dna = "ATAGTACGT";
        System.out.println("GENE "+findSimpleGene(dna));
        dna = "ATAATGCGAAGTAATGC";
        System.out.println("GENE "+findSimpleGene(dna));
        
        
    }
    public void realTesting() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String s = fr.asString();
            System.out.println("read " + s.length() + " characters");
            String result = findSimpleGene(s);
            System.out.println("found " + result);
        }
    }
}
