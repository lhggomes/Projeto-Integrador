package model; 

import entity.Doctor; 
import java.awt.List;
import javax.swing.table.AbstractTableModel;


public class PersonDoctorModel extends AbstractTableModel {
    
    private String [] columnNames = {"ID_Paciente", "Nome", "Médico", "Ala", "Situação"};
    private List<Doctor> consultas; 

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}