public abstract class Empleado {
	private String nombre;
	private int numLegajo;
	private String estado;
	private boolean tuvoRetraso;
	private int cantDeRetraso;
	
	
	public void crearEmpleado(String nombre, int legajo) {
	        this.nombre = nombre;
	        this.numLegajo = legajo;
	        this.estado = "libre"; // valor inicial
	        this.tuvoRetraso = false;
	        this.cantDeRetraso = 0;
	
	}
	
	public int darNumLegajo() {
		
		return this.numLegajo;
	
	}
	
	public boolean estaAsignado() {
		
		return this.estado.equalsIgnoreCase("asignado");
	
	}
	
	public void actualizarEstado() {
		
	      if (this.estado.equalsIgnoreCase("asignado")) {
	            this.estado = "libre";
	        } else {
	            this.estado = "asignado";
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
	
	public abstract double cobrarPagoBase(int dias); // abs // cambie int dias porque en tarea tiraba error cuando usaba el metodo
	
	
}
