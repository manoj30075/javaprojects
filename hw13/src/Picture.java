import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * This class implements a Picture Game.
 */

import java.util.Scanner;
import java.util.Vector;


public class Picture {
	final static String DOT = ".";
	final static Random randomNumberGenerator 	= new Random();

	final static int ME 			= 0;
	final static int YOU 			= 1;
	final static String[] thePlayers	= { "First", "Second" };
	final static Vector[] thePictures 	= new Vector[2];
	static String[][] yourWords 		= new String[2][2];
	static int[] correctGuessedInPrecentage = new int[2];
	static Socket socket = null;
	static int port;
	static String hostName;

	private static void printThePicture(int id)	{
		Vector<String> thePicture = thePictures[id];
		for ( int index = 0; index <  thePictures[id].size(); index++ )	{
			System.out.print("       ");
			for ( int xOuter = 0; xOuter < thePicture.elementAt(index).length(); xOuter++ )	{
				if ( randomNumberGenerator.nextInt(101) <= correctGuessedInPrecentage[id] )
					System.out.print(thePicture.elementAt(index).charAt(xOuter) );
				else
					System.out.print(DOT);
			}
			System.out.println();
		}
	}

	private static void fillThePicture(String fileName, int id)	{
		thePictures[id] = new Vector();
		try {
			PrintWriter oStream = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader iStream = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			oStream.println(fileName);
			String line = iStream.readLine();
			while (!line.equals("File sent")){
				thePictures[id].add(line);
				line = iStream.readLine();
			}
		} catch ( Exception e )	{
			System.out.println(e);
		}
	}

	private static void calculateCorrecntessAndPrint(int id )	{
		int soManyGuessed = yourWords[id][1].length();
		for ( int position = 0; position < yourWords[id][1].length(); position ++ )	{
			if  ( ("" + yourWords[id][1].charAt(position)).equals(DOT) )
				soManyGuessed--;
		}
		correctGuessedInPrecentage[id] = (int)( 100.0 *
				( (double)soManyGuessed / (double)yourWords[id][1].length() ) );
	}

	private static boolean guess(Scanner input, int id )	{
		String theGuess;
		boolean rValue = false;
		int 	position = 0;
		System.out.print(thePlayers[id] + " your turn (" + yourWords[id][1] + "): ");
		if ( input.hasNext() )	{
			theGuess = input.next();

			position = yourWords[id][0].indexOf(theGuess);

			while (position >= 0 && yourWords[id][1].charAt(position) != '.') {
				position = yourWords[id][0].indexOf(theGuess, position + 1);
			}

			if ( rValue = ( position  >= 0 ) )	{
				yourWords[id][1] = yourWords[id][1].substring(0, position ) +
						theGuess +
						yourWords[id][1].substring(position + 1);
				System.out.println( "	You guess was correct: " + yourWords[id][1] );
				calculateCorrecntessAndPrint(id);
				printThePicture(id);
			}
		}
		return rValue;
	}

	private static void initWords()	{
		for ( int id = ME; id <= YOU; id++ )	{
			yourWords[id][1]= yourWords[id][0].replaceAll(".", DOT);
		}
	}

	private static void playTheGame()	{
		Scanner userGuessInput           = new Scanner(System.in);
		boolean oneIsDone  = false;
		initWords();
		do {
			for ( int id = ME; id <= YOU; id++ )	{
				guess(userGuessInput, id);
				oneIsDone |=  ( yourWords[id][1].indexOf(DOT) < 0 );
			}

		} while ( ! oneIsDone );
		for ( int id = ME; id <= YOU; id++ )	{
			if (!yourWords[id][1].contains(DOT)) {
				System.out.println("This word guessed correctly was: " + yourWords[id][0]);
			}
		}
		userGuessInput.close();
	}

	private static void startTheGame(String[] args)	{
		for (int i=0; i<args.length; i++) {
			if (args[i].equalsIgnoreCase("-server" )) {
				hostName = args[i+1];
			} else if(args[i].equalsIgnoreCase("-port")) {
				port = Integer.parseInt(args[i+1]);
			}
		}

		try {
			socket = new Socket(hostName, port);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for ( int i = 0; i < args.length; i += 3 )	{
			int id = ( args[i].equals("-me") ? ME : YOU ) ;
			yourWords[id][0] = args[i + 2].replace(".txt", "" );
			fillThePicture( args[i + 1], id);
			if (id == 0) {
				break;
			}
		}

		playTheGame();
	}

	public static void main( String[] args ) {
		startTheGame(args);
	}
}
