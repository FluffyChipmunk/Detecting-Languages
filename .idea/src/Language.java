
import java.util.*;
import java.io.*;
public class Language {
    //fields

    int[] countLetters;
    //countLetters[0] = number of a's in the text
    int[][] countPairs;
    //countPairs[0][0] = number of "aa"'s in the text
    int[][] pairProbability;
    //pairProbability[0][0] = probability of "aa" in the text
    String languageName;

    public Language ()
    {

    } //constructor: need to initialize the arrays
    //to implement smoothing, ur array just starts as
    //counts[26] = {27, 27, 27, .... 27}
    //instead of
    //counts[26] = {0, 0, 0 ... 0}



    /*
    public void loadLanguage(String name, File f)
    {
        reads the file and returns 2d array of frequencies
        if we want to have multiple files as input, loadlanguage could add to existing arrays
    }
    */

    /*
    public File cleanFile(File f)
    {
        remove the punctuation and spaces from the file
        according to wikipedia's article about frequency analysis, letter freqencies should hold if it's just a single string of characters
    }
     */

    /*
    public double probabilityOf(String sentence)
    {
         prob[first letter of sentence][second letter]*prob[second letter][third letter]* ...

    }
    */

    /*
    public int countLetters(char c)
    {

    }
    */


    /*
    public int countLetterPair(char a, char b)
    {

    }
     */




}
