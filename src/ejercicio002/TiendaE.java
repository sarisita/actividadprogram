/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio002;

import javax.swing.JOptionPane;

/**
 *
 * @author SARIC
 */
public class TiendaE {

    int codigoProducto;
    String nombreProducto;
    String marca;
    double precioVenta;
    double precioCosto;
    int cantidadStock;

    public TiendaE(int codigoProducto, String nombreProducto, String marca, double precioVenta, double precioCosto, int cantidadStock) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
        this.cantidadStock = cantidadStock;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void getMostrarProductos() {
        String info = "Los datos del producto son: \n";
        info += "Código: " + codigoProducto + "\n";
        info += "Marca: " + marca + "\n";
        info += "Nombre: " + nombreProducto + "\n";
        info += "Precio de venta: " + precioVenta + "\n";
        info += "Precio de costos " + precioCosto + "\n";
        info += "Cantidad en Stock: " + cantidadStock + "\n";
        JOptionPane.showMessageDialog(null, info);
    }

    public double calcularGananciaP() {
        double ganancia = (getPrecioVenta() - getPrecioCosto());
        return ganancia;
    }

    public double calcularImpuesto() {
        double impuesto = 0;
        if (calcularGananciaP() > 50000) {
            impuesto = calcularGananciaTotal() * 0.1;
        }
        return impuesto;
    }

    public double calcularGananciaTotal() {
        double total = (calcularGananciaP() - calcularImpuesto());
        return total;
    }

    public void getMostrarGanancias() {
        String info = "Detalle de Venta: \n";
        info += "Precio de Venta:" + precioVenta + "\n";
        info += "Precio de Costo: " + precioCosto + "\n";
        info += "Ganancia: " + calcularGananciaP() + "\n";
        info += "Impuesto: " + calcularImpuesto() + "\n";

        info += "Ganancia Total" + calcularGananciaTotal();

        JOptionPane.showMessageDialog(null, info);
    }
}
