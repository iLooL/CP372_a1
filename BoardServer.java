package board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;

public class BoardServer {
	public static void main(String[] args) throws Exception {
        System.out.println("The capitalization server is running.");
        int clientNumber = 0;
        ServerSocket listener = new ServerSocket(9898);
        try {
            while (true) {
                new Board(listener.accept(), clientNumber++, clientNumber, clientNumber, args).start();
            }
        } finally {
            listener.close();
        }
    }
	
	public class Point{
		private int x;
		private int y;
		
		public void point(int x,int y) {
			this.x = x;
			this.y = x;
		}
	}
	
	private static class Board extends Thread{
		private Socket socket;
		private int clientNumber;
		private int width;
		private int height;
		private ArrayList<Point> points = new ArrayList<Point>();
		private String[] colours;
		
		
		
		public Board(Socket socket, int clientNumber, int width, int height, String[] colour) {
			this.socket = socket;
			this.clientNumber = clientNumber;
			this.width = width;
			this.height = height;
			this.colours = colour.clone(); // clones array into board object
			// we add points after this has been made? this is why we dont set it
			// in the constructor
		}
		
		public void run() {
            try {

                // Decorate the streams so we can send characters
                // and not just bytes.  Ensure output is flushed
                // after every newline.
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send a welcome message to the client.
                out.println("Hello, you are connected");

                // Get messages from the client, line by line; return them
                while (true) {
                    String input = in.readLine();
                    if (input == null || input.equals(".")) {
                        break;
                    }
                    out.println(input.toUpperCase());
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                	System.out.println("exception caught: socket can't close");
                }
                System.out.println("Connection with client closed");
            }
        }
		
	}
}
