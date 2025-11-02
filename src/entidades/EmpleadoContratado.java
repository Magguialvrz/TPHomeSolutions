public class EmpleadoContratado extends Empleado {
	
	private double costoHora;
	
	public void crearEmpleadoContratado(String nombre, int legajo, double costoHora) {
		
		super.crearEmpleado(nombre, legajo);
		this.costoHora = costoHora;
	}
	
	public double darCosto() {
		return this.costoHora;
	}
	
	public double cobrarPagoBase(int diasTrabajados) {
		return this.costoHora * 8 * diasTrabajados;
		}
}
