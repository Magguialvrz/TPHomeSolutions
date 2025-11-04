package entidades;

public class EmpleadoContratado extends Empleado {
	
	private double costoHora;
	//LISTO
	public void crearEmpleadoContratado(String nombre, int legajo, double costoHora) {
		super.crearEmpleado(nombre, legajo);
		this.costoHora = costoHora;
	}
	//LISTO
	public double darCosto() {
		return this.costoHora;
	}
	
	@Override
	public double cobrarPagoBase(double dias) {
		return this.costoHora * 8 * dias;
	}
}
