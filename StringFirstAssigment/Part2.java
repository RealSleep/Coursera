
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startS, String endS) {
        dna = dna.toLowerCase();
        startS =startS.toLowerCase();
        endS = endS.toLowerCase();
        
        int start = dna.indexOf(startS);
        if(start == -1) {
            return "";
        }
        int end = dna.indexOf(endS,start+3);
        if(end == -1) {
            return "";
        }
        
        if((end-start)%3!=0) {
            return "";
        }
        return (dna.substring(start,end+3)).toUpperCase();
    }
    public void testSimpleGene() {
        String dna = "ATAATGCGATAGTAATGC";
        System.out.println("GENE "+findSimpleGene(dna,"atg","taa"));
        dna = "TAATAA";
        System.out.println("GENE "+findSimpleGene(dna,"atg","taa"));
        dna = "ATGATG";
        System.out.println("GENE "+findSimpleGene(dna,"atg","taa"));
        dna = "ATAGTACGT";
        System.out.println("GENE "+findSimpleGene(dna,"atg","taa"));
        dna = "ATAATGCGAAGTAATGC";
        System.out.println("GENE "+findSimpleGene(dna,"atg","taa"));
        
        
    }
}
