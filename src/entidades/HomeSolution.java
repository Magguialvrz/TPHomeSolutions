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
	int proximoProyecto =1;
	//LISTA
    public void agregarProyecto(Proyecto proyecto) {
        if (proyecto != null) {
            int idProyecto = proyecto.darIdentificacion();
            Proyectos.put(idProyecto, proyecto);
            System.out.println("Proyecto agregado con éxito");
        } else {
            System.out.println("Proyecto nulo, no se pudo agregar");
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

	//creamos para registrar empleados
		private int generarLegajo() {
		    return proximoLegajo++; // devuelve el siguiente legajo y lo incrementa
		}
		
	@Override
	public void registrarEmpleado(String nombre, double valor) throws IllegalArgumentException {
	    int legajo = generarLegajo(); // legajo automático
	    EmpleadoContratado e = new EmpleadoContratado();
	    e.crearEmpleadoContratado(nombre, legajo, valor);
	    
	    // Agregarlo a la colección de empleados del sistema
	    Empleados.put(legajo, e); 
	}

	@Override
	public void registrarEmpleado(String nombre, double valor, String categoria) throws IllegalArgumentException {
		int legajo = generarLegajo(); 
		    EmpleadoDePlanta e = new EmpleadoDePlanta();
		    e.crearEmpleadoPlanta(nombre, legajo, valor, categoria);
		    
		    Empleados.put(legajo, e);
		}
		
	/////////////////MAGUI////////////
///////////LISTA
	@Override
	public void registrarProyecto(String[] titulos, String[] descripcion, double[] dias, String domicilio,
			String[] cliente, String inicio, String fin) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (titulos == null || descripcion == null || dias == null) {
	        throw new IllegalArgumentException("Los datos de las tareas no pueden ser nulos");
	    }
		//Tienen que ser iguales porque sino me faltarian datos
	    if (titulos.length != descripcion.length || titulos.length != dias.length) {
	        throw new IllegalArgumentException("Los arrays de títulos, descripciones y días deben tener la misma longitud");
	    }
	    //para crear al cliente necesito, nombre, numero y email por lo que necesito un array de tres elementos.
	    if (cliente == null || cliente.length < 3) {
	        throw new IllegalArgumentException("Los datos del cliente son incompletos");
	    }
	    //pasamos las fechas a estilo de fecha
	    LocalDate fechaInicio = LocalDate.parse(inicio);
	    LocalDate fechaFin = LocalDate.parse(fin);
	    //irep del cliente
	    //sus paarametros no nulos
	    if (cliente == null || cliente.length < 3
	            || cliente[0].isEmpty()
	            || cliente[1].isEmpty()
	            || cliente[2].isEmpty()) {
	        throw new IllegalArgumentException("Datos del cliente incompletos: nombre, teléfono y email son obligatorios");
	    }

	    int telefono;
	    try {
	        telefono = Integer.parseInt(cliente[1]);
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("El teléfono del cliente debe ser un número válido");
	    }
	    //creamos al cliente
	    Cliente nuevoCliente = new Cliente();
	    nuevoCliente.crearCliente(cliente[0], Integer.parseInt(cliente[1]), cliente[2]);
	    //en el primer dato traermos el nombre, en el otro el telefono y en el ultimo el email. Son los datos que necesita el constructor.
	    
	    //creamos el id del proyecto, va a ser incremental
	    int numeroProyecto = generarIdProyecto();
	    
	    Proyecto nuevoProyecto = new Proyecto(); //lo creamos al proyecto
	    nuevoProyecto.crear(numeroProyecto, fechaInicio, nuevoCliente, null); //inicia con cero tareas. ahora las agregamos.

	    nuevoProyecto.agregarDireccionVivienda(domicilio); //guardamos el domicilio del proyecto.
	    //creamos y registramos tareas, recorriendo el array de tareas.
	    for (int i = 0; i < titulos.length; i++) {
	        Tarea tarea = new Tarea(titulos[i], descripcion[i], dias[i]);
	        nuevoProyecto.registrarTarea(tarea);
	    }
	    agregarProyecto(nuevoProyecto); //lo agregamos al diccionario proyectos

	}
	private int generarIdProyecto() {
		return proximoProyecto++; // devuelve el siguiente numero de id y lo incrementa }
	}
//////////////////LISTA
	@Override
	public void asignarResponsableEnTarea(Integer numero, String titulo) throws Exception {
		 Proyecto proyecto = buscarProyecto(numero); // busca el proyecto dado su id
		    if (proyecto == null) {
		        throw new Exception("No se encontró un proyecto con ID " + numero);
		    }

		    // Verificar si el proyecto está finalizado
		    if (proyecto.estaFinalizado()) {
		        throw new Exception("El proyecto con ID " + numero + " ya está finalizado. No se pueden asignar tareas.");
		    }

		    Tarea tarea = proyecto.buscarTarea(titulo);
		    if (tarea == null) {
		        throw new Exception("No se encontró la tarea con título \"" + titulo + "\" en el proyecto " + numero);
		    }

		    if (tarea.tieneEmpleado()) {
		        throw new Exception("La tarea \"" + titulo + "\" ya tiene un empleado asignado.");
		    }

		    // Buscar un empleado disponible
		    for (Empleado e : Empleados.values()) {
		        if (!e.estaAsignado()) {
		            tarea.asignarEmpleado(e);
		            e.actualizarEstado(); // lo marca como ocupado
		            System.out.println("Empleado " + e.darNumLegajo() + " asignado a la tarea \"" + titulo + "\" del proyecto " + numero);
		            return;
		        }
		    }
		    // Si ningún empleado está disponible
		    throw new Exception("No hay empleados disponibles para asignar a la tarea \"" + titulo + "\".");
		}		
	

	@Override
	public void asignarResponsableMenosRetraso(Integer numero, String titulo) throws Exception {
			Proyecto proyecto = buscarProyecto(numero);
			 if (proyecto == null) {
			        throw new Exception("No se encontró un proyecto con ID " + numero);
			    }
			 if (proyecto.estaFinalizado()) {
			        throw new Exception("El proyecto: " + numero + "esta finalizado");
			 }
			 Tarea tarea = proyecto.buscarTarea(titulo);
			 if (tarea == null) {
			        throw new Exception("No se encontró la tarea con título \"" + titulo + "\" en el proyecto " + numero);
			    }
			 if (tarea.tieneEmpleado()) {
			        throw new Exception("La tarea" + titulo + "ya tiene empleado asignado");
			 }
			 Empleado mejorEmpleado = null;  //empleado del tipo null
			 //vamos a recorrer los empleados tomando como referencia al primero
			 for (Empleado emp : Empleados.values()) {
				    if (mejorEmpleado == null) {
				        mejorEmpleado = emp; // el primer empleado será nuestra referencia
				    }

				    if (!emp.tuvoRetraso()) {
				        mejorEmpleado = emp; // no tiene retrasos
				        break;            // ponemos break para cortar el for, no hace falta seguir buscando, encontramos el primero sin retraso
				    }
				    // si todos tienen retrasos, nos quedamos con el que tenga menos, vamos comparando todos los empleados con el primero, si hay uno que tenga menos lo asigno como nuevo mejorEmpleado
				    if (emp.darCantidadRetrasos() < mejorEmpleado.darCantidadRetrasos()) {
				        mejorEmpleado = emp;
				    }
				}
			 tarea.asignarEmpleado(mejorEmpleado); //lo asigna
			 mejorEmpleado.actualizarEstado(); //pone en ocupado al empleado
	}

	@Override
	public void registrarRetrasoEnTarea(Integer numero, String titulo, double cantidadDias)
			throws IllegalArgumentException {
		//IREP
			if (numero == null || titulo == null || titulo.isEmpty() || cantidadDias <= 0) {
			       throw new IllegalArgumentException("Parámetros inválidos para registrar el retraso.");
			   }
			    Proyecto proyecto = buscarProyecto(numero);
			    if (proyecto == null) {
			        throw new IllegalArgumentException("No existe un proyecto con número: " + numero);
			    }
			    Tarea tarea = proyecto.buscarTarea(titulo);
			    if (tarea == null) {
			        throw new IllegalArgumentException("No se encontró la tarea con título: " + titulo);
			    }
			    // Si todo está bien, se aplica el retraso en tareaa
			    tarea.actualizarDiasDeRetraso(cantidadDias);
			    proyecto.actualizarFechaRealFin(cantidadDias);		
	}
//LISTO////////////////////////////////////////////
	@Override
	public void agregarTareaEnProyecto(Integer numero, String titulo, String descripcion, double dias)
			throws IllegalArgumentException {
		 Proyecto proyecto = buscarProyecto(numero);
		    if (proyecto == null) {
		        throw new IllegalArgumentException("No existe un proyecto con número: " + numero);
		    }		
		    Tarea tarea = new Tarea(titulo, descripcion, dias); //creamos la tarea
		    
		    proyecto.registrarTarea(tarea); //la agregamos al proyecto
		    		}
	///////////////////LISTA
	///////////////////LISTA

	@Override
	public void finalizarTarea(Integer numero, String titulo) throws Exception {
		    
		    Proyecto proyecto = buscarProyecto(numero); // Buscamos el proyecto
		    if (proyecto == null) {
		        throw new IllegalArgumentException("No existe un proyecto con número: " + numero);
		    }

		   
		    Tarea tarea = proyecto.buscarTarea(titulo); // Buscamos la tarea en el proyecto
		    if (tarea == null || tarea.darEstado()==Estado.finalizado) {
		        throw new IllegalArgumentException("No existe una tarea con título: " + titulo + "o se encuentra finalizada");
		    }
		    tarea.actualizarEstadoProyecto(Estado.finalizado);
		}		
	///////////////////LISTA

	///////////////////LISTA

	@Override
	public void finalizarProyecto(Integer numero, String fin) throws IllegalArgumentException {
	    Proyecto proyecto = buscarProyecto(numero); // Buscamos el proyecto
	    if (proyecto == null) {
	        throw new IllegalArgumentException("No existe un proyecto con número: " + numero);
	    }
	    if (proyecto.estaFinalizado()) {
	        throw new IllegalArgumentException("El proyecto" + numero + "se encuentra finalizado");
	    }
	    proyecto.actualizarEstadoProyecto(Estado.finalizado);
	}
	///////////////////LISTA
	///////////////////LISTA

	@Override
	public void reasignarEmpleadoEnProyecto(Integer numero, Integer legajo, String titulo) throws Exception {
	    Proyecto proyecto = buscarProyecto(numero); // Buscamos el proyecto
	    if (proyecto == null) {
	        throw new IllegalArgumentException("No existe un proyecto con número: " + numero);
	    }
	    Tarea tarea = proyecto.buscarTarea(titulo); // Buscamos la tarea en el proyecto
	    
	    if (tarea == null) {
	        throw new IllegalArgumentException("No existe una tarea con título: " + titulo);
	    }
	    
	    Empleado empleadoAnterior = tarea.darEmpleadoAsignado();
	    if (empleadoAnterior != null) {
	    	empleadoAnterior.actualizarEstado(); // cambia a libre
            tarea.eliminarEmpleadoAsignado();  //lo borraa como responsable
	    }
           asignarResponsableEnTarea(numero, titulo);  //lo asigna
           Empleado nuevoEmpleado = tarea.darEmpleadoAsignado();
           
   	    if (nuevoEmpleado != null) {
   	        System.out.println("Empleado " + nuevoEmpleado.darNumLegajo() + 
   	            " asignado a la tarea \"" + titulo + "\" del proyecto " + numero);
   	    } else {
   	        throw new IllegalStateException("No hay empleados disponibles para reasignar la tarea \"" + titulo + "\".");
   	    }
   	}
	
	///////////////////LISTA

	@Override
	
	public void reasignarEmpleadoConMenosRetraso(Integer numero, String titulo) throws Exception {
	    Proyecto proyecto = buscarProyecto(numero);
	    if (proyecto == null) {
	        throw new IllegalArgumentException("No existe un proyecto con número: " + numero);
	    }

	    Tarea tarea = proyecto.buscarTarea(titulo);
	    if (tarea == null) {
	        throw new IllegalArgumentException("No existe una tarea con título: " + titulo);
	    }

	    Empleado empleadoAnterior = tarea.darEmpleadoAsignado();

	    if (empleadoAnterior != null) {
	        // Liberamos al empleado anterior
	        empleadoAnterior.actualizarEstado(); // cambia a libre
	        tarea.eliminarEmpleadoAsignado();
	    }

	    // Asignamos al empleado con menos retrasos
	    asignarResponsableMenosRetraso(numero, titulo);

	    Empleado nuevoEmpleado = tarea.darEmpleadoAsignado();
	    if (nuevoEmpleado != null) {
	        System.out.println("Empleado " + nuevoEmpleado.darNumLegajo() + 
	            " asignado a la tarea \"" + titulo + "\" del proyecto " + numero);
	    } else {
	        throw new IllegalStateException("No hay empleados disponibles para reasignar la tarea \"" + titulo + "\".");
	    }
	}
	
	///////////////////LISTA

	@Override
	public double costoProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return 0;
	}
	///////////////////LISTA

	@Override
	public boolean estaFinalizado(Integer numero) {
		// TODO Auto-generated method stub
	    Proyecto proyecto = Proyectos.get(numero);

	    if (proyecto != null) {
	        return proyecto.darEstado().equals(Estado.finalizado);
	    }
		return false;
	}
	///////////////////LISTA
	///////////////////LISTA

	@Override
	public int consultarCantidadRetrasosEmpleado(Integer legajo) {
		Empleado empleado = Empleados.get(legajo);

	    if (empleado == null) {
	    	  throw new IllegalStateException("Empleado no encontrado con legajo: " + legajo);
	    } else {
	        return empleado.darCantidadRetrasos(); //devuelve los retrasos del empleado 
	    }
		
	}
	///////////////////LISTA

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