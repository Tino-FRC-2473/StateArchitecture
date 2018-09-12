package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A convenience extension of the ServerSocket class that has built in methods
 * for sending and receiving lines through the connection.
 * @author JosephM
 */
public class UtilityServerSocket extends ServerSocket {
	private BufferedReader reader;
	private PrintStream stream;
	private Socket socket;
	private boolean connected;
	
	/**
	 * tbd
	 * @param port The port the connection is occurring on.
	 * @throws IOException If an I/O error occurs when creating the serversocket.
	 */
	public UtilityServerSocket(int port) throws IOException {
		super(port);
		connected = false;
	}
	
	/**
	 * tbd
	 * @throws IOException If an I/O error occurs when creating the serversocket.
	 */
	public void connect() throws IOException {
		if(!connected) {
			System.out.println("WAITING FOR CLIENT CONNECTION");
			socket = super.accept();
			System.out.println("CONNECTED");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stream = new PrintStream(socket.getOutputStream());
			connected = true;
		}
	}
	
	/**
	 * Sends a string to the server end of the connection. This string automatically
	 * has a newline character appended to it.
	 * @param s the string to send
	 * @throws IOException If an I/O error occurs when creating the serversocket.
	 */
	public void sendLine(String s) throws IOException {
		if(!connected) connect();
		stream.print(s + "\n");
	}
	
	/**
	 * Obtains the string the server end of the connection sent, or null if nothing
	 * was sent. If the server end has sent multiple strings since the last time
	 * this method was called, they will be buffered and the oldest unread string
	 * will be returned.
	 * @return the string obtained
	 * @throws IOException If an I/O error occurs when creating the serversocket.
	 */
	public String getLine() throws IOException {
		if(!connected) connect();
		try {
			if(reader.ready()) {
				return reader.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
		return null;	
	}

	public Socket getSocket() {
		return socket;
	}
}
