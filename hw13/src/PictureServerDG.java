/*
 * Program PictureServerDG
 *
 * @author      Manoj kumar reddy Palasamudram(mp6112)
 * @author      Ashwath Halemane(ah7387)
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class PictureServerDG {
	DatagramSocket socket;
	int port;
	String hostName;

	public PictureServerDG() {}

	// Constructor
	public PictureServerDG(int port) {
		try {
			socket = new DatagramSocket(port);
			System.out.println ("Port: " + socket.getLocalPort());
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Parse the command line arguments and sets variables.
	 */
	private void parseArgs(String args[]) {
		for (int i = 0; i < args.length; i ++) {
		   	if (args[i].equals("-host")) 
				hostName = args[++i];
		   	else if (args[i].equals("-port")) {
				port = Integer.parseInt(args[++i]);
				new PictureServerDG(port).inputOutputConnections();
			}
		}
	}

	/**
	 * Create the IO connections.
	 */
	public void inputOutputConnections() {
		try {
			while (true) {
				byte[] buf = new byte[256];
		        DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
		        InetAddress address = packet.getAddress();
		        int port = packet.getPort();
		        byte[] fileData = packet.getData();
		        
		        System.out.println("sending to host:  " + address);
				System.out.println("sending to port:  " + port);
		        
		        String fileName = new String(fileData);
		        fileName = fileName.trim();
		        System.out.println("======" + fileName + "===========");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
						new FileInputStream(fileName)));
				
				String readLine = null;
				while ((readLine = bufferedReader.readLine()) != null) {
					buf = readLine.getBytes();
					packet = new DatagramPacket(buf, buf.length, address, port);
					socket.send(packet);
				}
				
				buf = "File sent".getBytes();
				packet = new DatagramPacket(buf, buf.length, address, port);
				socket.send(packet);
				bufferedReader.close();
            }
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	/**
	 * Main method.
	 */
	public static void main(String argv[]) {
		if ( argv.length > 0 ){
			new PictureServerDG().parseArgs(argv);
		} else {
			new PictureServerDG(0).inputOutputConnections();
		}
	}
}
