import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Language English = new Language("English");

        File f = new File("/Users/johnjoire/Documents/GitHub/Detecting-Languages/src/TrainingTexts/ENGdeclaration.txt");

        English.loadLanguage(f);

        ArrayList<Language> L = new ArrayList<>();
        L.add(English);
        System.out.println(English);
        System.out.println(English.probabilityOf("games lessons tutorials Games Lessons Tutorials Improve Communication Skills Free Grammar Games Free Grammar Videos CoursesSpeak smart"));
        System.out.println(English.probabilityOf("jeux leçon tutoriels Jeux leçons tutoriels Améliorer les compétences en communication Jeux de grammaire gratuitsVidéos de grammairegratuitesCourParlezintelligemment"));

    }

    /*public Language detectLanguage(List<Language> languages, String sentence)
    {
        go through arraylist of languages and return the language that has the highest probability of generating the sentence
    }
    */

}
