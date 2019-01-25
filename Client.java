package board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class Client extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	public boolean isConnected = false;
	public Socket socket;
	public Client() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		ipAddress = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		portNumber = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		connectButton = new javax.swing.JButton();
		connectButton.setAction(action);
		colours = new javax.swing.JComboBox();
		postButton = new javax.swing.JButton();
		postButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		pinXCoordinate = new javax.swing.JTextField();
		pinYCoordinate = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		pinButton = new javax.swing.JButton();
		pinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("pin button pressed");
				if(pinXCoordinate.getText().equals("") || pinYCoordinate.getText().equals("")) {
					output.setText("Please enter an integer in both text fields.");
				}
				else if(!isInteger(pinXCoordinate.getText()) || !isInteger(pinYCoordinate.getText())) {
					output.setText("Please enter an integer in both text fields.");
				}
				else {
					System.out.println("integer");
				}
				
			}
		});
		disconnectButton = new javax.swing.JButton();
		disconnectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					socket.close();
					output.setText("Disconnected successfully");
				} catch (IOException e1) {
					output.setText("Disconnect failed.");
				} catch (NullPointerException e2) {
					output.setText("You are currently not connected.");
				}
			}

		});
		unpinButton = new javax.swing.JButton();
		unpinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		jLabel8 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		contentTextArea = new javax.swing.JTextArea();
		jLabel9 = new javax.swing.JLabel();
		postYCoordinate = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		postXCoordinate = new javax.swing.JTextField();
		height = new javax.swing.JTextField();
		width = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel14 = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		jSeparator3 = new javax.swing.JSeparator();
		jScrollPane1 = new javax.swing.JScrollPane();
		output = new javax.swing.JTextArea();
		jLabel15 = new javax.swing.JLabel();
		getPinsButton = new javax.swing.JButton();
		getPinsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		getColour = new javax.swing.JTextField();
		getContains = new javax.swing.JTextField();
		getRefersTo = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		getInfoButton = new javax.swing.JButton();
		getInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		clearButton = new javax.swing.JButton();
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("IP address:");

		jLabel2.setText("Port Number:");

		connectButton.setText("Connect");
		connectButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					connectButtonAction(evt);
				} catch (NumberFormatException e) {
					output.setText("Connection unsuccessful");
				} catch (UnknownHostException e) {
					output.setText("Connection unsuccessful");
				} catch (IOException e) {
					output.setText("Connection unsuccessful");
				}
			}
		});

		colours.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Colour 1", "Colour 2", "Colour 3", "Colour 4" }));

		postButton.setText("Post");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel3.setText("Connect");

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel4.setText("Post");

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel5.setText("Pin");

		pinYCoordinate.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pinYCoordinateAction(evt);
			}
		});

		jLabel6.setText("X Coordinate:");

		jLabel7.setText("Y Coordinate:");

		pinButton.setText("Pin");
		pinButton.setMaximumSize(new java.awt.Dimension(59, 23));
		pinButton.setMinimumSize(new java.awt.Dimension(59, 23));

		disconnectButton.setText("Disconnect");

		unpinButton.setText("Unpin");

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel8.setText("Get Information");

		contentTextArea.setColumns(20);
		contentTextArea.setRows(5);
		contentTextArea.setPreferredSize(new java.awt.Dimension(164, 60));
		jScrollPane2.setViewportView(contentTextArea);

		jLabel9.setText("Post Content:");

		postYCoordinate.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				postYCoordinateAction(evt);
			}
		});

		jLabel10.setText("X Coordinate:");

		jLabel11.setText("Y Coordinate:");

		jLabel12.setText("Height:");

		jLabel13.setText("Width:");

		jLabel14.setText("Post Color:");

		jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

		output.setEditable(false);
		output.setColumns(20);
		output.setRows(5);
		jScrollPane1.setViewportView(output);

		jLabel15.setText("Output");

		getPinsButton.setText("Get Pins");

		jLabel16.setText("Colour:");

		jLabel17.setText("Contains:");

		jLabel18.setText("Refers To:");

		getInfoButton.setText("Get Info");

		clearButton.setText("Clear");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jSeparator1)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jSeparator3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(getPinsButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(getInfoButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
												.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel18,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel16).addComponent(jLabel17))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(getColour, javax.swing.GroupLayout.DEFAULT_SIZE,
																83, Short.MAX_VALUE)
														.addComponent(getContains).addComponent(getRefersTo))
												.addGap(62, 62, 62)))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(51, 51, 51).addComponent(jLabel9)
										.addGap(72, 72, 72).addComponent(jLabel4))
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel14)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(colours, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(95, 95, 95)
										.addComponent(postButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(153, 153, 153).addComponent(jLabel8)
										.addGap(60, 60, 60).addComponent(jLabel15)))
								.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout
										.createSequentialGroup().addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING).addGroup(
														layout.createSequentialGroup().addGap(58, 58, 58)
																.addComponent(jLabel3))
												.addGroup(layout.createSequentialGroup().addContainerGap()
														.addGroup(layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel1).addComponent(jLabel2))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(portNumber,
																		javax.swing.GroupLayout.DEFAULT_SIZE, 101,
																		Short.MAX_VALUE)
																.addComponent(ipAddress)))
												.addGroup(layout.createSequentialGroup().addGap(2, 2, 2)
														.addComponent(connectButton,
																javax.swing.GroupLayout.PREFERRED_SIZE, 89,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(disconnectButton)))
										.addGap(18, 18, 18)
										.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(
										jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup().addGap(8, 8, 8)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel10).addComponent(jLabel11).addComponent(jLabel12)
										.addComponent(jLabel13))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(postXCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(width, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(height, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(postYCoordinate,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 80,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup().addGap(60, 60, 60)
																.addComponent(jLabel5).addGap(73, 73, 73))
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel6).addComponent(jLabel7))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(pinXCoordinate,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 80,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(pinYCoordinate,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 80,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(layout.createSequentialGroup().addGap(8, 8, 8)
														.addComponent(pinButton, javax.swing.GroupLayout.PREFERRED_SIZE,
																57, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(unpinButton)))
										.addGap(29, 29, 29)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jLabel5))
						.addGap(7, 7, 7)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(ipAddress, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1)
								.addComponent(pinXCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(portNumber, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2)
								.addComponent(pinYCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(connectButton)
								.addComponent(pinButton, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(disconnectButton).addComponent(unpinButton)))
						.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(4, 4, 4)
				.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addGap(12, 12, 12).addComponent(jLabel9).addGap(1, 1, 1))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel4)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(postXCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel10))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(postYCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel11))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel12))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(width, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel13))))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(colours, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel14).addComponent(postButton))
				.addGap(7, 7, 7)
				.addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel8))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(getColour, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel16))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(getContains, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel17))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(getRefersTo, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel18))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(getInfoButton).addComponent(getPinsButton)
										.addComponent(clearButton))))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	private void pinYCoordinateAction(java.awt.event.ActionEvent evt) {
		
	}

	private void connectButtonAction(java.awt.event.ActionEvent evt)
			throws NumberFormatException, UnknownHostException, IOException {
		if (socket == null) {
			String serverAddress = ipAddress.getText();
			String port = portNumber.getText();
			socket = new Socket(serverAddress, Integer.parseInt(port));
			isConnected = socket.isConnected();
			if (isConnected) {
				output.setText("You are connected to the server.");
			}
		} else {
			output.setText("You have already connected to the \nserver.");
		}
	}

	private void postYCoordinateAction(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField5ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Client().setVisible(true);
			}
		});
	}
	
	public boolean isInteger(String num) { 
	    try {
	        Integer.parseInt(num);
	        return true; 
	    }
	    catch(Exception e) { 
	        return false;
	    }
	} 

	private javax.swing.JButton connectButton;
	private javax.swing.JButton pinButton;
	private javax.swing.JButton postButton;
	private javax.swing.JButton disconnectButton;
	private javax.swing.JButton unpinButton;
	private javax.swing.JButton getPinsButton;
	private javax.swing.JButton getInfoButton;
	private javax.swing.JButton clearButton;
	private javax.swing.JComboBox colours;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JTextArea output;
	private javax.swing.JTextArea contentTextArea;
	private javax.swing.JTextField pinXCoordinate;
	private javax.swing.JTextField getContains;
	private javax.swing.JTextField getRefersTo;
	private javax.swing.JTextField ipAddress;
	private javax.swing.JTextField portNumber;
	private javax.swing.JTextField pinYCoordinate;
	private javax.swing.JTextField postYCoordinate;
	private javax.swing.JTextField postXCoordinate;
	private javax.swing.JTextField height;
	private javax.swing.JTextField width;
	private javax.swing.JTextField getColour;
	private final Action action = new SwingAction();

	// End of variables declaration//GEN-END:variables
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
}