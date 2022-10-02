package modelo;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableModelPostulante implements TableModel {
    private ArrayList<Postulante> postulantes;
    
    public TableModelPostulante(ArrayList<Postulante> lista){
        postulantes = lista;
    }
    
    @Override
    public int getRowCount() { // Cuantas filas tiene la tabla
        if(postulantes == null)
            return 1;
        return postulantes.size();
    }

    @Override
    public int getColumnCount() { // Cuantas columnas tiene la tabla. Siempre es 3 porque se mostrará Rut, Nombre y Correo.
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) { // Conseguir los nombres de las columnas q mostrará la tabla
        String titulo = null;
        switch(columnIndex){
            case 0:{
                titulo = "RUT";
                break;
            }
            case 1:{
                titulo = "Nombre";
                break;
            }
            case 2:{
                titulo = "Correo";
                break;
            }
        }
        return titulo;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0)
            return Integer.class;
        else
            return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(postulantes == null)
            return "";
        Postulante p = postulantes.get(rowIndex);
        String valor = null;
        
        switch(columnIndex){
            case 0:{
                valor = String.valueOf(p.getRut());
                break;
            }
            case 1:{
                valor = p.getNombre();
                break;
            }
            case 2:{
                valor = p.getCorreo();
                break;
            }
        }
        return valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
