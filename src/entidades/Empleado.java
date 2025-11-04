package entidades;

public abstract class Empleado {
	private String nombre;
	private int numLegajo;
	private String estado;
	private boolean tuvoRetraso;
	private int cantDeRetraso;
	
	public void crearEmpleado(String nombre, int legajo) {
	        this.nombre = nombre;
	        this.numLegajo = legajo;
	        this.estado = EstadoEmpleado.libre; // valor inicial
	        this.tuvoRetraso = false;
	        this.cantDeRetraso = 0;
	}
	public int darNumLegajo() {
		return this.numLegajo;
	}
	public boolean estaAsignado() {
	    return this.estado.equals(EstadoEmpleado.asignado);	
	}
	public void actualizarEstado() {
	      if ( this.estado.equals(EstadoEmpleado.asignado)) {
	            this.estado =EstadoEmpleado.libre;
	        } else {
	            this.estado =EstadoEmpleado.asignado;
	        }
	}
	public boolean tuvoRetraso() {
		return this.tuvoRetraso;
	}
	public int darCantidadRetrasos() {
		return this.cantDeRetraso;	
	}
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
	public void seRetraso() {
		this.tuvoRetraso=true;	}
	
	public void liberarEmpleado() {
	    this.estado = EstadoEmpleado.libre; 
	}
	
	public abstract double cobrarPagoBase(double dias) ;
}
