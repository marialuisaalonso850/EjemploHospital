
import javax.swing.JOptionPane;

import Clases.CitaMedica;
import Clases.ModelosDeDatos;
import Clases.Paciente;
import Clases.Empleado.EmpleadoEventual;
import Clases.Empleado.EmpleadoPlanilla;
import Clases.Empleado.Medico;

public class Procesos {

	ModelosDeDatos miMode;

	public void Procesos() {
		miMode = new ModelosDeDatos();
		presentarMenuOpciones();
		
	}

	private void presentarMenuOpciones() {

		String menu = "MENU HOSPITAL\n";
		menu += "1.Registrar Paciente\n";
		menu += "2.Registrar Empleado\n";
		menu += "3.Registrar Cita Medica\n";
		menu += "4.Imprimir Información\n";
		menu += "5.Salir\n";
		menu += "ingrese una Opción\n";

		int opcion = 0;

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcion) {

			case 1:
				registrarPaciente();
				break;
			case 2:
				registrarEmpleado();
				break;
			case 3:
				registrarCitaMedica();
				break;
			case 4:
				imprimirInformacion();
				break;
			case 5:
				System.out.println("El sistema ha terminado!");
				break;

			default:
				System.out.println("No existe el código, verifique nuevamente");

				break;
			}
		} while (opcion != 5);
	}

	private void imprimirInformacion() {
		String menuImprimir="MENU IMPRESIONES\nn";
		menuImprimir+="1. Listar Pacientes\n";
		menuImprimir+="2. Listar Empleados Eventuales\n";

		menuImprimir+="3. Listar Empleados Por Planilla\n";
		menuImprimir+="4. Listar Medicos\n";
		menuImprimir+="5. Listar citas programadas\n";
		menuImprimir+="Ingrese una opción\n";

		System.out.println("_________________________________________________________");

		int opcion=Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));

		switch (opcion) {

		case 1: miMode.imprimirPacientes(); break;

		case 2: miMode.imprimirEmpleadosEventuales(); break;
		case 3 :miMode.imprimirEmpleadosPorPlanilla(); break;

		case 4: miMode.imprimirMedicos(); break;
		
		case 5:miMode.imprimirCitasProgramadas();
			break;

		default: System.out.println("No exite esa opción");
		break;
		}


	}
	private void registrarCitaMedica() {
			String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");
			Paciente pacienteEncontrado=miMode.consultarPacientePorDocumento(documentoPaciente) ;
            
			
			if (pacienteEncontrado!=null) {

			String nombreMedico=JOptionPane.showInputDialog("Ingrese el nombre del médico");
			Medico medicoEncontrado=miMode.ConsultarMedicoPorNombre(nombreMedico) ;

			if(medicoEncontrado!=null) {
			String servicio=JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");

			String fechaConsulta =JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
			String horaConsulta=JOptionPane.showInputDialog("Ingrese la hora de la consulta");
            
			String lugar="La cita en el consultorio"+medicoEncontrado.getNumeroConsultorio();
			CitaMedica miCita= new CitaMedica(pacienteEncontrado, medicoEncontrado, servicio, lugar);
			miMode.registrarCitaMedica(miCita);
			
			}else {
			System.out.println("El medico no se encuentra registrado en el sistema");
			}
			}else {

			System.out.println("El paciente no se encuentra registrado en el sistema");
			}
}


	private void registrarEmpleado() {
		String menuTipoEmpleado="Registro de Empleado \n";
				menuTipoEmpleado+="1. Empleado Eventual\n";
				menuTipoEmpleado+="2. Empleado por Planilla\n";
				menuTipoEmpleado+="Seleccione el tipo de empleado a registrar\n";

				int tipoEmpleado=Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));

				switch (tipoEmpleado) {
				case 1: //Registro Empleado Eventual
				EmpleadoEventual miempleadoEventual=new EmpleadoEventual();
				miempleadoEventual.registrarDatos();
				miMode.registrarPersona(miempleadoEventual); 
				break;
				case 2:
				String resp=JOptionPane.showInputDialog("Ingrese si, si es un médico, de lo contrario es otro tipo" );
				if (resp.equalsIgnoreCase("si")) {
			
				Medico miMedico=new Medico();
				miMedico.registrarDatos(); 
				miMode.registrarPersona(miMedico) ;
				}else {
			
				EmpleadoPlanilla miEmpleadoPlanilla=new EmpleadoPlanilla();
				miEmpleadoPlanilla.registrarDatos();
				miMode.registrarPersona(miEmpleadoPlanilla); 

				}
				break;

				default:System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
				break;
				}

	}

	private void registrarPaciente() {
		Paciente miPci = new Paciente();
		miPci.registrarDatos();
		miMode.registrarPersona(miPci);

	}
	
	

}