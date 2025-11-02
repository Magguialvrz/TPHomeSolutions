

public class Tarea {
	
	
	private String titulo;
	private String descripcion;
	private double cantidadDias;
	private Empleado empleadoAsignado;
	private double diasDeRetraso;
	private double costo;
	private String estado;
	
	
	public void crear(String titulo, String descripcion, double cantDias) {
		
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cantidadDias = cantDias;
        this.empleadoAsignado = null;
        this.diasDeRetraso = 0;
        this.costo = 0;
        this.estado = Estado.pendiente;
	
	}
	//LISTA
	public double darDiasRetraso() {
		return this.diasDeRetraso;
	}
	//LISTA
	public void actualizarDiasDeRetraso(double num) {
		this.diasDeRetraso = num;
	}
	
	//LISTA
	public void modificarCantDias(double diasDeRetraso) {
	
		this.cantidadDias += diasDeRetraso;
	}
	
	//LISTA
	public boolean hayEmpleadoAsignado() {
		return this.empleadoAsignado != null;
	}
	
	//LISTA
	public void eliminarEmpleadoAsignado() {
		
		this.empleadoAsignado = null;
	
	}
//////////////////
	//NO ME ACUERDO QUE TIENE QUE HACER ESTE METODO
	//////////////////////////
	public void actualizarCosto(Object cantidadDias) {
		
		 double dias = (cantidadDias instanceof Number) ? ((Number) cantidadDias).doubleValue() : 0;
	     if (this.empleadoAsignado != null) {
	     this.costo = this.empleadoAsignado.cobrarPagoBase(dias);
	     }
	}
///////////////////////////////////
	//NO ME ACUERDO EL CONTEXTO DEL METODO
	/////////////////
	public double darCostoFinal() {
		
		return this.costo;
	
	}
	//LISTA
	public boolean hayRetraso() {
		return this.diasDeRetraso > 0 ;
	
	}
//yo haria: si esta pendiente pasa a activa y si esta activa a finalizada
	public void actualizarEstado() {
	    if (this.estado.equals(Estado.pendiente)) {
	        this.estado = Estado.activo;
	    } else if (this.estado.equals(Estado.activo)) {
	        this.estado = Estado.finalizado;
	    } else {
	        this.estado = Estado.finalizado; // ya está finalizado, se mantiene
	    }
	}
//	public void actualizarEstado() {
	//	
		//if(this.estado.equalsIgnoreCase("pendiente")) {
	//		this.estado = "finalizada";
	//	}else {
		//	this.estado = "pendiente";
		//}
	
//	}

	//LISTA
	public String darTitulo() {
		
		return this.titulo;
	
	}
	//LIST
	public double darCantidadDias() {
		
		return this.cantidadDias;
	
	}
	//LISTA
	public String darEstado() {
		
		return this.estado;
	
	}
	//LISTA
	public int darLegajoEmpleado() {
		
		if(this.empleadoAsignado != null) {
			return this.empleadoAsignado.darNumLegajo();
		}
		
		return -1; //O UN SYSTEM.OUT.PRINTL"NO HAY EMPLEADO"
	
	}
}
