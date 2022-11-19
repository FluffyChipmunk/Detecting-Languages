
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

    public Language (String name)
    {
        languageName = name;
        countLetters = new int[26];
        countPairs = new int[26][26];
        pairProbability = new int[26][26];

    } //constructor: need to initialize the arrays
    //to implement smoothing, ur array just starts as
    //counts[26] = {27, 27, 27, .... 27}
    //instead of
    //counts[26] = {0, 0, 0 ... 0}


    /*
    public void loadLanguage(File f)
    {
        cleanFile(f);
        Scanner fin = null;
        try
        {
            fin = new Scanner(new File("src/training texts/ENGdeclaration.txt"));
        }
        catch(Exception E)
        {
            System.out.println(E);
            System.exit(1);
        }
        int count=0; //counts chars
        fin.useDelimiter("");
        while(fin.hasNext())
        {
            try
            {
             String s = fin.next();
             System.out.println(s);
             if(s.equals("e")||s.equals("E"))
             {
                 count++;
             }

            }
            catch(Exception E)
            {
                System.out.println(E);
            }

        }
        fin.close();
        System.out.println("Done: "+ " how many chars: "+count);

        reads the file and returns 2d array of frequencies
        if we want to have multiple files as input, loadlanguage could add to existing arrays
    }
    */


    public File cleanFile(File f)
    {
        Scanner fin = null;
        try
        {
            fin = new Scanner(f);
        }
        catch(Exception E)
        {
            System.out.println(E);
            System.exit(1);
        }

        String filename = "cleaned"+f+".txt";
        File cleaned = new File(filename);
        try {
            if (cleaned.createNewFile()) //try to create new file to store the cleaned version of text if not yet created
            {
                System.out.println("File created: " + cleaned.getName());
                filename = cleaned.getName();
            }
            else
            {
                System.out.println("File already exists.");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        PrintWriter fout = null; //writer for the cleaned file
        try
        {
            fout = new PrintWriter(cleaned); //try to find file "cleaned"
        }
        catch(Exception E)
        {
            System.out.print(E);
        }

        try
        {
            fin.useDelimiter(""); //scanner looks at text one character at a time
            while(fin.hasNext())
            {
                try
                {
                    char c = fin.next().charAt(0);
                    if(Character.isLetter(c))
                    {
                        fout.write(c);
                    } //only writes the text into the cleaned file if it's a letter

                }
                catch(Exception E)
                {
                    System.out.println(E);
                }

            }
        }
        catch(Exception E)
        {
            System.out.println(E);
        }
        fout.close(); //close the writer
        return cleaned;

        //remove the punctuation and spaces from the file
        //according to wikipedia's article about frequency analysis, letter freqencies should hold if it's just a single string of characters
    }


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
