

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
        this.estado = "pendiente";
	
	}
	
	public double darDiasRetraso() {
		
		return this.diasDeRetraso;
	
	}
	
	public void actualizarDiasDeRetraso(double num) {
		
		this.diasDeRetraso = num;
	
	}
	
	public void modificarCantDias(double diasDeRetraso) {
	
		this.cantidadDias += diasDeRetraso;
	}
	
	public boolean hayEmpleadoAsignado() {
		
		return this.empleadoAsignado != null;
	
	}
	
	public void eliminarEmpleadoAsignado() {
		
		this.empleadoAsignado = null;
	
	}
	
	public void actualizarCosto(Object cantidadDias) {
		
		 double dias = (cantidadDias instanceof Number) ? ((Number) cantidadDias).doubleValue() : 0;
	     if (this.empleadoAsignado != null) {
	     this.costo = this.empleadoAsignado.cobrarPagoBase(dias);
	     }
	}
	
	public double darCostoFinal() {
		
		return this.costo;
	
	}
	
	public boolean hayRetraso() {
		return this.diasDeRetraso > 0 ;
	
	}
	
	public void actualizarEstado() {
		
		if(this.estado.equalsIgnoreCase("pendiente")) {
			this.estado = "finalizada";
		}else {
			this.estado = "pendiente";
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
		
		return -1;
	
	}
}
