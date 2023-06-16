package Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Clases.Empleado.EmpleadoEventual;
import Clases.Empleado.EmpleadoPlanilla;
import Clases.Empleado.Medico;

public class ModelosDeDatos {

	HashMap<String, Paciente> pacienteMap;
	HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
	HashMap<String, EmpleadoEventual> empleadosEventualMap;
	HashMap<String, Medico> medicoMap;
	ArrayList<CitaMedica> citaList;

	public ModelosDeDatos() {
		pacienteMap = new HashMap<String, Paciente>();
		empleadosPlanillaMap = new HashMap<String, EmpleadoPlanilla>();
		empleadosEventualMap = new HashMap<String, EmpleadoEventual>();
		medicoMap = new HashMap<String, Medico>();
		citaList = new ArrayList<CitaMedica>();
	}

	public HashMap<String, Paciente> getPacienteMap() {
		return pacienteMap;
	}

	public void setPacienteMap(HashMap<String, Paciente> pacienteMap) {
		this.pacienteMap = pacienteMap;
	}

	public HashMap<String, EmpleadoPlanilla> getEmpleadosPlanillaMap() {
		return empleadosPlanillaMap;
	}

	public void setEmpleadosPlanillaMap(HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap) {
		this.empleadosPlanillaMap = empleadosPlanillaMap;
	}

	public HashMap<String, EmpleadoEventual> getEmpleadosEventualMap() {
		return empleadosEventualMap;
	}

	public void setEmpleadosEventualMap(HashMap<String, EmpleadoEventual> empleadosEventualMap) {
		this.empleadosEventualMap = empleadosEventualMap;
	}

	public HashMap<String, Medico> getMedicoMap() {
		return medicoMap;
	}

	public void setMedicoMap(HashMap<String, Medico> medicoMap) {
		this.medicoMap = medicoMap;
	}

	public void registrarPersona(Paciente miPaciente) {
		pacienteMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
		System.out.println("Se ha registrado el paciente " + miPaciente.getNombre() + " Satisfactoriamente");

	}

	public void registrarPersona(EmpleadoPlanilla miEmpPlanilla) {
		empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
		System.out.println(
				"Se ha registrado el empleado por planilla " + miEmpPlanilla.getNombre() + " Satisfactoriamente");

	}

	public void registrarPersona(EmpleadoEventual miEmpEventual) {
		empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
		System.out
				.println("Se ha registrado el empleado eventual " + miEmpEventual.getNombre() + " Satisfactoriamente");

	}

	public void registrarPersona(Medico miMedico) {
		medicoMap.put(miMedico.getNumeroDeDNI(), miMedico);
		System.out.println("Se ha registrado el medico " + miMedico.getNombre() + " Satisfactoriamente");

	}

	public void imprimirEmpleadosEventuales() {
		String msj = "Empleado Eventuales Registrados\n";

		for (String clave:empleadosEventualMap.keySet()) {
			empleadosEventualMap.get(clave).imprimirDatosPersona(msj);;

		}

	}

	public void imprimirPacientes() {
		String msj = "Pacientes Registrados\n";
		Iterator<String> iterator = pacienteMap.keySet().iterator();
		while (iterator.hasNext()) {
			String clave = iterator.next();
			pacienteMap.get(clave).imprimirDatosPersona(msj);

		}
	}

	public void imprimirEmpleadosPorPlanilla() {
		String msj = "Empleado por Planilla Registrados\n";

		for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
			empleadoPlanilla.imprimirDatosPersona(msj);

		}
	}

	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		Paciente miPaciente = null;
		if (pacienteMap.containsKey(documentoPaciente)) {
			miPaciente = pacienteMap.get(documentoPaciente);

		}
		return miPaciente;

	}

	public void imprimirMedicos() {
		String msj = "Medicos Registrados \n";
		for (Map.Entry<String, Medico> element : medicoMap.entrySet()) {
			element.getValue().imprimirDatosPersona(msj);
		}

	}

	public Medico ConsultarMedicoPorNombre(String nombreMedico) {
		for (Medico medico : medicoMap.values()) {
			if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
				return medico;
			}

		}
		return null;
	}
	public void registrarCitaMedica(CitaMedica miCita) {
		citaList.add(miCita);
		System.out.println("Se ha registrado su cita exitosamente");
		System.out.println(miCita.informacionMedica());
	}

	public void imprimirCitasProgramadas() {
	String msj="CITAS MEDICAS PROGRAMADAS\n";
	CitaMedica miCita=null;
	System.out.println(msj+"\n");
	if (citaList.size()>0) {
		for (int i = 0; i <citaList.size(); i++) {
			miCita=citaList.get(i);
			System.out.println(miCita.informacionMedica());
			
		}
		
	} else {
		System.out.println("No existe la cita programada");

	}
	
		
	}
}
