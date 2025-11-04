package entidades;


public class Cliente {
	
	
	private String nombre;
	private String email;
	private int telefono;
	
	public void crearCliente(String nombre, String email, int telefono) {
		
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
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
