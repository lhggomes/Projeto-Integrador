package model;


import entity.Pacientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PersonDoctorModel extends AbstractTableModel {

    private String[] columnNames = {"ID_Paciente", "Nome", "Situação"};
    private List<Pacientes> pacientes;

    @Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return pacientes.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Pacientes c = (Pacientes) pacientes.toArray()[arg0]; 
		switch (arg1) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		}
		return null;
	}
	
	@Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch (columnIndex){
		case 0: 
			return Integer.class;
		case 1:
			return String.class;
		}
		return null;
	}
        
        public Pacientes getObjectAtRow(int row) {
            return pacientes.get(row);
        }

}
