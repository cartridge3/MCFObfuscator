package me.cartridge3.MCFObfuscator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JSlider;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class GUIMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblOutputFolder;
	private JButton button;
	private JButton button_1;
	private static JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain frame = new GUIMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIMain() {
		setBackground(new Color(0, 128, 128));
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 515);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 153, 153));
		textField.setBounds(10, 132, 266, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInputMcfunction = new JLabel("Input MCFunction");
		lblInputMcfunction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputMcfunction.setBounds(10, 111, 266, 14);
		contentPane.add(lblInputMcfunction);
		
		JLabel lblInputObjectives = new JLabel("Strings to replace");
		lblInputObjectives.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputObjectives.setBounds(429, 161, 265, 14);
		contentPane.add(lblInputObjectives);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(new Color(0, 153, 153));
		textField_1.setColumns(10);
		textField_1.setBounds(429, 132, 265, 20);
		contentPane.add(textField_1);
		
		JLabel lblNamespace = new JLabel("Namespace");
		lblNamespace.setHorizontalAlignment(SwingConstants.CENTER);
		lblNamespace.setBounds(429, 111, 265, 14);
		contentPane.add(lblNamespace);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(new Color(0, 153, 153));
		textField_2.setColumns(10);
		textField_2.setBounds(428, 182, 266, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setBackground(new Color(0, 153, 153));
		textField_3.setColumns(10);
		textField_3.setBounds(10, 182, 266, 20);
		contentPane.add(textField_3);
		
		lblOutputFolder = new JLabel("Output folder");
		lblOutputFolder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputFolder.setBounds(10, 163, 266, 14);
		contentPane.add(lblOutputFolder);
		
		JButton btnNewButton = new JButton("OBFUSCATE");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MCFObfuscator.IN = textField.getText();
				MCFObfuscator.OBJECTIVES = textField_2.getText();
				MCFObfuscator.OUT = textField_3.getText() + "\\";
				MCFObfuscator.PREFIX = textField_1.getText();
				
				
				
				MCFObfuscator.start();
				
			}
		});
		btnNewButton.setBounds(174, 440, 351, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser filec = new JFileChooser();
				 filec.setCurrentDirectory(new File(MCFObfuscator.PATH));
				 filec.setDialogTitle("Choose .mcfunction file");
				 FileFilter filter = new FileNameExtensionFilter("mcfunction", 
				            "mcfunction"); 
				 filec.setFileFilter(filter);
				  filec.setCurrentDirectory(new File(textField.getText()));
				 
				 int val = filec.showOpenDialog(null);
					// int returnValue = jfc.showSaveDialog(null);

					if (val == JFileChooser.APPROVE_OPTION) {
						 textField.setText(filec.getSelectedFile().getAbsolutePath());
						
					}
				 
				
				
			}
		});
		btnNewButton_1.setBounds(286, 132, 29, 20);
		contentPane.add(btnNewButton_1);
		
		button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser filec = new JFileChooser();
				 filec.setCurrentDirectory(new File(MCFObfuscator.PATH));
				 filec.setDialogTitle("Choose objectives file");
				  filec.setCurrentDirectory(new File(textField_1.getText()));
			
				 
				 
				 int val = filec.showOpenDialog(null);
					// int returnValue = jfc.showSaveDialog(null);

					if (val == JFileChooser.APPROVE_OPTION) {
						 textField_1.setText(filec.getSelectedFile().getAbsolutePath());
						
					}
				 
				
				
			}
		});
		button.setBounds(389, 182, 29, 20);
		contentPane.add(button);
		
		button_1 = new JButton("...");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser filec = new JFileChooser();
				 filec.setCurrentDirectory(new File(MCFObfuscator.PATH));
				 filec.setDialogTitle("Choose output folder");
				 filec.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			     filec.setCurrentDirectory(new File(textField_3.getText()));
				 
				 
				 int val = filec.showOpenDialog(null);
					// int returnValue = jfc.showSaveDialog(null);

					if (val == JFileChooser.APPROVE_OPTION) {
						 textField_3.setText(filec.getSelectedFile().getAbsolutePath());
						
					}
				 
				
				
			}
		});
		button_1.setBounds(286, 182, 29, 20);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("MCFObfuscator");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 49));
		lblNewLabel.setBounds(0, -8, 704, 87);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(702, 73, -691, 35);
		contentPane.add(separator);
		
		JLabel lblCodedByCartridge = new JLabel("Coded by cartridge3");
		lblCodedByCartridge.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodedByCartridge.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblCodedByCartridge.setBounds(10, 63, 684, 26);
		contentPane.add(lblCodedByCartridge);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 98, 684, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 233, 684, 2);
		contentPane.add(separator_2);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(GUIMain.class.getResource("/me/cartridge3/MCFObfuscator/rsz_34579329.png")));
		btnNewButton_2.setBounds(321, 135, 64, 64);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 246, 631, 176);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setForeground(new Color(255, 255, 255));
		
		
		textArea.setBackground(new Color(47, 79, 79));
		
	
		setTitle("MCFObfuscator");
	}
	
	public static void addToLog(Object o) {
		textArea.setText(textArea.getText() + "\n" + o);
	}
	
	
}
