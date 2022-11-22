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



    }
}
