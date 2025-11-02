
public class Cliente {
	
	
	private String nombre;
	private String email;
	private int telefono;
	
	public void crearCliente(String nombre, int telefono, String email) {
		
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	// VER SI SE NECESITAN LAS DE ABAJO
		public String darNombre() {
		
			return this.nombre;
		
	}
	   public String darEmail() {
	        return this.email;
	    }

	    public int darTelefono() {
	        return this.telefono;
	    }

}
