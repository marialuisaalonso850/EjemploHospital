package Clases.Empleado;

import javax.swing.JOptionPane;

import Clases.Persona;

public class Empleado extends Persona {

	private String codigoDeEmpleado;
	private int numeroDeHorasExtras;
	private String fechaDeIngreso;
	private String area;

	private String cargo;

	public String getCodigoDeEmpleado() {
		return codigoDeEmpleado;
	}

	public void setCodigoDeEmpleado(String codigoDeEmpleado) {
		this.codigoDeEmpleado = codigoDeEmpleado;
	}

	public int getNumeroDeHorasExtras() {
		return numeroDeHorasExtras;
	}

	public void setNumeroDeHorasExtras(int numeroDeHorasExtras) {
		this.numeroDeHorasExtras = numeroDeHorasExtras;
	}

	public String getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void registrarDatos() {
		super.registrarDatos();

		String codigoDeEmpleado = JOptionPane.showInputDialog("Ingrese el codigo del empleado");
		int numeroDeHorasExtras = Integer.parseInt(JOptionPane.showInputDialog("numero de horas extras"));
		String fechaDeIngreso = JOptionPane.showInputDialog("fecha de ingreso");
		String area = JOptionPane.showInputDialog("Ingrese el area");
		String cargo = JOptionPane.showInputDialog("Ingrese el cargo");

	}

}