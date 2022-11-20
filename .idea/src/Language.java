
import java.util.*;
import java.io.*;
import java.text.*;
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
        for(int i=0;i<countLetters.length;i++)
        {
            i = 27;
        } //initialize countLetters[] = (27,27,...,27}
        countPairs = new int[26][26];
        for(int i=0;i<countPairs.length;i++)
        {
            for(int j =0;j<countPairs.length;j++)
            {
                countPairs[i][j]=1;
            }
        } //initialize countPairs[][] = {1,1...1}
        pairProbability = new int[26][26];

    } //constructor: need to initialize the arrays
    //to implement smoothing, ur array just starts as
    //counts[26] = {27, 27, 27, .... 27}
    //instead of
    //counts[26] = {0, 0, 0 ... 0}


    public void loadLanguage(File f)
    {
        File cleanedFile = cleanFile(f);
        Scanner fin = null;
        try
        {
            fin = new Scanner(cleanedFile);
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
            char c = fin.next().charAt(0);
            countLetters[c-97]++; //97 is ascii for 'a'
            }
            catch(Exception E)
            {
                System.out.println(E);
            }

        }
        fin.close();
        System.out.println(Arrays.toString(countLetters));

        //reads the file and adds to 2d array of frequencies
        //if we want to have multiple files as input, loadlanguage could add to existing arrays
    }



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

        String filename = ".idea/src/cleaned"+f.getName();
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
                return cleaned;
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
                    char c = Normalizer.normalize(fin.next().toLowerCase(),Normalizer.Form.NFD).charAt(0); //normalizer gets rid of accents
                    if(Character.isLetter(c))
                    {
                        fout.write(c);
                    } //only writes the text into the cleaned file if it's a letter, turns everything lowercase

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
