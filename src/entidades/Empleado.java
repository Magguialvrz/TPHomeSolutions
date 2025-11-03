package entidades;

public abstract class Empleado {
	private String nombre;
	private int numLegajo;
	private String estado;
	private boolean tuvoRetraso;
	private int cantDeRetraso;
	
	//LISTO
	public void crearEmpleado(String nombre, int legajo) {
	        this.nombre = nombre;
	        this.numLegajo = legajo;
	        this.estado = EstadoEmpleado.libre; // valor inicial
	        this.tuvoRetraso = false;
	        this.cantDeRetraso = 0;
	}
	//LISTO
	public int darNumLegajo() {
		return this.numLegajo;
	}
	//LISTO
	public boolean estaAsignado() {
	    return this.estado.equals(EstadoEmpleado.asignado);	
	}
	//LISTO
	public void actualizarEstado() {
	      if ( this.estado.equals(EstadoEmpleado.asignado)) {
	            this.estado =EstadoEmpleado.libre;
	        } else {
	            this.estado =EstadoEmpleado.asignado;
	        }
	}
	//LISTO
	public boolean tuvoRetraso() {
		return this.tuvoRetraso;
	}
	//LISTO
	public int darCantidadRetrasos() {
		return this.cantDeRetraso;	
	}
	//LISTO
	public void actualizarCantRetrasos() {
		this.cantDeRetraso++;
		this.tuvoRetraso = true;
	}
	
	public String darEstado() {
		return this.estado;
	}
	public String darNombre() { // agregue esta para el metodo empleadosAsignadosAProyecto
	    return this.nombre;
	}
	
	// abs // cambie int dias porque en tarea tiraba error cuando usaba el metodo
	public abstract double cobrarPagoBase(int dias) ;
}
