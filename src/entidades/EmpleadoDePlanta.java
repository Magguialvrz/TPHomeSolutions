package entidades;

public class EmpleadoDePlanta extends Empleado {
	
	
	private double valorPorDia;
	private String categoria;
	
	public void crearEmpleadoPlanta(String nombre, int legajo, double valorPorDia, String categoria) {		
		super.crearEmpleado(nombre, legajo);
		this.valorPorDia = valorPorDia;
		this.categoria = categoria;
	}
	
	public double darCosto() {
		return this.valorPorDia;
	}
	
	public double cobrarPagoBase(int diasTrabajados) {
		
		int diasRedondeados = (int) Math.ceil(diasTrabajados);
		double base = this.valorPorDia * diasRedondeados;
        double adicional = base * 0.02;
        return base + adicional;
	
	}
	
	public double cobrarSinAdicional(double diasTrabajados) { // lo cambie de void a double 
		int diasRedondeados = (int) Math.ceil(diasTrabajados);
		return this.valorPorDia * diasRedondeados;
	}
}
