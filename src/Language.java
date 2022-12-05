
import java.util.*;
import java.io.*;
import java.text.*;
public class Language {
    //fields
    private int totalLetters;
    // number of letters used to compile language data
    private int[] countLetters;
    //countLetters[0] = number of a's in the text
    private int[][] countPairs;
    //countPairs[0][0] = number of "aa"'s in the text
    private double[][] pairProbability;
    //pairProbability[0][0] = log(probability of "aa" in the text)
    private String languageName;

    public Language (String name)
    {
        languageName = name;
        totalLetters = 0;
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
        pairProbability = new double[26][26];
    } //constructor: need to initialize the arrays
    //to implement smoothing, ur array just starts as
    //counts[26] = {27, 27, 27, .... 27}
    //instead of
    //counts[26] = {0, 0, 0 ... 0}


    public String toString()
    {
        return languageName;
    }
    public void loadLanguage(File f)
    {
        File cleanedFile = cleanFile(f);
        Scanner fin = null;
        try
        {
            fin = new Scanner(cleanedFile);
        }
        catch (Exception E)
        {
            System.out.println(E);
            System.exit(1);
        }
        while(fin.hasNext()) {
            try {
                String str = fin.next(); //creates string of cleaned file
                for (int i = 0; i < str.length() - 1; i++)
                {
                    char c1 = str.charAt(i);
                    char c2 = str.charAt(i + 1);
                    countPairs[c1 - 'a'][c2 - 'a']++; //counts the letter pair of the first two chars of the iteration
                    countLetters[c1 -'a']++; //counts the letter of the first char of the iteration
                }

                countLetters[str.charAt(str.length() - 1) - 'a']++; //counts the last char of the iteration
                totalLetters += str.length(); //updates number of letters used to compile language data

                for (int i = 0; i < pairProbability.length; i++) //updates pairProbability
                {
                    for (int j = 0; j < pairProbability[0].length; j++)
                    {
                        pairProbability[i][j] = Math.log(1.0 * countPairs[i][j] / totalLetters);
                    }
                }
            }
            catch(Exception E)
            {
                System.out.println(E);
            }
        }
        fin.close();
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

        String filename = "src/cleaned"+f.getName();
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
                catch (Exception E)
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

    public double probabilityOf(String sentence) { //returns probability of a sentence appearing in a given language


        sentence = sentence.toLowerCase().trim().replaceAll(" ","").replaceAll("\\p{Punct}",""); //makes lowercase and deletes spaces and punctuation
        sentence = Normalizer.normalize(sentence, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", ""); //removes accents from sentence
        double prob = 0.0;
        for (int i = 0; i < sentence.length() - 1; i++) { //iterates through each letter pair of the sentence
            char c1 = sentence.charAt(i);
            char c2 = sentence.charAt(i + 1);
            prob += pairProbability[c1 - 'a'][c2 - 'a'] / sentence.length(); //finds probability by accessing the pairProbability field
        }
        if(prob == 0.0) {
            return -1 * Double.MAX_VALUE;
        }
        return prob;
    }

    public void printPairProbs() {
        for (double[] D : pairProbability) {
            System.out.println(Arrays.toString(D));
        }
    }

    public String getLanguageName()
    {
        return languageName;
    }
}
