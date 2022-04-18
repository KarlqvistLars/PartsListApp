package userInterface.partsLibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import partsLibrary.Library;
import partsLibrary.Parts;
import partsLibrary.PartsLibrary;

public class PartsWinGUI extends JFrame {
	protected JTextArea textArea;
	protected JTextField textField;
	private static final long serialVersionUID = 1L;
	private static boolean showRemove = false;

	// GUI containers and components
	private JPanel infoPanel = new JPanel();

	private JLabel itemIdJL = new JLabel("Id");
	private JLabel partNoJL = new JLabel("Part no.");
	private JLabel descriptionJL = new JLabel("Description");
	private JLabel whereToBuyJL = new JLabel("Supplier");
	private JLabel buyDateJL = new JLabel("Date purchased");
	private JLabel priceJL = new JLabel("Price");

	// private JTextField itemIdJTF = new JTextField();
	private JTextField partNoJTF = new JTextField();
	private JTextField descriptionJTF = new JTextField();
	private JTextField whereToBuyJTF = new JTextField();
	private JTextField buyDateJTF = new JTextField();
	private JTextField priceJTF = new JTextField();

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

	private Font boldFont = new Font(Font.SANS_SERIF, Font.BOLD, 14);
	private Font consoleFont = new Font(Font.MONOSPACED, Font.BOLD, 16);

	// model reference
	private Parts theModel;

	Library<Parts> parts = new PartsLibrary();

	public PartsWinGUI(Parts model) {

		textArea = new JTextArea(10, 124);
		JScrollPane scrollPane = new JScrollPane(textArea);

		// textArea.setEditable(false);
		// populateLibrary(parts);

		populateLibrary(parts);

		theModel = model;

		// define layout for Frame
		this.setLayout(new BorderLayout());

		// set layout for infoPanel
		infoPanel.setLayout(new GridLayout(2, 5));
		infoPanel.setBorder(
				new TitledBorder(new LineBorder(Color.BLACK, 3), "Parts Info"));

		// add labels to panel
		// partNoJL.setHorizontalAlignment(JLabel.CENTER);
		// descriptionJL.setHorizontalAlignment(JLabel.CENTER);
		// whereToBuyJL.setHorizontalAlignment(JLabel.CENTER);
		// buyDateJL.setHorizontalAlignment(JLabel.CENTER);

		infoPanel.add(partNoJL);
		infoPanel.add(descriptionJL);
		infoPanel.add(whereToBuyJL);
		infoPanel.add(buyDateJL);
		infoPanel.add(priceJL);

		// set text and fancy features to text fields, add to panel
		// itemIdJL.setText(String.valueOf(theModel.getItemId()));
		// itemIdJL.setHorizontalAlignment(JTextField.RIGHT);
		// itemIdJL.setFont(boldFont);
		// itemIdJL.setBackground(Color.ORANGE);
		// itemIdJL.setFocusable(false);
		// infoPanel.add(itemIdJTF);

		partNoJTF.setText(String.valueOf(theModel.getPartNo()));
		partNoJTF.setHorizontalAlignment(JTextField.RIGHT);
		partNoJTF.setFont(boldFont);
		partNoJTF.setBackground(Color.ORANGE);
		partNoJTF.setFocusable(true);
		infoPanel.add(partNoJTF);

		descriptionJTF.setText(String.valueOf(theModel.getName()));
		descriptionJTF.setHorizontalAlignment(JTextField.RIGHT);
		descriptionJTF.setFont(boldFont);
		descriptionJTF.setBackground(Color.ORANGE);
		descriptionJTF.setFocusable(true);
		infoPanel.add(descriptionJTF);

		whereToBuyJTF.setText(String.valueOf(theModel.getWhereToBuy()));
		whereToBuyJTF.setHorizontalAlignment(JTextField.RIGHT);
		whereToBuyJTF.setFont(boldFont);
		whereToBuyJTF.setBackground(Color.ORANGE);
		whereToBuyJTF.setFocusable(true);
		infoPanel.add(whereToBuyJTF);

		buyDateJTF.setText(String.valueOf(theModel.getBuyDate()));
		buyDateJTF.setHorizontalAlignment(JTextField.RIGHT);
		buyDateJTF.setFont(boldFont);
		buyDateJTF.setBackground(Color.ORANGE);
		buyDateJTF.setFocusable(true);
		infoPanel.add(buyDateJTF);

		priceJTF.setText(String.valueOf(theModel.getPrice()));
		priceJTF.setHorizontalAlignment(JTextField.RIGHT);
		priceJTF.setFont(boldFont);
		priceJTF.setBackground(Color.ORANGE);
		priceJTF.setFocusable(true);
		infoPanel.add(priceJTF);

		listOfPatsJTF.setBorder(
				new TitledBorder(new LineBorder(Color.BLACK, 3), "Parts List"));
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.GREEN);
		textArea.setFont(consoleFont);
		textArea.append("1. Rad ett\n2. Rad två\n3. Rad tre");

