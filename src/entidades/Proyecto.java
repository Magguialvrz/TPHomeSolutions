import java.util.*;

public class Proyecto {
	
	private int identificacion;
	private Fecha fechaInicio; // ver como solucionar el error de fechas 
	private Fecha fechaEstimadaFin;
	private Fecha fechaRealFin;
	private Cliente cliente;
	private Map <String, Tarea> tareas; // cambie Diccionario por Map, IA me dijo que en java se usa asi, a confirmar
	private String direccion;
	private double costo;
	private double costoFinal;
	private String estado;
	private List<Empleado> historialEmpleados; // lo cambine por List
	
	
	
	
	public void crear(int identificacion, Fecha fechaInicio, Cliente cliente, Tarea tareas) {
	        this.identificacion = identificacion;
	        this.fechaInicio = fechaInicio;
	        this.cliente = cliente;
	        this.tareas = (tareas != null) ? (Map<String, Tarea>) tareas : new HashMap<>();
	        this.direccion = "";
	        this.costo = 0;
	        this.costoFinal = 0;
	        this.estado = "pendiente";
	        this.historialEmpleados = new ArrayList<>();
	}
	
	public void guardarCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void agregarDireccionVivienda(String direccion) {
		this.direccion = direccion;
	}
	
	public void registrarTarea(String tituloTarea) {
		if(!tareas.containsKey(tituloTarea)) {
			tareas.put(tituloTarea,new Tarea()); // verificar 
		}
	}
	
	public boolean estaPendiente() {
		return this.estado.equalsIgnoreCase("pendiente");
	}
	
	public boolean estaActivo() {
		return this.estado.equalsIgnoreCase("activo");
	}
	
	public boolean estaFinalizado() {
		return this.estado.equalsIgnoreCase("finalizado");
	}
	
	public void actualizarEstadoProyecto(String estado) {
		this.estado = estado;
	}
	
	public void actualizarFechaRealFin(Fecha fecha) {
		this.fechaRealFin = fecha;
	}
	
	public double darCostoFinal() {
		return this.costoFinal;
	}
	
	public Tarea buscarTarea(String tituloTarea) {
		return tareas.get(tituloTarea);
	}
	
	public int darIdentifiacion() {
		return this.identificacion;
	}
	
	public void actualizarFechaEstimadaFin(int idias) {
	   if (this.fechaEstimadaFin != null) {
	   
	            this.fechaEstimadaFin.sumarDias(dias); // supongo que es un error de fecha
	   }
	
	}
	
	public void actualizarFechaRealFin(int dias) {
		
		if(this.fechaRealFin != null) {
			this.fechaRealFin.sumarDias(dias);
		}
	
	}
	
	public void registrarEmpleadoEnHistorial(Empleado empleado) {
	
        if (!historialEmpleados.contains(empleado)) {
            historialEmpleados.add(empleado);
        }
	}
	
	public Fecha darFechaEstimadaFin() {
	
		return this.fechaEstimadaFin;
	}
	
	public Fecha darFechaRealFin() {
	
		return this.fechaRealFin;
	}
	
	public String darEstado() {
		return this.estado;
	}
	
	public Diccionario <String,Tarea> darTareas() {
		return this.tareas;
	}
}
