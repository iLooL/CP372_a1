package cp372_a1;

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

	// args starts reading from index 0 meaning the port number is the first
	// argument
	public static void main(String[] args) throws Exception {

		// assign port number
		int portNumber = Integer.parseInt(args[0]);
		// assign dimensions
		width = Integer.parseInt(args[1]);
		height = Integer.parseInt(args[2]);
		int colourLen = args.length - 3;
		colours = new String[colourLen];
		// create colour array
		for (int i = 0; i < colourLen; i++) {
			colours[i] = args[i + 3];
		}
		System.out.println("The board server is running.");
		ServerSocket listener = new ServerSocket(portNumber);

		board = new Board(width, height, colours);

		try {
			while (true) {
				new Boards(listener.accept()).start();
			}
		} finally {
			listener.close();
		}
	}

	public static class Pin {
		public int x;
		public int y;

		public Pin(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Note {
		public String content;
		public boolean isPinned;
		public String colour;
		public ArrayList<Pin> points = new ArrayList<Pin>();
		public Pin point;
		public int width;
		public int height;

		public Note(String content, String colour, int x, int y, int width, int height) {
			this.content = content;
			this.isPinned = false;
			this.colour = colour;
			this.point = new Pin(x, y);
			this.width = width;
			this.height = height;
		}

		public void setPinned(Note n) {
			n.isPinned = true;
		}
	}

	public static class Board {
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

	private static class Boards extends Thread {
		private Socket socket;

		public Boards(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

				while (true) {
					// THE CODE BELOW CURRENTLY DOES NOT SEND BACK TO CLIENT
					String input = in.readLine();
					System.out.println(input);
					String[] parsed = input.split("@@");

					// I think this is all of the button functionality
					// double check if it is and delete this comment once you have
					// add stuff to the board by: board.[method]
					if (parsed[0].equals("pin")) {
						int x = Integer.parseInt(parsed[1]);
						int y = Integer.parseInt(parsed[2]);
						Pin p = new Pin(x, y);
						boolean on = isPinOnBoard(p);
						if (on) {
							board.pins.add(p);
							updateNotes(p, board.notes);
							out.println("Pin " + x + " " + y + " successful.");
						} else {
							// send client error message that requested pin is off the board bounds
							out.println("Pin out of board bounds.");
						}
					} else if (parsed[0].equals("unpin")) {
						int x = Integer.parseInt(parsed[1]);
						int y = Integer.parseInt(parsed[2]);
						Pin p = new Pin(x, y);
						int result = removePin(p, board.pins);
						if (result == 1) {
							updateUnpin(p, board.notes);
							out.println("Removal of pin " + x + " " + y + " is successful.");
						} else {
							out.println(
									"Removal of pin " + x + " " + y + " is unsuccessful,\n please enter valid input.");
						}
					} else if (parsed[0].equals("post")) {
						if (parsed[6].equals("default")) {
							parsed[6] = colours[0];
						}
						if (checkColour(parsed[6]) == false) {
							out.println("Please enter a valid colour.");
						} else if (Integer.parseInt(parsed[1]) < 0 || Integer.parseInt(parsed[2]) < 0
								|| Integer.parseInt(parsed[1]) + Integer.parseInt(parsed[4]) > board.width
								|| Integer.parseInt(parsed[2]) + Integer.parseInt(parsed[3]) > board.height) {
							out.println("Please stay within board boundaries.");
						} else {
							createPost(parsed);
							out.println("Note created successfully");
						}

					} else if (parsed[0].equals("getPins")) {
						// use this for debugging
						for (int i = 0; i < board.pins.size(); i++) {
							System.out.println("x: " + board.pins.get(i).x + " y: " + board.pins.get(i).y);
						}
					} else if (parsed[0].equals("get")) {

					} else if (parsed[0].equals("clear")) {
						out.println(clear(board.notes));
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

		private String clear(ArrayList<Note> notes) {
			String removed = "";
			if (notes.size() == 0) {
				removed = "0";
			} else {
				int size = notes.size();
				for (int i = size - 1; i >= 0; i--) {
					if (notes.get(i).isPinned == false) {
						removed = removed + notes.get(i).content + "@@";
						board.notes.remove(i);
					}
				}
			}
			return removed;
		}

		private boolean checkColour(String colour) {
			boolean result = false;
			for (int i = 0; i < colours.length; i++) {
				if (colour.toLowerCase().equals(colours[i].toLowerCase())) {
					result = true;
				}
			}
			return result;
		}

		// returns 1 if it is removed
		// else 0
		private int removePin(Pin p, ArrayList<Pin> pins) {
			int size = pins.size();
			for (int i = 0; i < size; i++) {
				if (pins.get(i).x == p.x) {
					if (pins.get(i).y == p.y) {
						pins.remove(i);
						return 1;
					}
				}
			}
			return 0;
		}

		// updates the notes pin status
		private void updateUnpin(Pin p, ArrayList<Note> notes) {
			for (int i = 0; i < notes.size(); i++) {

			}
		}

		// updates notes when a new pin has been added to the board
		private void updateNotes(Pin pin, ArrayList<Note> notes) {
			int noteSize = notes.size();
			for (int i = 0; i < noteSize; i++) {
				if (notes.get(i).point.x >= pin.x && notes.get(i).point.x + width <= pin.x
						&& notes.get(i).point.y >= pin.y && notes.get(i).point.y + height <= pin.y) {
					notes.get(i).isPinned = true;
					notes.get(i).points.add(pin);
				}
			}
		}

		// tells us whether the pin is on the board
		// we must know this before adding the pin to the board object
		private boolean isPinOnBoard(Pin pin) {
			boolean on;
			if (pin.x > width || pin.y > height) {
				on = false;
			} else {
				on = true;
			}
			return on;
		}

		private void createPost(String[] values) {
			Note newNote = new Note(values[5], values[6], Integer.parseInt(values[1]), Integer.parseInt(values[2]),
					Integer.parseInt(values[4]), Integer.parseInt(values[3]));
			board.notes.add(newNote);
		}

	}
}