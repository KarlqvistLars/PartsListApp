package userInterface.partsLibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import partsLibrary.PartsLibrary;
import partsLibrary.Library;
import partsLibrary.Parts;

public class PartsWinGUI extends JFrame {
	protected JTextArea textArea;
	protected JTextField textField;

	JScrollPane scrollPane = new JScrollPane(textArea);
	// textArea.setEditable(false);
	JScrollPane scrollPane = new JScrollPane(textArea);

	Library<Parts> parts = new PartsLibrary();textArea=new JTextArea(5,20);
	// populateLibrary(parts);

	private static final long serialVersionUID = 1L;

	// GUI containers and components
	private JPanel infoPanel = new JPanel();

	private JLabel itemIdJL = new JLabel("Id");
	private JLabel partNoJL = new JLabel("Part no.");
	private JLabel descriptionJL = new JLabel("Description");
	private JLabel whereToBuyJL = new JLabel("Supplier");
	private JLabel buyDateJL = new JLabel("Date purchased");

	private JTextField itemIdJTF = new JTextField();
	private JTextField partNoJTF = new JTextField();
	private JTextField descriptionJTF = new JTextField();
	private JTextField whereToBuyJTF = new JTextField();
	private JTextField buyDateJTF = new JTextField();

	private JTextField listOfPatsJTF = new JTextField();
	// private JTextField InputJTF = new JTextField();

	private JPanel controlPanel = new JPanel();
	private JPanel partsListPanel = new JPanel();

	private JButton resetJB = new JButton("Reset");
	private JButton showListJB = new JButton("Show");
	private JButton addJB = new JButton("Add");
	private JButton removeJB = new JButton("Remove");
	// private JButton searchJB = new JButton("Search");
	private JButton loadJB = new JButton("Load");
	private JButton exitJB = new JButton("Exit");

	private Font boldFont = new Font(Font.SANS_SERIF, Font.BOLD, 12);

	// model reference
	private Parts theModel;

