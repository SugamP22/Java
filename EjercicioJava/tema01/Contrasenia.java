package tema01;

//crear contraseña de cuatro cifras 
public class Contrasenia {
	public static void main(String[] args) {
		//para  que me dan numeros de 4 cifras ni menor ni mayor
		int contrasenia = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;
		System.out.println("La contraseña generado por sistema es: " + contrasenia);
	}
}
