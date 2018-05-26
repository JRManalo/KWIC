package KWIC2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LineIO
{
    private ManageLine theManager;
    private File theFile;
    private static final String filename = "kwic.txt";

    public LineIO(ManageLine manager)
    {
        theManager = manager;

        theFile = new File(filename);
    }

    public void readLines()
    {
        Scanner fileInScanner;

        try
        {
            fileInScanner = new Scanner(theFile);
            while (fileInScanner.hasNextLine())
            {
                theManager.addLine(fileInScanner.nextLine());
            }

            fileInScanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void writeLines()
    {
        FileWriter writerToFile;

        try
        {
            writerToFile = new FileWriter("ShiftedAndSortedFile.txt");

            for (int i = 0; i < theManager.getNumLines(); i++)
            {
                writerToFile.write(theManager.getLine(i));
                System.out.println(theManager.getLine(i));
            }

            writerToFile.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}