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
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 28, 378, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInputMcfunction = new JLabel("Input MCFunction");
		lblInputMcfunction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputMcfunction.setBounds(10, 11, 414, 14);
		contentPane.add(lblInputMcfunction);
		
		JLabel lblInputObjectives = new JLabel("Input Objectives (leave blank to disable objective renaming)");
		lblInputObjectives.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputObjectives.setBounds(10, 55, 414, 14);
		contentPane.add(lblInputObjectives);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 72, 378, 20);
		contentPane.add(textField_1);
		
		JLabel lblNamespace = new JLabel("Namespace");
		lblNamespace.setHorizontalAlignment(SwingConstants.CENTER);
		lblNamespace.setBounds(10, 103, 414, 14);
		contentPane.add(lblNamespace);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 120, 414, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 166, 378, 20);
		contentPane.add(textField_3);
		
		lblOutputFolder = new JLabel("Output folder");
		lblOutputFolder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputFolder.setBounds(10, 149, 414, 14);
		contentPane.add(lblOutputFolder);
		
		JButton btnNewButton = new JButton("OBFUSCATE");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MCFObfuscator.IN = textField.getText();
				MCFObfuscator.OBJECTIVES = textField_1.getText();
				MCFObfuscator.OUT = textField_3.getText() + "\\";
				MCFObfuscator.PREFIX = textField_2.getText();
				
				
				
				MCFObfuscator.start();
				
			}
		});
		btnNewButton.setBounds(10, 208, 414, 42);
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
		btnNewButton_1.setBounds(395, 28, 29, 20);
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
		button.setBounds(395, 71, 29, 20);
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
		button_1.setBounds(395, 165, 29, 20);
		contentPane.add(button_1);
		setTitle("MCFObfuscator");
	}
}
