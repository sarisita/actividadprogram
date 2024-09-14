/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio002;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author SARIC
 */
public class tiendita {
     Ejercicio002 tienda[];
     int tam;
     
     
        tiendita(JTextField jtam){
        int i;
        try{

            tam = Integer.parseInt(jtam.getText());
            //Declarar el vector
            tienda= new Ejercicio002[tam];
           
            for( i=0; i<tienda.length; i++ ){
                tienda[i] = new Ejercicio002(0,"", "",0.0,0.0,0);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,
                "Error: "+e+".  El vector no fue creado! Intente nuevamente.");
            jtam.setText("");
            jtam.requestFocus();
            tienda = null;
        }
    }
        
          public int getBuscarCodP(String cod){
        int i;
        for( i=0; i<tienda.length; i++ ){
            if( cod.equals(tienda[i].codigoProducto) )
                return i;
        }
        return -1;
    }
          
        public void setOrdenarB() {
    int i, j;
    Ejercicio002 temp;  
    for (i = 0; i < tienda.length - 1; i++) {  
        for (j = 0; j < tienda.length - 1 - i; j++) { 
            
            
            if (tienda[j].calcularGananciaTotal() < tienda[j + 1].calcularGananciaTotal()) {
                
                temp = tienda[j];
                tienda[j] = tienda[j + 1];
                tienda[j + 1] = temp;
            }
        }
    }
        }
        
        public void setOrdenarPorNombre(Ejercicio002[] tienda) {
    int n = tienda.length;
    for (int i = 1; i < n; i++) {
        Ejercicio002 tien = tienda[i]; 
        int j = i - 1;
        
        while (j >= 0 && tienda[j].nombreProducto.compareTo(tien.nombreProducto) > 0) {
            tienda[j + 1] = tienda[j]; 
            j--;
        }
        tienda[j + 1] = tien; 
    }
}
        
        public void setOrdenarPorStock(Ejercicio002[] tienda) {
    int n = tienda.length;
    for (int i = 0; i < n - 1; i++) {
        int Max = i;
        for (int j = i + 1; j < n; j++) {
            
            if (tienda[j].cantidadStock > tienda[Max].cantidadStock) {
                Max = j;
            }
        }
        
        Ejercicio002 temp = tienda[Max];
        tienda[Max] = tienda[i];
        tienda[i] = temp;
    }
        }
  
     
         public boolean setLlenarVec(
        JTextField jtfCodP,
        JTextField jtfnomP,
        JTextField jtfmar,
        JTextField jtfprecioV,
        JTextField jtfprecioC,
          JTextField jtfcant,
        int pos
    ){
        int b;
        try {
            if ((pos < 0) || (pos >= tam)) {
                JOptionPane.showMessageDialog(null,
                        "Posición invalida!");
            } else {
                do {
                    b = getBuscarCodP(jtfCodP.getText());
                    if (b != -1) {
                        JOptionPane.showMessageDialog(null,
                                "El código ya existe.  Intente "
                                + "nuevamente!");
                        jtfCodP.setText("");
                        jtfCodP.requestFocus();
                    }
                } while (b != -1);
                //Si el código no existe se registra
                //la informacion en la posición dada
               tienda [pos].codigoProducto = Integer.parseInt
        (jtfCodP.getText());
                tienda[pos].nombreProducto = jtfnomP.getText();
               tienda[pos].marca =jtfmar.getText();
                tienda[pos].precioVenta = Double.parseDouble
                                       (jtfprecioV.getText());
                tienda[pos].precioCosto = Double.parseDouble
                                       (jtfprecioC.getText());
                 tienda [pos].cantidadStock = Integer.parseInt
        (jtfcant.getText());
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error: "+e+". No fue registrado.");
            return false;
        }
    
}
            public void setRegistrarFilaJTable(DefaultTableModel miModelo,
        int pFila, int pVec){
        
        miModelo.setValueAt(tienda[pVec].codigoProducto, pFila, 0);
        miModelo.setValueAt(tienda[pVec].nombreProducto, pFila, 1);
        miModelo.setValueAt(tienda[pVec].marca, pFila, 2);
        miModelo.setValueAt(tienda[pVec].precioVenta, pFila, 3);
         miModelo.setValueAt(tienda[pVec].precioCosto, pFila, 4);
          miModelo.setValueAt(tienda[pVec].cantidadStock, pFila, 5);
    } 
            
              public void setLlenarJTable(JTable tab){
        int posTabla=0; //Este índice recorre los elementos de la fila Tabla
        int posVec=0;  //Este índice para ubicar posición del vector
        DefaultTableModel miModelo=new DefaultTableModel();

        //Creamos los nombres de las columnas de la tabla
        miModelo.addColumn("Código Producto");
        miModelo.addColumn("Nombre Prroducto");
        miModelo.addColumn("Marca "); 
        miModelo.addColumn("Precio venta"); 
          miModelo.addColumn("Precio Costo"); 
            miModelo.addColumn("Cantidad Stock"); 
        
        //Recorremos el vector para tomar sus datos
        //y pasarlos al JTable
        while(posVec<tienda.length){                        
            miModelo.addRow(new Object[]{ "", "", "", "" ,"",""});              
            setRegistrarFilaJTable(miModelo,posTabla,posVec);            
            posVec++;
            posTabla++;
        }
        tab.setModel(miModelo);
    }
    
    
}
