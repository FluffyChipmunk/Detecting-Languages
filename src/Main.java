import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Language English = new Language("English");

        File f = new File("src/TrainingTexts/ENGdeclaration.txt");

        English.loadLanguage(f);

        ArrayList<Language> L = new ArrayList<>();
        L.add(English);
        System.out.println(English);
        English.printPairProbs();
    }

    /*public Language detectLanguage(List<Language> languages, String sentence)
    {
        go through arraylist of languages and return the language that has the highest probability of generating the sentence
    }
    */

}
