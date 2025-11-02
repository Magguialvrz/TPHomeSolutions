package entidades;

import java.time.LocalDate;
import java.util.List;


public class HomeSolution implements IHomeSolution {
	private HashMap<int, Proyecto> Proyectos;
	private HashMap<int, Empleado> Empleados;
	

	public void agregarProyecto() {
	
	}
	
	public void fechaFinalizacionProyecto(int idProyecto, LocalDate fecha) {
	
	}
	
	public void asignarEmpleadoATarea(int idProyecto, String tituloTarea) {
	
	}
	
	public void registrarEmpleado(int legajoEmpleado) {
	
	}
	
	public boolean estaFinalizado(int idProyecto) {
	
	}
	
	public void reasignarEmpleado(int legajoEmpleado, String tituloTarea, int idProyecto) {
	
	}
	
	public lista proyectosNoFinalizados() {
	
	}
	
	public lista proyectosPendientes() {
	
	}
	
	public Proyecto buscarProyecto(int idProyecto) {
	
	}
	
	public Empleado buscarEmpleado(int numLegajo) {
	
	}
	
	public void registrarRetraso(int idProyecto, String tituloTarea, double dias) {
	
	}
	
	public void asignarEmpleadoMenosRetrasos(int idProyecto, String tituloTarea) {
	
	}
	
	public void agregarTarea(int idProyecto, String tituloTarea) {
	
	}
	
	public void tareaFinalizada(int idProyecto, String tituloTarea) {
	
	}
	
	public void finalizoProyecto(int idProyecto) {
	
	}
	
	public void reasignarEmpleadoEficientemente(int legajoEmpleado, String tituloTarea, int idProyecto) {
	
	}
	
	public double costoFinalProyecto(int idProyecto) {
	
	}
	

	public list proyectosFinalizados() {
	
	}
	
	public list proyectosActivos() {
	
	}
	
	public list empleadosNoAsignados() {
	
	}
	
	public boolean empleadoTuvoRetrasos(int legajoEmpleado) {
	
	}
	
	public list empleadosEnProyecto(int idProyecto) {
	
	}
	
	public String empleadosConRetrasos() {
	
	}
	
	public void actualizarFechaProyectoSegunTarea(int idProyecto, String tituloTarea) {
	
	}
	
	public void liberarEmpleado(String tituloTarea) {
	
	}
	
	public void liberarEmpleadosDeProyecto(int idProyecto) {
	
	}

	public void registrarProyecto(int legajoEmpleado) {
		
	}

	@Override
	public void registrarEmpleado(String nombre, double valor) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarEmpleado(String nombre, double valor, String categoria) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarProyecto(String[] titulos, String[] descripcion, double[] dias, String domicilio,
			String[] cliente, String inicio, String fin) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignarResponsableEnTarea(Integer numero, String titulo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignarResponsableMenosRetraso(Integer numero, String titulo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarRetrasoEnTarea(Integer numero, String titulo, double cantidadDias)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarTareaEnProyecto(Integer numero, String titulo, String descripcion, double dias)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarTarea(Integer numero, String titulo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarProyecto(Integer numero, String fin) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reasignarEmpleadoEnProyecto(Integer numero, Integer legajo, String titulo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reasignarEmpleadoConMenosRetraso(Integer numero, String titulo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double costoProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estaFinalizado(Integer numero) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int consultarCantidadRetrasosEmpleado(Integer legajo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Tupla<Integer, String>> empleadosAsignadosAProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] tareasProyectoNoAsignadas(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] tareasDeUnProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultarDomicilioProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean tieneRestrasos(Integer legajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Tupla<Integer, String>> empleados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultarProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}
}