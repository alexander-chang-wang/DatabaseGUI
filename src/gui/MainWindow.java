/**
 * Main window of the database GUI.
 */
package gui;

import datatypes.Entry;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import tableModels.EntriesTableModel;

public class MainWindow {
	
	/* Members */
	private JFrame mainFrame;
	private JPanel mainPanel, topPanel;
	private JButton undoButton, redoButton, searchButton;
	private JTextField searchField;
	private Stack<Entry> undoStack, redoStack;
	private ImageIcon undoImageIcon, redoImageIcon;
	private Image undoImage, redoImage;
	private GridBagConstraints c;
	private EntriesTableModel entriesTableModel;
	private JTable entriesTable;
	private JScrollPane tableScrollPane;
	
	/* Constructor */
	public MainWindow() {
		
		// initialize the undo and re-do stacks
		undoStack = new Stack<Entry>();
		redoStack = new Stack<Entry>();
		
		// initialize and scale two images for the undo and re-do buttons
		undoImageIcon = new ImageIcon("./resources/undo_button.png");
		redoImageIcon = new ImageIcon("./resources/redo_button.png");
		undoImage = undoImageIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		redoImage = redoImageIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		undoImageIcon = new ImageIcon(undoImage);
		redoImageIcon = new ImageIcon(redoImage);
		
		// initialize the undo button and add an ActionListener
		undoButton = new JButton(undoImageIcon);
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Undo Button Pressed");
			}
		});
		
		// initialize re-do button and add an ActionListener
		redoButton = new JButton(redoImageIcon);
		redoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Redo Button Pressed");
			}
		});
		
		// initialize the searching text field and add an ActionListener
		searchField = new JTextField(20);
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Enter Detected.");
			}
		});
		
		// initialize the search button and add an ActionListener
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Search Detected.");
			}
		});
		
		// TODO: finish this up once the actual tables have been set up
		// initialize and configure the JTable for the membership entries
		entriesTableModel = new EntriesTableModel(new String[20], new String[20][20]);
		entriesTable = new JTable(entriesTableModel);
		entriesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		entriesTable.setFillsViewportHeight(true);
		tableScrollPane = new JScrollPane(entriesTable);
		// MouseListener for the JTable
		entriesTable.addMouseListener(new MouseListener() {
			@Override // TODO: create a window for this
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int rowIndex = entriesTable.getSelectedRow();
					int colIndex = entriesTable.getSelectedColumn();
					
					JOptionPane.showMessageDialog(null, "Row Index: " + rowIndex + " Column Index: " + colIndex);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		
		// initialize the top pane and add components to it
		topPanel = new JPanel(); topPanel.setLayout(new GridBagLayout()); c = new GridBagConstraints();
		// add the undo button to the top panel
		c.gridx = 0; c.gridy = 0; topPanel.add(undoButton, c);
		// add the re-do button to the top panel
		c.gridx = 1; c.gridy = 0; topPanel.add(redoButton, c);
		// add the search text field to the top panel
		c.gridx = 2; c.gridy = 0; topPanel.add(searchField, c);
		// add the search button to the top panel
		c.gridx = 3; c.gridy = 0; topPanel.add(searchButton);
		
		// initialize and configure the main panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(topPanel);
		mainPanel.add(tableScrollPane);
		
		// initialize the main frame
		mainFrame = new JFrame("Database");
		// add the main panel to the main frame
		mainFrame.add(mainPanel);
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
}
