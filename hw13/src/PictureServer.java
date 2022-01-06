/*
 * Program PictureServer
 *
 * @author      Manoj kumar reddy Palasamudram(mp6112)
 * @author      Ashwath Halemane(ah7387)
 */

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 PictureServer is a simple server that receives a file name and a port number
 */
public class PictureServer {
	String fileName;
	PrintWriter oStream;
	BufferedReader iStream;
	ServerSocket socket;
	int port;

	public PictureServer() {}
	/**
	 * Constructor
	 * @param port the port number to send the file to
	 */
	public PictureServer(int port) {
		try {
			socket = new ServerSocket(port);
			System.out.println("Port: " + socket.getLocalPort());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Run the server
	 */
	public void inputOutputConnections() {
		try {
			if (socket == null)
				socket = new ServerSocket(port);
			System.out.println("Listening on port: " + socket.getLocalPort());
			Socket accept = socket.accept();
			System.out.println(accept.toString());
			oStream = new PrintWriter(accept.getOutputStream(), true);
			iStream = new BufferedReader(
					new InputStreamReader(accept.getInputStream()));

			while (true) {
				fileName = iStream.readLine();
				if (fileName == null) {
					break;
				}
				fileName = fileName.strip();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
						new FileInputStream(fileName)));
				String readLine;
				while ((readLine = bufferedReader.readLine()) != null) {
					oStream.println(readLine);
				}
				oStream.println("File sent");
				bufferedReader.close();
			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	/**
	 * Parse the command line arguments and sets variables.
	 */
	private void parseArgs(String args[]) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-port")) {
				port = Integer.parseInt(args[++i]);
			}
		}
	}

	/**
	 * Main method.
	 */
	public static void main(String argv[]) {
		PictureServer ps;
		if (argv.length > 0)
			ps = new PictureServer();
		else {
			ps = new PictureServer(0);
		}
		ps.parseArgs(argv);
		ps.inputOutputConnections();
	}
}
