package view;
/**Final Project
 * @author Paul Cady
 * @version 4.31
 * @since 4.31
*/
/*  
* OS: Windows 10
* IDE: eclipse
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.Containers;
import classes.ShippingPriorities;

public class ContainersPanel extends JPanel{
	//Creating data structures
	private LinkedList<Containers> storageList = new LinkedList<Containers>();
	private PriorityQueue<Containers> storagePriority = new PriorityQueue<Containers>(1000, new ShippingPriorities());
	
	//Creating the GUI menu
	private JLabel LinkedText = new JLabel("");
	private JLabel PriorityText = new JLabel("");

	private JLabel title = new JLabel("Containers for shipping yard");
	
	private JLabel sizeText = new JLabel("What is the size of the container?");
	private JRadioButton sizeFirst = new JRadioButton("small"); // Radio button set
	private JRadioButton sizeSecond = new JRadioButton("medium");
	private JRadioButton sizeThird = new JRadioButton("large");
	ButtonGroup priorityOptions = new ButtonGroup();

	private JLabel perishableText = new JLabel("Is the material stored perishable?");
	private JRadioButton yes = new JRadioButton("Yes"); // Radio button set
	private JRadioButton no = new JRadioButton("No");
	ButtonGroup isPerishable = new ButtonGroup();
	
	private JLabel weightClassText = new JLabel("Pounds or Kilos");
	private JRadioButton weightFirst = new JRadioButton("pounds"); // Radio button set
	private JRadioButton weightSecond = new JRadioButton("kilos");
	ButtonGroup weightClasses = new ButtonGroup();
	
	
	private JLabel ownerText = new JLabel("Container Owner");
	private JTextField ownerField = new JTextField(15);
	
	private JLabel deliverText = new JLabel("Where to deliver ");
	private JTextField deliverField = new JTextField(15);
	
	private JLabel materialText = new JLabel("Material Contained ");
	private JTextField materialField = new JTextField(10);
	
	private JLabel weightText = new JLabel("How much is the material weight?");
	private JTextField weightField = new JTextField(10);
	
	private JButton addButtton = new JButton("Add");
	private JButton removeButtton = new JButton("Remove");
	private JButton ClearButton = new JButton("Clear");
	
	private JLabel firstOut = new JLabel();
	private JLabel secondOut = new JLabel();
	private JLabel thirdOut = new JLabel();
	
	public ContainersPanel (){
		super();
		
		//Setting the GUI
		add(title);
		
		priorityOptions.add(sizeFirst);
		priorityOptions.add(sizeSecond);
		priorityOptions.add(sizeThird);
		
		add(sizeText);
		add(sizeFirst);
		add(sizeSecond);
		add(sizeThird);
		
		add(ownerText);
		add(ownerField);
		
		add(deliverText);
		add(deliverField);
		
		add(materialText);
		add(materialField);
		
		add(weightText);
		add(weightField);
		
		add(perishableText);
		isPerishable.add(yes);
		isPerishable.add(no);
		
		add(yes);
		add(no);
		
		add(weightClassText);
		weightClasses.add(weightFirst);
		weightClasses.add(weightSecond);
		
		add(weightFirst);
		add(weightSecond);
		
		//Button to add container
		AddButtonListener addbuttonListener = new AddButtonListener();
		addButtton.addActionListener(addbuttonListener);
		
		//Button to remove container
		RemoveButtonListener remove_buttonListener = new RemoveButtonListener();
		removeButtton.addActionListener(remove_buttonListener);
		
		//Button to clear all text
		ClearButtonListener clearListener = new ClearButtonListener();
		ClearButton.addActionListener(clearListener);
		
		add(addButtton);
		add(removeButtton);
		add(ClearButton);
		
		add(firstOut);
		add(secondOut);
		add(thirdOut);
		
		
		add(LinkedText);
		add(PriorityText);
		
	}
	class AddButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try { //Getting all of the textFields transfered into strings and ints then sent into the class
		int weightInput = Integer.parseInt(weightField.getText());
		String sizes = "";
		String weightClassChoice = "";
		String perishableChoice = "";
		String deliver = deliverField.getText();
		String owner = ownerField.getText();
		String materials = materialField.getText();
		
		//Checking size, perishable, and weightClass then setting choice.
		if(sizeFirst.isSelected()) {
			sizes = "small";
		}else if(sizeSecond.isSelected()) {
			sizes = "medium";
		}else if(sizeThird.isSelected()) {
			sizes = "large";
		}
		
		if(yes.isSelected()) {
			perishableChoice = "yes";
		}else if(no.isSelected()) {
			perishableChoice = "no";
		}
		
		if(weightFirst.isSelected()) {
			weightClassChoice = "pounds";
		}else if(weightSecond.isSelected()) {
			weightClassChoice = "Kilos";
		}
		//Creating input container
		Containers input = new Containers(owner,deliver,materials,weightClassChoice,perishableChoice,sizes , weightInput);
		
		int total = input.totalWeight(weightInput, sizes, weightClassChoice);
		String check = input.WeightLimit(weightInput, sizes, weightClassChoice);
		String printing = input.Formating();
		
		//Seeing if check is over weight limit
		if(check == "Over the weight limit") {
			firstOut.setText("");
			secondOut.setText(check + ", input not accepted.");
			thirdOut.setText("");
		}else {
		//Adding container to storage
		storagePriority.add(input);
		storageList.add(input);
		sorting(storageList);
		String curList = Integer.toString(storageList.size());
		String curPri = Integer.toString(storagePriority.size());
		
		//Showing total containers and printing
		LinkedText.setText("Total containers: " + curList);
		//PriorityText.setText("Total containers: " + curPri);
		firstOut.setText("Total weight: " + total);
		secondOut.setText(check);
		thirdOut.setText(printing);
		}
		//If format isn't correct, clear text fields and print phrase
		}catch(NumberFormatException ex) {
			secondOut.setText("inputs are not the correct format.");
			ownerField.setText("");
			deliverField.setText("");
			materialField.setText("");
			firstOut.setText("");
			secondOut.setText("");
			thirdOut.setText("");
			LinkedText.setText("");
			PriorityText.setText("");
		}
	}
	}
	class RemoveButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try { //Getting all of the textFields transfered into strings and ints then sent into the class
		int weightInput = Integer.parseInt(weightField.getText());
		String sizes = "";
		String weightClassChoice = "";
		String perishableChoice = "";
		String deliver = deliverField.getText();
		String owner = ownerField.getText();
		String materials = materialField.getText();
		
		//Checking size, perishable, and weightClass then setting choice.
		if(sizeFirst.isSelected()) {
			sizes = "small";
		}else if(sizeSecond.isSelected()) {
			sizes = "medium";
		}else if(sizeThird.isSelected()) {
			sizes = "large";
		}
		
		if(yes.isSelected()) {
			perishableChoice = "yes";
		}else if(no.isSelected()) {
			perishableChoice = "no";
		}
		
		if(weightFirst.isSelected()) {
			weightClassChoice = "pounds";
		}else if(weightSecond.isSelected()) {
			weightClassChoice = "Kilos";
		}
		
		//Creating removeInput container
		Containers removeInput = new Containers(owner,deliver,materials,weightClassChoice,perishableChoice,sizes , weightInput);
		//Searching storageList and removing correct container from that and Priority
		for(int x = 0; x < storageList.size(); x++) {
			Containers val = storageList.get(x);
			if(val.owner.equals(removeInput.owner) && val.Location.equals(removeInput.Location) && val.Material.equals(removeInput.Material) && val.weightClass.equals(removeInput.weightClass) &&
				val.perishable.equals(removeInput.perishable) && val.size.equals(removeInput.size) && val.weight == removeInput.weight) {
				storageList.remove(val);
				storagePriority.remove(val);
				sorting(storageList);
				LinkedText.setText("Container size " + storageList.size());
				//PriorityText.setText("Container size " + storagePriority.size());
				firstOut.setText("Removed");
				secondOut.setText("");
				thirdOut.setText("");
			}
			else if(x == storageList.size() - 1) {
				firstOut.setText("Container doesn't exist.");
				secondOut.setText("");
				thirdOut.setText("");
			}
		}
		//If format isn't correct, clear text fields and print phrase
		}catch(NumberFormatException ex) {
			secondOut.setText("inputs are not the correct format.");
			ownerField.setText("");
			deliverField.setText("");
			materialField.setText("");
			firstOut.setText("");
			secondOut.setText("");
			thirdOut.setText("");
			LinkedText.setText("");
			PriorityText.setText("");
		}
	}
	}
	class ClearButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			resetFields();
			
		}
	}
	//Setting all fields to blank
	public void resetFields() {
		ownerField.setText("");
		deliverField.setText("");
		materialField.setText("");
		weightField.setText("");
		firstOut.setText("");
		secondOut.setText("");
		thirdOut.setText("");
		LinkedText.setText("");
		PriorityText.setText("");
	}
	//Insertion sorting LinkedList
	public void sorting(LinkedList<Containers> storageList) {
		if(storageList == null || storageList.size() <= 1) {
			return;
		}
		for(int x = 1; x < storageList.size(); x++) {
			Containers val = storageList.get(x);
			int j = x - 1;
			
			while(j >= 0 && storageList.get(j).compareTo(val) > 0) {
				storageList.set(j + 1, storageList.get(j));
				j--;
			}
			
			storageList.set(j + 1, val);
		}
	}
}
