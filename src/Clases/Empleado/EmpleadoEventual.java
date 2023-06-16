package Clases.Empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado {
	
	private double HonorariosPorhora;
	private String fechaTerminoContrato;
	public double getHonorariosPorhora() {
		return HonorariosPorhora;
	}
	public void setHonorariosPorhora(double honorariosPorhora) {
		HonorariosPorhora = honorariosPorhora;
	}
	public String getFechaTerminoContrato() {
		return fechaTerminoContrato;
	}
	public void setFechaTerminoContrato(String fechaTerminoContrato) {
		this.fechaTerminoContrato = fechaTerminoContrato;
	}
	
	public void registrarDatos() {
		super.registrarDatos();
		
		fechaTerminoContrato = JOptionPane.showInputDialog("fecha que termina contrato");
		HonorariosPorhora=Double
				.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual"));
	}

}
