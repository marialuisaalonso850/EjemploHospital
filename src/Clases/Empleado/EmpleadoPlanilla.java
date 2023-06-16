package Clases.Empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado{
	
	private double salarioMensual;
	private double porcentajeMensualPorHora;
	public double getSalarioMensual() {
		return salarioMensual;
	}
	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}
	public double getPorcentajeMensualPorHora() {
		return porcentajeMensualPorHora;
	}
	public void setPorcentajeMensualPorHora(double porcentajeMensualPorHora) {
		this.porcentajeMensualPorHora = porcentajeMensualPorHora;
	}
	public void registrarDatos() {
		super.registrarDatos();
		
		salarioMensual= Double
				.parseDouble(JOptionPane.showInputDialog("Salario mensual"));
		porcentajeMensualPorHora=Double
				.parseDouble(JOptionPane.showInputDialog("Porcentuaje mensual por hora"));
	}	

}
