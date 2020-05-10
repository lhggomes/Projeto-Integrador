package model;

import entity.Doctor;
import entity.Consultas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PersonDoctorModel extends AbstractTableModel {

    private String[] columnNames = {"ID_Paciente", "Nome", "Médico", "Ala", "Situação"};
    private List<Consultas> consultas;

    @Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return consultas.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Consultas c = (Consultas) consultas.toArray()[arg0]; 
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
        
        public Consultas getObjectAtRow(int row) {
            return consultas.get(row);
        }

}