		scrollPane.setBorder(
				new TitledBorder(new LineBorder(Color.BLACK, 3), "Parts List"));

		partsListPanel.setLayout(new GridBagLayout());
		// Add Components to this panel.
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;

		c.fill = GridBagConstraints.HORIZONTAL;
		// add infoPanel List of parts to main panel
		partsListPanel.add(infoPanel, c);
		partsListPanel.add(listOfPatsJTF, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		partsListPanel.add(scrollPane, c);

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

		List<Parts> partsList;
		@Override
		public void actionPerformed(ActionEvent ae) {

			JButton trigger = (JButton) ae.getSource();

			switch (trigger.getText()) {

				case "Show" :
					textArea.append("\n PartsLibrary list\n");
					textArea.append(makeLine("_") + "\n");
					textArea.append(parts.showLibraryOnGUIConsole());
					textArea.append(makeLine("=") + "\n");
					listOfPatsJTF.setText("");
					break;

				case "Add" :
					if (Integer.parseInt(partNoJTF.getText()) != 0) {
						int itemId = parts.getMaxItemID() + 1;
						String partNum = partNoJTF.getText();
						int partNo = Integer.parseInt(partNum);
						String name = descriptionJTF.getText();
						String whereToBuy = whereToBuyJTF.getText();
						String buyDate = buyDateJTF.getText();
						String value = priceJTF.getText();
						float price = Float.parseFloat(value);
						int stored = 0;
						Parts temp = new Parts(itemId, partNo, name, whereToBuy,
								buyDate, price, stored);
						parts.addItem(temp);
					} else {
						listOfPatsJTF.setText(" Part number cannot be NULL");
					}
					break;

				case "Remove" :
					if (showRemove == false) {
						textArea.append("\n PartsLibrary list\n");
						textArea.append(makeLine("_") + "\n");
						textArea.append(parts.showRowToRemoveOnGUI());
						textArea.append(makeLine("=") + "\n");
						showRemove = true;
					} else {
						int index = 0;
						if (listOfPatsJTF.getText() != "") {
							try {
								index = Integer
										.parseInt(listOfPatsJTF.getText());
							} catch (NumberFormatException e) {
								textArea.append("Not a valid input");
								index = 0;
								listOfPatsJTF.setText("");
							}
						}
						Parts tempParts = parts.getItem(index);
						if (tempParts != null) {
							parts.removeItem(tempParts);
							showRemove = false;
							listOfPatsJTF.setText(" Item removed from list");
						} else {
							listOfPatsJTF.setText(" itemId number not found");
						}
					}
					listOfPatsJTF.setText("");
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
		descriptionJTF.setText(String.valueOf(theModel.getName()));
		whereToBuyJTF.setText(String.valueOf(theModel.getWhereToBuy()));
		buyDateJTF.setText(String.valueOf(theModel.getBuyDate()));
		priceJTF.setText(String.valueOf(theModel.getPrice()));
	}

	static String makeLine(String sign) {
		StringBuilder returnText = new StringBuilder();
		for (int n = 0; n < 120; n++) {
			returnText.append(sign);
		}
		return returnText.toString();
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
