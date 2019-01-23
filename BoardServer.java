package board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * SOURCE:  http://cs.lmu.edu/~ray/notes/javanetexamples/
 *
 * A server program which accepts requests from clients to capitalize strings.
 * When clients connect, a new thread is started to handle an interactive dialog
 * in which the client sends in a string and the server thread sends back the
 * capitalized version of the string.
 *
 * The program is runs in an infinite loop, so shutdown in platform dependent.
 * If you ran it from a console window with the "java" interpreter, Ctrl+C will
 * shut it down.
 */

public class BoardServer {

    /**
     * Application method to run the server runs in an infinite loop
     * listening on port 9898.  When a connection is requested, it
     * spawns a new thread to do the servicing and immediately returns
     * to listening.  The server keeps a unique client number for each
     * client that connects just to show interesting logging
     * messages.  It is certainly not necessary to do this.
     */
	
	// args starts reading from index 0 meaning the port number is the first argument
    public static void main(String[] args) throws Exception {
    	
    	// assign port number
    	int portNumber = Integer.parseInt(args[0]);
    	//assign dimensions
    	int width = Integer.parseInt(args[1]);
    	int height = Integer.parseInt(args[2]);
    	int colourLen = args.length - 3;
    	String[] colours = new String[colourLen]; 
    	// create colour array
    	for(int i = 0; i < colourLen; i++) {
    		colours[i] = args[i + 3];
    	}
    	
//    	print debug statements
//    	System.out.println("width: " + width + "\n");
//    	System.out.println("height: " + height + "\n");
//    	for(int i = 0; i < colours.length; i++) {
//    		System.out.println("color " + i +  ": " + colours[i] + "\n");
//    	}
    	
        System.out.println("The board server is running.");
        int clientNumber = 0;
        ServerSocket listener = new ServerSocket(portNumber);
        
//		  args print debug statement
//        for(int i = 0; i < args.length; i++) {
//        	System.out.println(i + ": " + args[i]);
//        }
        
        try {
            while (true) {
                new Board(listener.accept(), width, height, colours).start();
            }
        } finally {
            listener.close();
        }
    }

    /**
     * A private thread to handle capitalization requests on a particular
     * socket.  The client terminates the dialogue by sending a single line
     * containing only a period.
     */
    
    public class Pin{
		private int x;
		private int y;
		
		public void Pin(int x,int y) {
			this.x = x;
			this.y = x;
		}
	}
    
    public class Note{
    	private String content;
    	private boolean isPinned;
    	private ArrayList<Pin> points;
    	private String colour;
    	
    	public void note(String content, String colour, int x, int y, int width, int height) {
    		this.content = content;
    		this.isPinned = false;
    		Pin p = new Pin(x,y);
    		this.points.add(pin(x,y));
    	}
    	
    }
    
    private static class Board extends Thread {
        private Socket socket;
        private int width;
        private int height;
        private String[] colours;
        private ArrayList<Pin> pins;
        private ArrayList<Note> notes;

        public Board(Socket socket, int width, int height, String[] colours) {
            this.socket = socket;
            this.width = width;
            this.height = height;
            this.colours = colours.clone(); // clones one array into another
            this.pins = new ArrayList<Pin>(); // holds all the pins
            this.notes = new ArrayList<Note>(); // holds all notes
        }
        
        public String[] getColours() {
        	return this.colours;
        }
        
        public int getHeight() {
        	return this.height;
        }
        
        public int getWidth() {
        	return this.width;
        }
        
        
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    String input = in.readLine();
                    
                }
            } catch (IOException e) {
            	// put print error statement
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                	// put print error statement
                }
                // put print error statement
            }
        }
    }
}


