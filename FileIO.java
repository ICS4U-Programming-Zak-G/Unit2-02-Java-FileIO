// Import libraries
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

/** .
* This reads a file and outputs the sum of numbers on each line.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-03-05
*/

// Creating class
public final class FileIO {

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // Introduce program to user
        System.out.println("This calculates the sum with inputs from a file");

        // Pass the path to the file as a parameter
        File file = new File("./input.txt");
        Scanner sc = new Scanner(file);

        // Loop while there's another line in the file'
        while (sc.hasNextLine()) {

            // Initialize sum
            int sum = 0;

            // Assign current line to variable
            String line = sc.nextLine();

            // Split line into array of strings
            String[] lineArrayStr = line.split(" ");

            // Try catch
            try {

                // Iterate through array of strings
                for (String numberStr : lineArrayStr) {

                    int numberInt = Integer.parseInt(numberStr);

                    // Calculate sum
                    sum += numberInt;
                }
                // Append sum for later file writing
                outputStr += sum + "\n";

                // Catch invalid non-numeric inputs
            } catch (NumberFormatException error) {
                System.out.println("Please enter a valid input. "
                        + error.getMessage());

            }
        }
        // Print output string
        System.out.print(outputStr);

        // Close scanner
        sc.close();

        // Write output string to output file
        FileWriter myWriter = new FileWriter("output.txt");
        myWriter.write(outputStr);
        myWriter.close();

    }

}
