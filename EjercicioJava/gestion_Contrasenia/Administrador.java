package gestion_Contrasenia;

import java.util.ArrayList;

public class Administrador extends Usuario {
	private static final String CONTRASEÑIA_PREDETERMINADO = "Contraseña123$$";

	Administrador(String UsuarioNombre, String contrasenia) {
		super(UsuarioNombre, contrasenia);

	}

	public int reiniciarContrasenia(ArrayList<Usuario> usuario, String nombre) {
		if (usuario.isEmpty()) {
			return 1;
		} else {
			for (Usuario u : usuario) {
				if (u.getUsuarioNombre().equalsIgnoreCase(nombre)) {
					u.setContrasenia(CONTRASEÑIA_PREDETERMINADO);
					return 2;

				}
			
			}
		}
		return 3;
	}

}
