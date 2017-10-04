import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/** * Lab 3.
 * * @author nilakrishnan
 */

public class Lab3WordCount {
    /** * Test the other two methods here.
     * * @param args inputs
     * */
    public static void main(final String[] args) {
        System.out.println("The total word count is "
                + wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")) + ".");
        String target = "prince";
        System.out.print("The count of " + target.toUpperCase() + " is "
                + countString(urlToString("http://erdani.com/tdpl/hamlet.txt"), target) + ".");
    }

    /** Retrieve contents from a URL and return them as a string.
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close(); return contents;
    }

    /** counts the number of words in the linked String.
     * @param url text to traverse through
     * @return number of words
     */
    public static int wordCount(final String url) {
        String[] script = url.split("[\\s\\,\\.\\?\\!\\;]");
        int count = script.length; for (int x = 0; x < script.length; x++) {
            if (script[x].length() == 0 || script[x].equals("[") || script[x].equals("]")
                    || script[x].equals("(") || script[x].equals(")")) {
                count--;
            }
        } return count;
    }
    /** counts the number of times word appears in text.
     * @param text text to traverse through
     * @param word target word to find
     * @return number of occurences of word in text
     */
    public static int countString(final String text, final String word) {
        String[] script = text.split("[\\s\\,\\.\\?\\!\\;]"); int count = 0;
        for (int x = 0; x < script.length; x++) {
            if (script[x].equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }
}
