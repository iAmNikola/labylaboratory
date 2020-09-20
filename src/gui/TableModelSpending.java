package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entities.users.Laborant;
import entities.users.Technician;
import entities.users.User;
import services.loadsave.users.LoadUsers;

public class TableModelSpending extends AbstractTableModel{

	private static final long serialVersionUID = -3232382924468695586L;
	
	private String[] columnNames = { "Employee", "Name", "Last name",
			"Reports/Analysis", "Daily pay" };
	private ArrayList<User> data;

	public TableModelSpending() {
		this.data = LoadUsers.getEmployees();

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
		User u = data.get(row);
		if (u instanceof Laborant) {
			Laborant l = (Laborant) u;
			return l.toCell(col);
		} else {
			Technician t = (Technician) u;
			return t.toCell(col);	
		}
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
