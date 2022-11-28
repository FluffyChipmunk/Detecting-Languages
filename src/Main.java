import java.io.*;
import java.util.*;

public class Main {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {


        Language English = new Language("English");
        File f1 = new File("src/TrainingTexts/DonQuixote-English.txt");


        Language Spanish = new Language("Spanish");
        File f2 = new File("src/TrainingTexts/DonQuixote-Spanish.txt");

        Language French = new Language("French");
        File f3 = new File("src/TrainingTexts/DonQuixote-French.txt");

        ArrayList<Language> L = new ArrayList<>();
        L.add(English);
        L.add(French);
        L.add(Spanish);

        /* For testing purposes only below

        System.out.println(detectLanguage(L, "I play many games and tutorials and have lessons everyday"));

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
        */

        //start of menu
        System.out.println("Welcome to the language detector created by Ashley Bao and John Joire");
        System.out.println("Loading the default languages of English, Spanish, and French");
        English.loadLanguage(f1);
        Spanish.loadLanguage(f2);
        French.loadLanguage(f3);

        while(true)
        {
            System.out.println("MENU");
            System.out.println("1.add language");
            System.out.println("2.load new text files");
            System.out.println("3.display current languages");
            System.out.println("4.enter string you want to know the language of");
            System.out.println("0.exit");
            String input = userInput.nextLine();
            try
            {
                int choice = Integer.parseInt(input);
                switch(choice)
                {
                    case 1:
                        System.out.println("Enter language name");
                        L.add(new Language(userInput.nextLine()));
                        System.out.println("Added.");
                        break;
                        case 2:
                        System.out.println("What is the address of the text file?");
                        String newFile = userInput.nextLine();
                        System.out.println("Which language?");
                        String language = userInput.nextLine();
                        try
                        {
                            findLanguage(L,language).loadLanguage(new File(newFile));
                            System.out.println("file loaded");
                        }
                        catch(Exception E)
                        {
                            System.out.println("File not found");
                            System.out.println(E);
                        }
                        break;
                    case 3:
                        System.out.println(L);
                        break;
                    case 4:
                        System.out.println("The longer the string, the more accurate the guess.");
                        String sentence = userInput.nextLine();
                        System.out.println(detectLanguage(L,sentence));
                        break;
                    case 0:
                        EndScreen endScreen = new EndScreen();
                        endScreen.DisplayScreen();
                        endScreen.paint(endScreen.getGraphics());
                        System.exit(0);
                    default:
                        System.out.println("Not a choice");
                        break;
                }
            }
            catch(Exception E)
            {
                System.out.println(E);
            }
        }

    }

    public static Language detectLanguage(List<Language> languages, String sentence)
    {
        int mostProbable =0;
        for(int i =0; i<languages.size(); i++)
        {
            if(languages.get(mostProbable).probabilityOf(sentence)<languages.get(i).probabilityOf(sentence))
            {
                mostProbable = i;
            }
        }

        return languages.get(mostProbable);
        //go through arraylist of languages and return the language that has the highest probability of generating the sentence
    }

    public static Language findLanguage(List<Language> languages, String languageName)
    {
        for(Language L: languages)
        {
            if(L.getLanguageName().equalsIgnoreCase(languageName))
                return L;
        }
        return null;
    }

}
