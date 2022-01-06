/**
 * Number Counter class.
 *
 * @author Manoj kumar reddy Palasamudram mp6112
 * @author Ashwath Sreedhar Halemane ah7387
 */

import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;

public class NumberCounter {
    public static Map<String, Integer> ticketsHashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        /***
         * Main method
         */
        String fileName = "";
        FileInputStream streamFile = null;
        GZIPInputStream gzipFile = null;

        if (args.length > 0) {
            fileName = args[0];
        }

        try {
            if (fileName.endsWith("gz")) {
                streamFile = new FileInputStream(fileName);
                gzipFile = new GZIPInputStream(streamFile);
                inputStreamReader(gzipFile);
            } else if (args.length > 0)  {
                streamFile = new FileInputStream(fileName);
                inputStreamReader(streamFile);
            } else {
                inputStreamReader(System.in);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (streamFile != null) {
                streamFile.close();
            }
            if (gzipFile != null) {
                gzipFile.close();
            }
        }
        printHashMap();
    }

    public static void printHashMap() {
        /***
         * Prints the HashMap
         */
        Set<String> entries= ticketsHashMap.keySet();
        List<String> listOfKeys = new ArrayList<>(entries);
        Collections.sort(listOfKeys);

        for(String key: listOfKeys) {
            if ((Integer.parseInt(key) % 4) == 1) {
                System.out.println();
            }
            System.out.print(key + ": " + ticketsHashMap.get(key) + " ");
        }
    }

    public static void inputStreamReader(InputStream streamFile) throws IOException {
        /***
         * Reads the input stream and counts the number of tickets
         */
        Reader r = new InputStreamReader(streamFile);
        BufferedReader b = new BufferedReader(r);
        String readline;
        String[] tickets;

        b.readLine();
        while ((readline = b.readLine()) != null) {
            tickets = readline.split(",");
            String[] ticketsInArray = tickets[1].split(" ");

            for (String s : ticketsInArray) {
                if (ticketsHashMap.containsKey(s)) {
                    ticketsHashMap.put(s, ticketsHashMap.get(s) + 1);
                } else {
                    ticketsHashMap.put(s, 1);
                }
            }

        }

        r.close();
        b.close();
    }
}
