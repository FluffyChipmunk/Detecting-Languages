import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Language English = new Language("English");

        File f = new File(".idea/src/TrainingTexts/ENGdeclaration.txt");

        English.loadLanguage(f);


    }
}
