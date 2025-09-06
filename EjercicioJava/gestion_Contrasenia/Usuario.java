package gestion_Contrasenia;

import java.util.ArrayList;

public class Usuario {
	private String usuarioNombre;
	private String contrasenia;
	private ArrayList<String> almacen;

	Usuario(String UsuarioNombre, String contrasenia) {
		this.usuarioNombre = UsuarioNombre;
		this.almacen = new ArrayList<String>();
		setContrasenia(contrasenia);

	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		if (!validarContraseña(contrasenia)) {
			throw new IllegalArgumentException(
					"\n1. Debe Incluir al menos Una Mayuscaula\n2. Debe tener un special caracter\n3. Debe tener al menos 8 caracteres");

		}
		if (almacen.contains(contrasenia)) {
			throw new IllegalArgumentException("No puedes Usar los antigos Contraseñas");
		}
		this.contrasenia = contrasenia;
		if (almacen.size() < 3) {
			almacen.add(contrasenia);
		} else {
			almacen.remove(0);
			almacen.add(contrasenia);
		}

	}

	public boolean validarContraseña(String contraseña) {
		return contraseña.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^$&%€.]).{8,}$");
	}

	public boolean cambiarContrasenia(String contrasenia) {
			setContrasenia(contrasenia);
			return true;
		
	}
	
	
	

	@Override
	public String toString() {
		return "Usuario [usuarioNombre=" + usuarioNombre + ", contrasenia=" + contrasenia + ", almacen=" + almacen
				+ "]";
	}

}
