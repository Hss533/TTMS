package com.ttms.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class SmallSeat implements ItemListener {
	
	private JCheckBox box;
	private String name;
	private JLabel newL;
	private int row;
	private int col;
	
	public SmallSeat(String name,int row,int col) {
		box = new JCheckBox();
		this.name = name;
		this.row =row;
		this.col = col;
		box.addItemListener(this);
	}
	
	public SmallSeat(String name,int row,int col,boolean a) {
		box = new JCheckBox("",a);
		this.box.setEnabled(false);
		this.name = name;
		this.row =row;
		this.col = col;
		box.addItemListener(this);
	}


	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public JCheckBox getBox() {
		return box;
	}

	public void setBox(JCheckBox box) {
		this.box = box;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void itemStateChanged(ItemEvent e) {
		if(box.isSelected())
		{
			newL = new JLabel(this.getName());
			
			Seat.getText1().add(newL);
			Seat.numof();
			Seat.setGetseat(this.row,this.col);
		}
		else
		{
			newL.setVisible(false);
			Seat.numoff();
			Seat.delGetseat(this.row, this.col);

	  }
	}
}
 
