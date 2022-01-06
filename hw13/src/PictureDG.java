import java.util.Random;
import java.net.DatagramSocket;
import java.util.Scanner;
import java.net.DatagramPacket;
import java.util.Vector;
import java.net.InetAddress;

public class PictureDG {
	final static String PERIOD = ".";
	final static Random random = new Random();
	final static Vector[] pictures = new Vector[2];
	static String[][] words = new String[2][2];
	static int port;
	static String host;
	final static int PLAYER_1 = 0;
	final static int PLAYER_2 = 1;
	final static String[] players = { "First", "Second" };
	static int[] correctGuessRatio = new int[2];

	private static void printThePicture(int id)	{
		Vector<String> thePicture = pictures[id];
		for (int index = 0; index <  pictures[id].size(); index++ )	{
			System.out.print("       ");
			for ( int xOuter = 0; xOuter < thePicture.elementAt(index).length(); xOuter++ )	{
				if ( random.nextInt(101) <= correctGuessRatio[id] )
					System.out.print(thePicture.elementAt(index).charAt(xOuter) );
				else
					System.out.print(PERIOD);
			}
			System.out.println();
		}
	}

	private static void fillThePicture(String fileName, int id)	{
		pictures[id] = new Vector();
		byte[] bytes = new byte[256];

		try {
			DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
			DatagramSocket datagramSocket = new DatagramSocket();
			InetAddress address = InetAddress.getByName(host);
			bytes = fileName.getBytes();
			DatagramPacket datagramPacket1 = new DatagramPacket(bytes, bytes.length, address, port);
			datagramSocket.send(datagramPacket1);

			while (true) {
				datagramSocket.receive(datagramPacket);
				String line = new String(datagramPacket.getData());
				if (line.contains("File sent"))
					break;
				pictures[id].add(line.trim());
			}
		} catch ( Exception e )	{
			System.out.println(e);
		}
	}

	private static void calculateCorrecntessAndPrint(int id )	{
		int soManyGuessed = words[id][1].length();
		for (int position = 0; position < words[id][1].length(); position ++ )	{
			if  ( ("" + words[id][1].charAt(position)).equals(PERIOD) )
				soManyGuessed--;
		}
		correctGuessRatio[id] = (int)( 100.0 *
				( (double)soManyGuessed / (double) words[id][1].length() ) );
	}

	private static boolean guess(Scanner input, int id )	{
		String theGuess;
		boolean rValue = false;
		int 	position = 0;
		System.out.print(players[id] + " your turn (" + words[id][1] + "): ");
		if ( input.hasNext() )	{
			theGuess = input.next();
			
			position = words[id][0].indexOf(theGuess);
			
			while (position >= 0 && words[id][1].charAt(position) != '.') {
				position = words[id][0].indexOf(theGuess, position + 1);
			}
			
			
			if ( rValue = ( position  >= 0 ) )	{
				words[id][1] = words[id][1].substring(0, position ) +
						theGuess +
						words[id][1].substring(position + 1);
				System.out.println( "	You guess was correct: " + words[id][1] );
				calculateCorrecntessAndPrint(id);
				printThePicture(id);
			}
		}
		return rValue;
	}

	private static void initWords()	{
		for (int id = PLAYER_1; id <= PLAYER_2; id++ )	{
			words[id][1]= words[id][0].replaceAll(".", PERIOD);
		}
	}

	private static void playTheGame()	{
		Scanner userGuessInput = new Scanner(System.in);
		boolean oneIsDone = false;
		initWords();
		do {
			for (int id = PLAYER_1; id <= PLAYER_2; id++ )	{
				guess(userGuessInput, id);
				oneIsDone |=  (words[id][1].indexOf(PERIOD) < 0);
			}

		} while(!oneIsDone);
		for (int id = PLAYER_1; id <= PLAYER_2; id++)	{
			if (words[id][1].indexOf(PERIOD) < 0) {
				System.out.println("This word guessed correctly was: " + words[id][0]);
			}
		}
		userGuessInput.close();
	}

	public static void main( String[] args ) {
		for (int i=0; i<args.length; i++) {
			if (args[i].equalsIgnoreCase("-server" )) {
				host = args[i+1];
			} else if(args[i].equalsIgnoreCase("-port")) {
				port = Integer.parseInt(args[i+1]);
			}
		}

		for ( int i = 0; i < args.length; i += 3 )	{
			int id = ( args[i].equals("-me") ? PLAYER_1 : PLAYER_2) ;
			words[id][0] = args[i + 2].replace(".txt", "" );
			fillThePicture( args[i + 1], id);
			if (id == 0) {
				break;
			}
		}
		playTheGame();
	}
}
