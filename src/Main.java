import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Language English = new Language("English");
        File f1 = new File("/Users/johnjoire/Documents/GitHub/Detecting-Languages/src/TrainingTexts/DonQuixote-English.txt");
        English.loadLanguage(f1);

        Language Spanish = new Language("Spanish");
        File f2 = new File("/Users/johnjoire/Documents/GitHub/Detecting-Languages/src/TrainingTexts/DonQuixote-Spanish.txt");
        Spanish.loadLanguage(f2);

        Language French = new Language("French");
        File f3 = new File("/Users/johnjoire/Documents/GitHub/Detecting-Languages/src/TrainingTexts/DonQuixote-French.txt");
        Spanish.loadLanguage(f3);

        ArrayList<Language> L = new ArrayList<>();
        L.add(English);
        System.out.println(English);
        System.out.println(English.probabilityOf("games lessons tutorials Games Lessons Tutorials Improve Communication Skills Free Grammar Games Free Grammar Videos CoursesSpeak smart"));
        System.out.println(English.probabilityOf("jeux leçon tutoriels Jeux leçons tutoriels Améliorer les compétences en communication Jeux de grammaire gratuitsVidéos de grammairegratuitesCourParlezintelligemment"));
        System.out.println(English.probabilityOf("juegos, lecciones, tutoriales. Juegos, Lecciones, Tutoriales. Mejorar las habilidades de comunicación. Juegos de gramática gratis. Videos de gramática gratis. Cursos: Habla inteligente,"));

        System.out.println(Spanish);
        System.out.println(Spanish.probabilityOf("games lessons tutorials Games Lessons Tutorials Improve Communication Skills Free Grammar Games Free Grammar Videos CoursesSpeak smart"));
        System.out.println(Spanish.probabilityOf("jeux leçon tutoriels Jeux leçons tutoriels Améliorer les compétences en communication Jeux de grammaire gratuitsVidéos de grammairegratuitesCourParlezintelligemment"));
        System.out.println(Spanish.probabilityOf("juegos, lecciones, tutoriales. Juegos, Lecciones, Tutoriales. Mejorar las habilidades de comunicación. Juegos de gramática gratis. Videos de gramática gratis. Cursos: Habla inteligente,"));

        System.out.println(French);
        System.out.println(French.probabilityOf("games lessons tutorials Games Lessons Tutorials Improve Communication Skills Free Grammar Games Free Grammar Videos CoursesSpeak smart"));
        System.out.println(French.probabilityOf("jeux leçon tutoriels Jeux leçons tutoriels Améliorer les compétences en communication Jeux de grammaire gratuitsVidéos de grammairegratuitesCourParlezintelligemment"));
        System.out.println(French.probabilityOf("juegos, lecciones, tutoriales. Juegos, Lecciones, Tutoriales. Mejorar las habilidades de comunicación. Juegos de gramática gratis. Videos de gramática gratis. Cursos: Habla inteligente,"));


    }

    /*public Language detectLanguage(List<Language> languages, String sentence)
    {
        go through arraylist of languages and return the language that has the highest probability of generating the sentence
    }
    */

}