	public PartsWinGUI(Parts model) {

		populateLibrary(parts);

		theModel = model;

		// define layout for Frame
		this.setLayout(new BorderLayout());

		// set layout for infoPanel
		infoPanel.setLayout(new GridLayout(2, 5));
		infoPanel.setBorder(
				new TitledBorder(new LineBorder(Color.BLACK, 3), "Parts Info"));
		partsListPanel.setLayout(new GridLayout(2, 1));
		// partsListPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,
		// 3),
		// "Parts List"));

		// add labels to panel
		itemIdJL.setHorizontalAlignment(JLabel.CENTER);
		infoPanel.add(itemIdJL);
		partNoJL.setHorizontalAlignment(JLabel.CENTER);
		infoPanel.add(partNoJL);
		descriptionJL.setHorizontalAlignment(JLabel.CENTER);
		infoPanel.add(descriptionJL);
		whereToBuyJL.setHorizontalAlignment(JLabel.CENTER);
		infoPanel.add(whereToBuyJL);
		buyDateJL.setHorizontalAlignment(JLabel.CENTER);
		infoPanel.add(buyDateJL);

		// set text and fancy features to text fields, add to panel
		itemIdJL.setText(String.valueOf(theModel.getItemId()));
		itemIdJL.setHorizontalAlignment(JTextField.RIGHT);
		itemIdJL.setFont(boldFont);
		itemIdJL.setBackground(Color.GREEN);
		itemIdJL.setFocusable(false);
		infoPanel.add(itemIdJTF);

		partNoJTF.setText(String.valueOf(theModel.getPartNo()));
		partNoJTF.setHorizontalAlignment(JTextField.RIGHT);
		partNoJTF.setFont(boldFont);
		partNoJTF.setBackground(Color.GREEN);
		partNoJTF.setFocusable(false);
		infoPanel.add(partNoJTF);

		descriptionJTF.setText(String.valueOf(theModel.getDescription()));
		descriptionJTF.setHorizontalAlignment(JTextField.RIGHT);
		descriptionJTF.setFont(boldFont);
		descriptionJTF.setBackground(Color.GREEN);
		descriptionJTF.setFocusable(false);
		infoPanel.add(descriptionJTF);

		whereToBuyJTF.setText(String.valueOf(theModel.getWhereToBuy()));
		whereToBuyJTF.setHorizontalAlignment(JTextField.RIGHT);
		whereToBuyJTF.setFont(boldFont);
		whereToBuyJTF.setBackground(Color.GREEN);
		whereToBuyJTF.setFocusable(false);
		infoPanel.add(whereToBuyJTF);

		buyDateJTF.setText(String.valueOf(theModel.getBuyDate()));
		buyDateJTF.setHorizontalAlignment(JTextField.RIGHT);
		buyDateJTF.setFont(boldFont);
		buyDateJTF.setBackground(Color.GREEN);
		buyDateJTF.setFocusable(false);
		infoPanel.add(buyDateJTF);

		listOfPatsJTF.setText("1. Rad ett\n2. Rad två\n3. Rad tre");
		parts.showLibraryContents();

		listOfPatsJTF.setBorder(
				new TitledBorder(new LineBorder(Color.BLACK, 3), "Parts List"));

		// add infoPanel List of parts to main panel
		partsListPanel.add(infoPanel);
		partsListPanel.add(listOfPatsJTF);
		this.add(partsListPanel, BorderLayout.EAST);

		// set layout for controlPanel
		controlPanel.setLayout(new GridLayout(6, 1));

		// arm buttons, add them to controlPanel
		resetJB.addActionListener(new AppActionListener());
		controlPanel.add(resetJB);
		showListJB.addActionListener(new AppActionListener());
		controlPanel.add(showListJB);
		addJB.addActionListener(new AppActionListener());
		controlPanel.add(addJB);
		removeJB.addActionListener(new AppActionListener());
		controlPanel.add(removeJB);
		loadJB.addActionListener(new AppActionListener());
		controlPanel.add(loadJB);
		exitJB.addActionListener(new AppActionListener());
		controlPanel.add(exitJB);

		// add controlPanel to main panel
		this.add(controlPanel, BorderLayout.WEST);

		// force user to exit application via button
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	/**
	 * Inner class handling user interactions via buttons
	 *
	 */
	class AppActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {

			JButton trigger = (JButton) ae.getSource();

			switch (trigger.getText()) {

				case "Show" :
					System.out.println("\n PartsLibrary list");
					System.out.println(
							"  _____________________________________________________________________________________________________________________");
					parts.showLibraryContents();
					System.out.println(
							"  =====================================================================================================================");

					break;

				case "Add" :
					// theModel = new JavaDate(SwingDateApp.YEAR,
					// SwingDateApp.MONTH, SwingDateApp.DAY);
					break;

				case "Remove" :
					// theModel = theModel.nextDate();
					break;

				case "Search" :
					// theModel = theModel.nextDate();
					break;

				case "Load" :
					// theModel = theModel.nextDate();
					break;

				case "Exit" :
					System.exit(0);
					break;

			}
			// trigger update of the GUI when model has changed
			updateGUI();
		}
	}

	/**
	 * This method will read model attributes and force a visual update
	 */
	private void updateGUI() {
		itemIdJL.setText(String.valueOf(theModel.getItemId()));
		partNoJTF.setText(String.valueOf(theModel.getPartNo()));
		descriptionJTF.setText(String.valueOf(theModel.getDescription()));
		whereToBuyJTF.setText(String.valueOf(theModel.getWhereToBuy()));
		buyDateJTF.setText(String.valueOf(theModel.getBuyDate()));
	}

	static void populateLibrary(Library<Parts> lib) {

		Parts[] myParts = new Parts[3];

		myParts[0] = new Parts(0, 41015979, "ESP32 Feather", "Electrokit",
				"2020-11-10", 279, 0);
		myParts[1] = new Parts(0, 41015302, "Teensy 3.5", "Electrokit",
				"2020-11-10", 379, 0);
		myParts[2] = new Parts(0, 41015979, "ESP32 Feather", "Electrokit",
				"2021-05-15", 279, 0);

		for (Parts m : myParts) {
			lib.addItem(m);
		}
	}
}
