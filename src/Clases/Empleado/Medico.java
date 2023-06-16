package Clases.Empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla {
	
	private String  especialidad;
	private int numeroConsultorio;
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getNumeroConsultorio() {
		return numeroConsultorio;
	}
	public void setNumeroConsultorio(int numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}
	
	public void registrarDatos() {
		super.registrarDatos();
		
		especialidad = JOptionPane.showInputDialog("Ingrese la especialidad");
		numeroConsultorio=Integer
				.parseInt(JOptionPane.showInputDialog("numero de consultorio"));
	}

}
