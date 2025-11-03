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
	//LISTO
	public double cobrarPagoBase(double diasTrabajados) {
		return this.costoHora * 8 * diasTrabajados;
		}
	@Override
	public double cobrarPagoBase(int dias) {
		// TODO Auto-generated method stub
		return 0;
	}
}
