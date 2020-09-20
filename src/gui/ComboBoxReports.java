package gui;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import entities.Report;
import services.loadsave.reports.LoadReports;


public class ComboBoxReports extends AbstractListModel implements ComboBoxModel {

	private static final long serialVersionUID = 5143533522330447920L;
	
	private ArrayList<Report> reports;
	
	public ComboBoxReports(ArrayList<Report> reports) {
		this.reports = reports;
	}
	
	public ComboBoxReports(String lbo) {
		reports = LoadReports.getPatientReports(lbo);
	}
	
	Report selection;
	
	@Override
	public Object getElementAt(int index) {
		return reports.get(index);
	}
	
	@Override
	public int getSize() {
		return reports.size();
	}
	
	@Override
	public void setSelectedItem(Object anItem) {
		selection = (Report) anItem;
	}
	
	@Override
	public Report getSelectedItem() {
		return selection;
	}
}

