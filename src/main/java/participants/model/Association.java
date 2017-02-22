package participants.model;

public class Association {
	public static class CiudadanoUsuario {
		public static void link(Ciudadano ciudadano, Usuario usuario) {
			ciudadano.setUsuario(usuario);
			usuario.setCiudadano(ciudadano);
		}
	}
}
