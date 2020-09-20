package gui;

import javax.swing.table.AbstractTableModel;

import entities.Report;

public class TableModelReport extends AbstractTableModel{
	
	private static final long serialVersionUID = -7491030725096608058L;
	
	private String[] columnNames = { "Group", "Analysis", "Date",
			"Result", "Low value", "High value", "Price" };
	private Report data;

	public TableModelReport(Report r) {
		this.data = r;
	}
	
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	@Override
	public int getRowCount() {
		return data.getAnalysis().length;
	}
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	@Override
	public Object getValueAt(int row, int col) {
		int id = data.getAnalysis()[row];
		return data.toCell(id, col);
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
