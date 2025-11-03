package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.List;


public class HomeSolution implements IHomeSolution {
    private HashMap<Integer, Proyecto> Proyectos = new HashMap<>();
    private HashMap<Integer, Empleado> Empleados = new HashMap<>();
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
		
	    Proyecto proyecto = Proyectos.get(idProyecto); // buscamos el proyecto en el HashMap
	    if (proyecto != null) { // si existe
	        return Estado.finalizado.equals(proyecto.darEstado()); // comparamos el estado
	    }
	    return false; // si no existe el proyecto, devolvemos false
		
	
	}
	//FUNCIONA
	public void reasignarEmpleadoEnProyecto(int idProyecto, int legajoEmpleado, String tituloTarea) {
		
		  Proyecto proyecto = Proyectos.get(idProyecto);
		    if (proyecto == null) {
		        System.out.println("Proyecto no encontrado.");
		        return;
		    }

		    Tarea tarea = proyecto.buscarTarea(tituloTarea);
		    if (tarea == null) {
		        System.out.println("Tarea no encontrada en el proyecto.");
		        return;
		    }

		    Empleado empleadoAnterior = null;
		    if (tarea.tieneEmpleado()) {
		        empleadoAnterior = Empleados.get(legajoEmpleado);
		        if (empleadoAnterior != null) {
		            // Eliminar empleado de la tarea y actualizar estado
		            tarea.eliminarEmpleadoAsignado();
		            empleadoAnterior.actualizarEstado(); // pasa de asignado a libre
		        }
		    }

		    // Buscar un nuevo empleado disponible distinto al anterior
		    Empleado nuevoEmpleado = null;
		    for (Empleado e : Empleados.values()) {
		        if (!e.estaAsignado() && (empleadoAnterior == null || e.darNumLegajo() != empleadoAnterior.darNumLegajo())) {
		            nuevoEmpleado = e;
		            break;
		        }
		    }

		    if (nuevoEmpleado != null) {
		        tarea.asignarEmpleado(nuevoEmpleado);
		        nuevoEmpleado.actualizarEstado(); // ahora está asignado
		    } else {
		        // No hay empleado disponible: marcar tarea como pendiente
		        tarea.actualizarEstadoProyecto(Estado.pendiente);
		    }
		}
	
	
	//FUNCIONA
	public List<Proyecto> proyectosNoFinalizados() { // importe las libreriass array y list
		// vi en la firma que 
		
	    List<Proyecto> lista = new ArrayList<>();
	    
	    for (Proyecto proyecto : Proyectos.values()) {
	        if (!proyecto.estaFinalizado()) {  // verificamos que no esté finalizado
	            lista.add(proyecto);
	        }
	    }
	    
	    return lista;
		
	}
	
	//FUNCIONA
	@Override
	public List<Tupla<Integer,String>> proyectosPendientes() { // me fije en la firma de listaProyectos, pero sigue apareciendo el error
	    List<Tupla<Integer,String>> lista = new ArrayList<>();

	    for (Proyecto proyecto : Proyectos.values()) {
	        if (proyecto.estaPendiente()) {
	            lista.add(new Tupla<>(proyecto.darIdentificacion(), proyecto.darEstado()));
	        }
	    }

	    return lista;
	}
	///VER
	 public Proyecto buscarProyecto(int idProyecto) {
	        // Suponemos que la búsqueda se hace en la colección de proyectos
	        return Proyectos.get(idProyecto);
    }

	//VER
	public Empleado buscarEmpleado(int numLegajo) { // dado un numero de legajo podemos encontrar un empleado
	
		return Empleados.get(numLegajo);
		
	
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
	
	@Override
	public List<Tupla<Integer,String>> proyectosFinalizados() {
		
	    List<Tupla<Integer,String>> lista = new ArrayList<>();

	    for (Proyecto proyecto : Proyectos.values()) {
	        if (proyecto.estaFinalizado()) {
	            lista.add(new Tupla<>(proyecto.darIdentificacion(), proyecto.darEstado()));
	        }
	    }

	    return lista;
	
	}
	
	@Override
	public List<Tupla<Integer,String>> proyectosActivos() {
		
		List<Tupla<Integer,String>> lista = new ArrayList<>();
		
		for(Proyecto proyecto : Proyectos.values()) {
			if(proyecto.estaActivo()) {
				lista.add(new Tupla<>(proyecto.darIdentificacion(),proyecto.darEstado()));
			}
			
		}
		
		return lista;
	
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
		
	/////////////////MAGUI////////////

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
		//IREP
			if (numero == null || titulo == null || titulo.isEmpty() || cantidadDias <= 0) {
			       throw new IllegalArgumentException("Parámetros inválidos para registrar el retraso.");
			   }

			    Proyecto proyecto = Proyectos.get(numero);
			    if (proyecto == null) {
			        throw new IllegalArgumentException("No existe un proyecto con número: " + numero);
			    }

			    Tarea tarea = proyecto.buscarTarea(titulo);
			    if (tarea == null) {
			        throw new IllegalArgumentException("No se encontró la tarea con título: " + titulo);
			    }

			    // Si todo está bien, se aplica el retraso
			    tarea.actualizarDiasDeRetraso(cantidadDias);
			    proyecto.actualizarFechaRealFin(cantidadDias);		
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
	    Proyecto proyecto = Proyectos.get(numero);

	    if (proyecto != null) {
	        return proyecto.darEstado().equals(Estado.finalizado);
	    }
		return false;
	}

	@Override
	public int consultarCantidadRetrasosEmpleado(Integer legajo) {
		// TODO Auto-generated method stub
		Empleado empleado = Empleados.get(legajo);

	    if (empleado == null) {
	        System.out.println("Empleado no encontrado con legajo: " + legajo);
	        return 0; // devuelve 0 si no existe el empleado , dejamos el return porque ya venia con el metodo
	    } else {
	        return empleado.darCantidadRetrasos(); //devuelve los retrasos del empleado 
	    }
		
	}

	@Override
	public List<Tupla<Integer, String>> empleadosAsignadosAProyecto(Integer numero) {
		// TODO Auto-generated method stub
	    List<Tupla<Integer, String>> lista = new ArrayList<>();
	    Proyecto proyecto = Proyectos.get(numero);

	    if (proyecto == null) {
	        System.out.println("Proyecto no encontrado con ID: " + numero);
	        return lista; // devuelve lista vacía
	    }

	    for (Tarea tarea : proyecto.darTareas().values()) {
	        if (tarea.tieneEmpleado()) {
	            Empleado empleado = tarea.darEmpleadoAsignado(); //  nuevo metodo en Clase tarea 
	            if (empleado != null) {
	                lista.add(new Tupla<>(empleado.darNumLegajo(), empleado.darNombre()));
	            }
	        }
	    }
	    
	    if (lista.isEmpty()) {
	        return null; // este return null ya venia con el metodo, lo deje por si no hay empleado asignado 
	    }
	    
	    return lista; // y aca devolvemos la lista de empleados asignados en caso de que tenga
		 
	}

	@Override
	public Object[] tareasProyectoNoAsignadas(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] tareasDeUnProyecto(Integer numero) { // calculo que tiene un error la descripcion 
		
		// TODO Auto-generated method stub
		
		Proyecto proyecto = Proyectos.get(numero);
		
		if(proyecto == null) {
			System.out.println("Proyecto no encontrado con ID" + numero);
			return null;
		}
	  

			if (proyecto.darTareas().isEmpty()) {
				return null; // no hay tareas asignadas
				
			}
    

				// Creamos un array de objetos con todas las tareas
				Object[] tareasArray = proyecto.darTareas().values().toArray();
					return tareasArray;
			}
		
	

	@Override
	public String consultarDomicilioProyecto(Integer numero) { // le damos el numero
		// TODO Auto-generated method stub
		
		Proyecto proyecto = Proyectos.get(numero); 
		
		if(proyecto != null) {
			return proyecto.darDireccion(); // retorna la direccion de un proyecto
		}else {
			return null;
		}
	}

	@Override
	public boolean tieneRestrasos(Integer legajo) {
		// TODO Auto-generated method stub
		
		Empleado empleado = Empleados.get(legajo);
		
		if(empleado == null) {
			System.out.println("el empleado no existe"+legajo);
			
		}
		return empleado.tuvoRetraso(); // esta ya nos da true o false en caso de que tenga o no retraso 
		
	}

	@Override
	public List<Tupla<Integer, String>> empleados() {
		// TODO Auto-generated method stub
		
		   if (Empleados.isEmpty()) {
		        return null; // no hay empleados registrados // uso el null que ya estaba en el metodo
		    }

	    List<Tupla<Integer, String>> lista = new ArrayList<>();

	    for (Empleado empleado : Empleados.values()) {
	        lista.add(new Tupla<>(empleado.darNumLegajo(), empleado.darNombre()));
	    }

	    return lista;
	
	}

	@Override
	public String consultarProyecto(Integer numero) { // cielos ta dificil
		// TODO Auto-generated method stub
		
		   Proyecto proyecto = Proyectos.get(numero);

		    if (proyecto == null) {
		        System.out.println("Proyecto no encontrado con ID: " + numero);
		        return null; // proyecto no existe
		    }

		    return proyecto.toString();
		
		//return null;
	}
	//BRAIAN///////////////
}