package entidades;

import java.util.*;
import java.time.LocalDate;
import java.util.Collections; //Lo usamos para retornar la lista de tareas y que no se puedan modificar
import java.util.HashMap;

public class Proyecto {
	
	private int identificacion;
	private LocalDate fechaInicio; // ver como solucionar el error de fechas 
	private LocalDate fechaEstimadaFin;
	private LocalDate fechaRealFin;
	private Cliente cliente;
	private HashMap <String, Tarea> tareas; // ES HASHMAPcambie Diccionario por Map, IA me dijo que en java se usa asi, a confirmar
	private String direccion;
	private double costo;
	private double costoFinal;
	private String estado;
	private List<Empleado> historialEmpleados; // lo cambine por List
	
	
	//VER TAREAS
	public void crear(int identificacion, LocalDate fechaInicio, Cliente cliente, Tarea tareas) {
	        this.identificacion = identificacion;
	        this.fechaInicio = fechaInicio;
	        this.cliente = cliente;
	        this.tareas = new HashMap<>();
	        this.direccion = "";
	        this.costo = 0;
	        this.costoFinal = 0;
	        this.estado = Estado.pendiente;
	        this.historialEmpleados = new ArrayList<>();
	}
	//LISTO
	public void guardarCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	//LISTO
	public void agregarDireccionVivienda(String direccion) {
		this.direccion = direccion;
	}
	//LE PASAMOS EL OBJ TAREA Y LA CLAVE ES SU TITULO Y EL VALOR EL OBJ TAREA.
	public void registrarTarea(Tarea tarea) {
		if (tarea != null) {
	    tareas.put(tarea.darTitulo(), tarea);
	    }
	}
	//public void registrarTarea(String tituloTarea) {
	//	if(!tareas.containsKey(tituloTarea)) {
	//		tareas.put(tituloTarea,new Tarea()); // verificar 
		//}
	//} ESTE NO SIRVIRIA PQ CREA UNA TAREA VACIA.
	//LISTO
	public boolean estaPendiente() {
	    return this.estado.equals(Estado.pendiente);
	}
	//LISTO
	public boolean estaActivo() {
	    return this.estado.equals(Estado.activo);
	}
	//LISTO
	public boolean estaFinalizado() {
	    return this.estado.equals(Estado.finalizado);
	}
	//LISTO
	public void actualizarEstadoProyecto(String nuevoEstado) {
	    String estadoMayuscula = nuevoEstado.toUpperCase(); 	    // Convertimos a mayúsculas para comparar con las constantes
//SI ES IGUAL A ALGUNA CONSTANTE QUE ESTA EN LA CLASE ESTADO, QUE SE ACTUALICE, SINO, IMPRIME ERROR
	    if (estadoMayuscula.equals(Estado.activo) ||
	    	estadoMayuscula.equals(Estado.pendiente) ||
	    	estadoMayuscula.equals(Estado.finalizado)) {
	        this.estado = estadoMayuscula;
	    } else {
	        System.out.println("Estado inválido: " + nuevoEstado);
	    }
	}
	
	//LISTO
	public double darCostoFinal() {
		return this.costoFinal;
	}
	//LISTO
	public Tarea buscarTarea(String tituloTarea) {
		
	    Tarea tarea = tareas.get(tituloTarea); //busco en el hashmap tareas, la tarea de tituloTarea, lo guardo en la variable tarea que es del tipo Tarea.
	    return tarea;
	}
//LISTO	
	public int darIdentificacion() {
		return this.identificacion;
	}
	//LISTA
	
	public void actualizarFechaEstimadaFin(double dias) {
	    if (this.fechaEstimadaFin != null) {
	        // Redondeamos siempre para arriba
	        long diasASumar = (long) Math.ceil(dias);
	        this.fechaEstimadaFin = this.fechaEstimadaFin.plusDays(diasASumar);
	    }
	}
	//LISTA
	public void actualizarFechaRealFin(double dias) {
	    if (this.fechaRealFin != null) {
	        this.fechaRealFin = this.fechaRealFin.plusDays((long) dias);
	    }
	}
	public void actualizarFechaRealFin(int dias) {
		if(this.fechaRealFin != null) {
		    this.fechaRealFin = this.fechaEstimadaFin.plusDays(dias); //a la fecha estimada, se le suma la cant de dias que se ingresan por parametro
		}
	}
	//LISTA
	public void registrarEmpleadoEnHistorial(Empleado empleado) {
        if (!historialEmpleados.contains(empleado)) { //Si no esta en la lista, agregarlo.
            historialEmpleados.add(empleado);
        }
	}
	//LISTO
	public LocalDate darFechaEstimadaFin() {
		return this.fechaEstimadaFin;
	}
	//LISTO
	public LocalDate darFechaRealFin() {
		return this.fechaRealFin;
	}
	//LISTO
	public String darEstado() {
		return this.estado;
	}
	public HashMap<String, Tarea> darTareas() {
	    return new HashMap<>(Collections.unmodifiableMap(this.tareas)); //Crea una copia HASHMAP de mis tareas, si bien pueden modificarla, no afecta a nuestras tareas
	}
	
	public String darDireccion () {
		return this.direccion;
	}

	//public Diccionario <String,Tarea> darTareas() {
		//return this.tareas;
	//}
}
