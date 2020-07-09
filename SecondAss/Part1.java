import edu.duke.*;
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon,startIndex);
        while(currIndex != -1) {
            if((currIndex-startIndex)%3==0){
                return currIndex;
            }
            currIndex = dna.indexOf(stopCodon,currIndex);
        }
        return dna.length();
    }
    
    public String findGene(String dna, int where) {    
        int startIndex = dna.indexOf("atg",where);
        if(startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"taa");
        int tagIndex = findStopCodon(dna,startIndex,"tag");
        int tgaIndex = findStopCodon(dna,startIndex,"tga");
        int minIndex = Math.min(taaIndex,Math.min(tagIndex,tgaIndex));
        if(minIndex==dna.length()) {
            return "";
        }
        return dna.substring(startIndex,minIndex+3);
    }
    
    public void printAllGenes(String dna) {
        int startIndex = 0;
        int count = 0;
        while(true) {
            String temp = findGene(dna,startIndex);
            if(temp.isEmpty()) {
                break;
            }
            count++;
            System.out.println(temp);
            startIndex = temp.indexOf(temp, startIndex) + temp.length();
        }
        System.out.println(count);
    }
    
    public void testFindGene() {
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        System.out.println(5);
        printAllGenes(dna);
    }
}
