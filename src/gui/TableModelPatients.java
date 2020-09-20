package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entities.users.Patient;
import services.loadsave.users.LoadUsers;

public class TableModelPatients extends AbstractTableModel{

	private static final long serialVersionUID = 4545296766078900244L;
	
	private String[] columnNames = { "Name", "Last name",
			"Number of reports", "Total price" };
	private ArrayList<Patient> data;

	public TableModelPatients() {
		this.data = LoadUsers.getPatients();

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
		Patient p = data.get(row);
		return p.toCell(col);
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
