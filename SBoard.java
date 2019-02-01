package board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SBoard {	
	
	public static int width;
	public static int height;
	public static String[] colours;
	public static Board board;
	
	// args starts reading from index 0 meaning the port number is the first argument
    public static void main(String[] args) throws Exception {
    	
    	// assign port number
    	int portNumber = Integer.parseInt(args[0]);
    	//assign dimensions
    	width = Integer.parseInt(args[1]);
    	height = Integer.parseInt(args[2]);
    	int colourLen = args.length - 3;
    	colours = new String[colourLen]; 
    	// create colour array
    	for(int i = 0; i < colourLen; i++) {
    		colours[i] = args[i + 3];
    	}
        System.out.println("The board server is running.");
        ServerSocket listener = new ServerSocket(portNumber);

        board = new Board(width, height, colours);
        
        try {
            while (true) {
                new Boards(listener.accept()).run();
            }
        } finally {
            listener.close();
        }
    }
    
    public static class Pin{
		public int x;
		public int y;
		
		public Pin(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
    
    public class Note{
    	public String content;
    	public boolean isPinned;
    	public String colour;
    	public ArrayList<Pin> points;
    	public Pin point;
    	public int width;
    	public int height;
    	
    	public void note(String content, String colour, int x, int y, int width, int height) {
    		this.content = content;
    		this.isPinned = false;
    		this.colour = colour;
    		this.point = new Pin(x,y);
    		this.width = width;
    		this.height = height;
    	}
    	
    	public void setPinned(Note n) {
    		n.isPinned = true;
    	}
    }
    
    public static class Board{
        private int width;
        private int height;
        private String[] colours;
        public ArrayList<Pin> pins = new ArrayList<Pin>();
        public ArrayList<Note> notes = new ArrayList<Note>();

        public Board(int width, int height, String[] colours) {
        	this.width = width;
        	this.height = height;
        	this.colours = colours.clone();
        }
    }
    
   private static class Boards implements Runnable {
    //private static class Boards extends Thread {
        private Socket socket;
        
        public Boards(Socket socket) {
            this.socket = socket;
        }    
        
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                
                while (true) {
                	// THE CODE BELOW CURRENTLY DOES NOT SEND BACK TO CLIENT
                    String input = in.readLine();
                    System.out.println(input);
                    String[] parsed = input.split(" ");
                    
                    // I think this is all of the button functionality
                    // double check if it is and delete this comment once you have
                    // add stuff to the board by: board.[method]
                    if(parsed[0].equals("pin")) {
                    	int x = Integer.parseInt(parsed[1]);
                    	int y = Integer.parseInt(parsed[2]);
                    	Pin p = new Pin(x, y);
                    	board.pins.add(p);
                    	updateNotes(board.pins, board.notes);
                    	System.out.println("X: " + x + " Y: " + y);
                    	
                    }
                    else if(parsed[0].equals("unpin")) {
                    	int x = Integer.parseInt(parsed[1]);
                    	int y = Integer.parseInt(parsed[2]);
                    	int result = removePin(board.pins, x, y);
                    	System.out.println("pin removed (1 = success, 0 = fail/no pin): " + result);
                    }
                    else if(parsed[0].equals("post")) {
                    	
                    }
                    else if(parsed[0].equals("getPins")) {
                    	
                    }
                    else if(parsed[0].equals("get")) {
                    	
                    }
                    else if(parsed[0].equals("clear")) {
                    	// use this for debugging
                    	for(int i = 0; i < board.pins.size(); i++) {
                    		System.out.println("x: "+ board.pins.get(i).x + " y: " + board.pins.get(i).y);
                    	}
                    }
                    
                    
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
        
        
        // returns 1 if it is removed
        // else 0
        private int removePin(ArrayList<Pin> pins, int x, int y) {
        	int size = pins.size();
        	for(int i = 0; i < size; i++) {
        		if(pins.get(i).x == x) {
        			if(pins.get(i).y == y) {
        				pins.remove(i);
        				return 1;
        			}
        		}
        	}
        	return 0;
        }
        
        private void updateNotes(ArrayList<Pin> pins, ArrayList<Note> notes) {
        	int pinSize = pins.size();
        	int noteSize = notes.size();
        	for(int i = 0; i < pinSize; i++) {
        		for(int j = 0; j < noteSize; j++) {
        			//do the math stuff here
        		}
        	}
        }
        
        
    }
}


