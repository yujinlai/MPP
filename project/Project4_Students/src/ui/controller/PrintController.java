package ui.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import business.CheckOutRecord;
import business.CheckoutRecordEntry;
import business.ControllerInterface;
import business.LibrarySystemException;
import business.SystemController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ui.ruleengine.RuleException;
import ui.ruleengine.RuleSet;
import ui.ruleengine.RuleSetFactory;

public class PrintController implements LibController {
	@FXML
	private TextField memberID;
	
	public TextField getMemberID() {
		return memberID;
	}

	public void setMemberID(TextField memberID) {
		this.memberID = memberID;
	}
	
	@FXML
	private Text actiontarget;

	@FXML
	protected void printRecord() {
		try {			
			RuleSet rules = RuleSetFactory.getRuleSet(PrintController.this);
			rules.applyRules(PrintController.this);
			ControllerInterface c = new SystemController();
			CheckOutRecord record = c.getCheckoutRecord(memberID.getText().trim());
			printConsole(record);
			actiontarget.setText("Please check out the console to get the output");
		} catch (RuleException e) {
			actiontarget.setText(e.getMessage());
		} catch (LibrarySystemException e) {
			actiontarget.setText(e.getMessage());
		} 
	}
	
	private void printConsole(CheckOutRecord record) {
		if(record == null) {
			System.out.println("The libray member " + memberID.getText() +" doesn't have any checkout record.");
			return;
		}
		ArrayList<CheckoutRecordEntry> entries = record.getCheckOutRecords();
		String member = record.getMemberID();
	    System.out.println("The libray member " + member +"'checkout records are as below:");
	    System.out.format("%25s%25s%25s%25s",
	    	    "Title", "Copy Number", "Checkout Date", "Due Date");
	    System.out.println("");
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(CheckoutRecordEntry e : entries) {
			System.out.format ("%25s%25s%25s%25s", e.getRequestedBook().getBook().getTitle(),
		      e.getRequestedBook().getCopyNum(), sdf.format(e.getCheckoutDate()), sdf.format(e.getDueDate()));
			System.out.println("");
		}
	}
}
