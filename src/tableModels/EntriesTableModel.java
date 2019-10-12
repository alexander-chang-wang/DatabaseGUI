/**
 * TableModel for the entries table
 */
package tableModels;

import javax.swing.table.AbstractTableModel;

public class EntriesTableModel extends AbstractTableModel {
	
	/* Members*/
	private String[] columnNames;
	private String[][] columnValues;
	
	/* Constructor */
	public EntriesTableModel(String[] columnNames, String[][] columnValues) {
		this.columnNames = columnNames;
		this.columnValues = columnValues;
	}

	@Override // return the length of 'columnValues'
	public int getRowCount() {
		return columnValues.length;
	}

	@Override // return the length of 'columnNames'
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override // TODO: once there is enough information on the actual table, set this up
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getColumnNames(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	// method: sets columns_values to a String[][] input
	public void setNewColumnValues(String[][] columnValuesInput) {
		this.columnValues = columnValuesInput;
	}
}
