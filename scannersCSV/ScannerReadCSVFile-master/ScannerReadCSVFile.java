import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ScannerReadCSVFile
{
    public void run() throws FileNotFoundException {
        // Mr. Jaffe's code to read data from a file
        // Instantiate a File object
        File dataFile = new File("TestScoresByClass.csv");

        // Instantiate a Scanner object that uses the file
        Scanner scanner = new Scanner(dataFile);

        // Set the delimiter as a new-line character so we can read the
        // data one line at a time
        scanner.useDelimiter("\n");

        // Continue while there's still data in the file to be read
        while (scanner.hasNext()) {
            // Read the next line of the file
            String line = scanner.nextLine();
            String[] array = line.split(",");
            int c = 0;
            String sect = "";
            for (int i = 0; i < array.length; i++) {
                if (i == 0){
                    sect = array[i];
                }
                else {
                    int b = Integer.parseInt(array[i]);
                    c = (c + b);
                }
            }
            c = (c/10);
            String out = (sect + ": " + c);
            System.out.println(out);
        }
    }    

    public static void main (String[] args) {
        try {
            ScannerReadCSVFile srCsv = new ScannerReadCSVFile();
            srCsv.run();
        } catch (FileNotFoundException e) {
            System.out.println("404 File not found");
        } catch (Exception e) {
            System.out.println("Error");

        }
    }
}

