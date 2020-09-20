package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entities.Report;
import services.loadsave.reports.LoadReports;


public class TableModelIncome extends AbstractTableModel  {

	private static final long serialVersionUID = 2195549248621006627L;
	
	private String[] columnNames = { "Report ID", "Name", "Last name",
			"Number of analysis", "Price" };
	private ArrayList<Report> data;

	public TableModelIncome() {
		this.data = LoadReports.reportsList;

	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	@Override
	public int getRowCount() {
		return data.size();
	}
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	@Override
	public Object getValueAt(int row, int col) {
		Report r = data.get(row);
		return r.toCell(col);
	}

	@Override
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	@Override
	public boolean isCellEditable(int row, int col) {
			return false;
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		//wont be possible
	}

}

