package entidades;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


public class HomeSolution implements IHomeSolution {
	private HashMap <Integer, Proyecto> Proyectos;
	private HashMap <Integer, Empleado> Empleados;
	private int proximoLegajo = 1;
	
	//LISTA
	public void agregarProyecto(int idProyecto) {
        Proyecto proyecto = buscarProyecto(idProyecto); //busca el proyecto dado su id

        if (proyecto != null) {
            Proyectos.put(idProyecto, proyecto);
            System.out.println("Proyecto agregado con éxito");
        } else
            System.out.println("No se encontró un proyecto con ID ");
        }
    }
	//LISTO
	public LocalDate fechaFinalizacionProyecto(int idProyecto, LocalDate fecha) {
		
			Proyecto proyecto = buscarProyecto(idProyecto); //busca el proyecto dado su id
			
        if (proyecto != null) {
        	return proyecto.darFechaRealFin();         // Si existe, devolver la fecha real de finalización

        } 
        else { 
        	System.out.println("No se encontró un proyecto con ID ");
        	return  null;
	}

	}
	

	public void asignarEmpleadoATarea(int idProyecto, String tituloTarea) {
		Proyecto proyecto = buscarProyecto(idProyecto); //busca el proyecto dado su id
		if (proyecto == null) {
	        System.out.println("No se encontró un proyecto con ID " + idProyecto);
	        return;
	    }
		Tarea tarea= proyecto.buscarTarea(tituloTarea);
		if (tarea == null) {
	        System.out.println("No se encontró la tarea con título " + tituloTarea);
	        return;
	    }

	    if (tarea.tieneEmpleado()) {
	        System.out.println("La tarea ya tiene un empleado asignado");
	        return;
	    }

	    // Buscar un empleado disponible
	    for (Empleado e : Empleados.values()) {
	        if (!e.estaAsignado()) { // si el empleado no esta asignado, lo asigna a la tarea
	            tarea.asignarEmpleado(e);
	            e.actualizarEstado(); // lo marca como ocupado
	            System.out.println("Empleado " + e.darNumLegajo() + " asignado a la tarea " + tituloTarea);
	            return;
	        }
	    }

	    System.out.println("No hay empleados disponibles para asignar a la tarea " + tituloTarea);
	}
	
	private int generarLegajo() {
	    return proximoLegajo++; // devuelve el siguiente legajo y lo incrementa
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
	        // Suponemos que la búsqueda se hace en la colección de proyectos
	        return proyectos.get(idProyecto);
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
	    int legajo = generarLegajo(); // legajo automático
	    EmpleadoContratado e = new EmpleadoContratado();
	    e.crearEmpleadoContratado(nombre, legajo, valor);
	    
	    // Agregarlo a la colección de empleados del sistema
	    Empleados.put(legajo, e); // suponiendo que usas un HashMap<Integer, Empleado>
	}

	@Override
	public void registrarEmpleado(String nombre, double valor, String categoria) throws IllegalArgumentException {
		int legajo = generarLegajo(); 
		    EmpleadoDePlanta e = new EmpleadoDePlanta();
		    e.crearEmpleadoPlanta(nombre, legajo, valor, categoria);
		    
		    Empleados.put(legajo, e);
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