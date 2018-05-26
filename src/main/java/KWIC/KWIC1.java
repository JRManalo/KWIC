package KWIC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;

public class KWIC1
{
    private static ArrayList<String> linesFromFile;

    public static void main(String[] args)
    {
        getAllLines();
        shiftAllLines();
        sortLinesAlphabetically();
        writeLinesToFileAndConsole();
    }

    private static void getAllLines()
    {
        linesFromFile = new ArrayList<String>();
        Scanner fileInScanner;

        try
        {
            fileInScanner = new Scanner(new File("kwic.txt"));
            while (fileInScanner.hasNextLine())
            {
                linesFromFile.add(fileInScanner.nextLine());
            }

            fileInScanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private static void shiftAllLines()
    {
        int count = 0;
        for (String line : linesFromFile)
        {
            linesFromFile.set(count, circularShiftLine(line));
            count++;
        }
    }

    private static String circularShiftLine(String lineToShift)
    {
        String[] arrayOfWordsInLine = lineToShift.split(" ");
        String firstWordInLine = arrayOfWordsInLine[0];

        StringJoiner stringJoinerForLine = new StringJoiner(" ");

        for (int i = 1; i < arrayOfWordsInLine.length; i++)
        {
            stringJoinerForLine.add(arrayOfWordsInLine[i]);
        }

        stringJoinerForLine.add(firstWordInLine);

        return stringJoinerForLine.toString();
    }

    private static void sortLinesAlphabetically()
    {
        Collections.sort(linesFromFile);
    }

    private static void writeLinesToFileAndConsole()
    {
        FileWriter writerToFile;

        try
        {
            writerToFile = new FileWriter("ShiftedAndSortedFile.txt");

            for (String line : linesFromFile)
            {
                writerToFile.write(line);
                System.out.println(line);
            }

            writerToFile.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

