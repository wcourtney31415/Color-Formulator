package com.wesleycourtney.Color_Formulator;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Color Formulator");
		frame.setBounds(100, 100, 476, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Pattern");
		lblNewLabel.setBounds(12, 12, 60, 17);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(245, 12, 60, 17);
		frame.getContentPane().add(lblResult);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "RGB", "HSL", "RGBA", "HSLA", "Hex" }));
		comboBox.setBounds(36, 149, 114, 26);
		frame.getContentPane().add(comboBox);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 34, 221, 103);
		frame.getContentPane().add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(245, 34, 221, 103);
		frame.getContentPane().add(textArea_1);

		JButton btnCopy = new JButton("Copy");
		btnCopy.setBounds(402, 12, 64, 17);
		frame.getContentPane().add(btnCopy);
		
		JButton colorBlock = new JButton();
		colorBlock.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		colorBlock.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		colorBlock.setBounds(12, 179, 162, 151);
		ArrayList<Color> list = new ArrayList<Color>();

		colorBlock.addActionListener(e -> {
			Color color = JColorChooser.showDialog(frame, "Select a color", null);
			list.clear();
			list.add(color);
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			colorBlock.setBackground(color);
			String toBeInterpolated = textArea.getText();
			String str = String.format(toBeInterpolated, red, green, blue);
			textArea_1.setText(str);
		});
		
		JLabel lblClickBoxTo = new JLabel("Click Box to Select Color");
		lblClickBoxTo.setBounds(12, 187, 162, 17);
		frame.getContentPane().add(lblClickBoxTo);
		lblClickBoxTo.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(colorBlock);
		
		JList list_1 = new JList();
		list_1.setBounds(245, 179, 221, 151);
		frame.getContentPane().add(list_1);
		
		JLabel lblColors = new JLabel("Palette");
		lblColors.setBounds(245, 154, 60, 17);
		frame.getContentPane().add(lblColors);
		
		JButton btnCopy_1 = new JButton("->");
		btnCopy_1.setBounds(186, 179, 47, 17);
		frame.getContentPane().add(btnCopy_1);
		
		JButton btnCopy_1_1 = new JButton("X");
		btnCopy_1_1.setBounds(186, 208, 47, 17);
		frame.getContentPane().add(btnCopy_1_1);
	}
}
