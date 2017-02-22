package participants.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Representa a un usuario en la base de datos
 * 
 * @author UO246008
 *
 */
@Entity
@Table(name = "TUsuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String usuario;

	@NotNull
	private String contraseña;
	
	@OneToOne
	@JoinColumn(name = "CIUDADANO_ID")
	private Ciudadano ciudadano;
	
	Usuario() {}
	
	public Usuario(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	public long getId() {
		return id;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}
