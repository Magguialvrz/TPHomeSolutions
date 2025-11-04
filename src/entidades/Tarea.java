package entidades;

public class Tarea {
	
	
	private String titulo;
	private String descripcion;
	private double cantidadDias;
	private Empleado empleadoAsignado;
	private double diasDeRetraso;
	private double costo;
	private String estado;
	private double costoFinal;
	
	public Tarea(String titulo, String descripcion, double cantidadDias) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.cantidadDias = cantidadDias;
		 this.empleadoAsignado = null;
        this.diasDeRetraso = 0;
        this.costo = 0;
        this.estado = Estado.pendiente;
	}

	public double darDiasRetraso() {
		return this.diasDeRetraso;
	}
	public void actualizarDiasDeRetraso(double num) {
		this.diasDeRetraso = num;
	}
	
	public void modificarCantDias(double diasDeRetraso) {
	
		this.cantidadDias += diasDeRetraso;
		actualizarCosto(diasDeRetraso);
		
	}
	
	public boolean tieneEmpleado() {
		return this.empleadoAsignado != null;
		
	}
	public void asignarEmpleado(Empleado empleado) {
        this.empleadoAsignado = empleado;
    }
	
	//LISTA
	public void eliminarEmpleadoAsignado() {
		
		this.empleadoAsignado = null;
	
	}
	//consideramos los retrasos
	 public void calcularCostoBase() {
	        if (darEmpleadoAsignado() instanceof EmpleadoContratado) {
	            EmpleadoContratado contratado = (EmpleadoContratado) empleadoAsignado;
	            this.costoFinal = contratado.cobrarPagoBase(cantidadDias);
	        }
	        if (darEmpleadoAsignado() instanceof EmpleadoDePlanta) {
	        	EmpleadoDePlanta dePlanta = (EmpleadoDePlanta) empleadoAsignado;
	        	this.costoFinal = dePlanta.cobrarPagoBase(cantidadDias);
	        }
	 }
	        
	public void actualizarCosto(double diasExtras) {
		double costoExtra;
		 if (darEmpleadoAsignado() instanceof EmpleadoContratado) {
	            EmpleadoContratado contratado = (EmpleadoContratado) empleadoAsignado;
	             costoExtra = contratado.cobrarPagoBase(diasExtras);
	             this.costoFinal += costoExtra;
		 }
	        if (darEmpleadoAsignado() instanceof EmpleadoDePlanta) {
	        	EmpleadoDePlanta dePlanta = (EmpleadoDePlanta) empleadoAsignado;
	             costoExtra = dePlanta.cobrarPagoBase(diasExtras);
	             this.costoFinal += costoExtra;
	        }
	        }
	
	        
	public double darCostoFinal() {
		return this.costoFinal;
	
	}
	public boolean hayRetraso() {
		return this.diasDeRetraso > 0 ;
	
	}

	public void actualizarEstadoTarea(String nuevoEstado) {
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
	public String darTitulo() {
		
		return this.titulo;
	
	}
	public double darCantidadDias() {
		
		return this.cantidadDias;
	
	}
	public String darEstado() {
		
		return this.estado;
	
	}
	public int darLegajoEmpleado() {
		
		if(this.empleadoAsignado != null) {
			return this.empleadoAsignado.darNumLegajo();
		}
		
        System.out.println("No hay empleado asignado a esta tarea.");
		return -1; //O UN SYSTEM.OUT.PRINTL"NO HAY EMPLEADO"
	
	}
	
	public Empleado darEmpleadoAsignado() {
	    return this.empleadoAsignado;
	}
	
	@Override
	public String toString(){
		return this.darTitulo();
			}
}
