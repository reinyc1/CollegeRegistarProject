import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;

public class mainWindow {

	private JFrame frame;
	private JTextField textField_Name;
	private JTextField textField_ID;
	JComboBox<String> cbLevel = new JComboBox<String>();
	JRadioButton rdbtnU = new JRadioButton("Undergraduate");
	JRadioButton rdbtnG = new JRadioButton("Graduated");
	JTextArea textAreaResults = new JTextArea();
	
	/**
	 * Launch the application.
	 */
	
	Object obj = new Student();
//	Student s3 = new Object();
	Undergraduate[] underG = new Undergraduate[100];
	int iU = 0;
	
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public String showList ()
	{
		String text = new String();
		for (int t = 0; t < iU; t++ )
		{
			text = text + underG[t].writeOutput();
		}
		return "Student ID\tName\tLevel\tType\n" + text;
	}
	
	public boolean duplicateU (int id)
	{
		
		boolean n = true ;
		for (int t = 0; t < iU; t++ )
		{
			if (underG[t].getStudentNumber() == id)
			{
				n = false;
			}
		}
		return n;		
	}
	
	public void addStudent()
	{
		if (textField_Name.getText().matches("^[a-zA-Z ]+$") 
				&& textField_ID.getText().matches("[0-9]+") && textField_ID.getText().length() ==9
				&& cbLevel.isEnabled())
		{
			if (duplicateU(Integer.parseInt(textField_ID.getText())))
			{	
				underG[iU]  = new Undergraduate();
				underG[iU].setName(textField_Name.getText());
				underG[iU].setStudentNumber(Integer.parseInt(textField_ID.getText()));
				underG[iU].setLevel(Integer.parseInt((String) cbLevel.getSelectedItem()));
				
				if (rdbtnU.isSelected()){
					underG[iU].setType("U");					
				    JOptionPane.showMessageDialog(null, "The undergraduate student has been added");
				}
				else if(rdbtnG.isSelected())
				{
					underG[iU].setType("G");
					JOptionPane.showMessageDialog(null, "The graduate student has been added");
				}
				
				iU = iU + 1;
				
				textField_Name.setText("");
				textField_ID.setText("");
				
				
			}else
			{
				JOptionPane.showMessageDialog(null, "Student ID already exits");
			}
		    
		}else
		{
			JOptionPane.showMessageDialog(null, "Please enter valid Values");
		}
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			Exception ItIsBad = new Exception ("kkjj"); 
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewYorkInstitute = new JLabel("New York Institute of Technology Student Registration ");
		lblNewYorkInstitute.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewYorkInstitute.setBounds(0, 13, 581, 26);
		frame.getContentPane().add(lblNewYorkInstitute);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_Name.setBounds(107, 98, 266, 22);
		frame.getContentPane().add(textField_Name);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(12, 101, 56, 16);
		frame.getContentPane().add(lblName);
		
		
		
		rdbtnU.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(rdbtnU);
		
	
		cbLevel.setBounds(62, 213, 34, 22);
		frame.getContentPane().add(cbLevel);
		cbLevel.disable();
		
		
		rdbtnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbLevel.enable();
				cbLevel.removeAllItems();
				cbLevel.addItem("1");
				cbLevel.addItem("2");
				cbLevel.addItem("3");
				cbLevel.addItem("4");	
			}
		});
		

		rdbtnU.setBounds(12, 175, 133, 29);
		frame.getContentPane().add(rdbtnU);
		
		rdbtnG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbLevel.enable();
				cbLevel.removeAllItems();
				cbLevel.addItem("1");
				cbLevel.addItem("2");
				
			}
		});
		buttonGroup.add(rdbtnG);
		rdbtnG.setBounds(143, 175, 101, 29);
		frame.getContentPane().add(rdbtnG);
		
		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addStudent();
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(12, 300, 164, 49);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("Level");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(12, 212, 56, 16);
		frame.getContentPane().add(label);
		
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_ID.setColumns(9);
		textField_ID.setBounds(107, 133, 266, 22);
		textField_ID.setColumns(9);
		frame.getContentPane().add(textField_ID);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentId.setBounds(12, 136, 76, 16);
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblDigitsOnly = new JLabel("(9 digits only)");
		lblDigitsOnly.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDigitsOnly.setBounds(385, 134, 99, 20);
		frame.getContentPane().add(lblDigitsOnly);
		
		JLabel lblDigitsO = new JLabel("Undergraduate Level:\r\n 1 for Freshman, \r\n 2 for Sophomore, \r\n 3 for Junior and \r\n 4 for Senior\r\n");
		lblDigitsO.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblDigitsO.setBounds(14, 247, 546, 20);
		frame.getContentPane().add(lblDigitsO);
		
		JLabel lblGraduateLevels = new JLabel("Graduate Levels:\r\n 1 for First Year and\r\n 2 for Second Year");
		lblGraduateLevels.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblGraduateLevels.setBounds(14, 267, 546, 20);
		frame.getContentPane().add(lblGraduateLevels);
		textAreaResults.setFont(new Font("Monospaced", Font.PLAIN, 16));
		

		textAreaResults.setRows(5);
		textAreaResults.setLineWrap(true);
		textAreaResults.setBounds(12, 373, 558, 232);
		frame.getContentPane().add(textAreaResults);
		
		JButton btnGetStundetsList = new JButton("Get Stundets");
		btnGetStundetsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaResults.setText(showList());
			}
		});
		btnGetStundetsList.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGetStundetsList.setBounds(396, 300, 164, 49);
		frame.getContentPane().add(btnGetStundetsList);
	}
}
