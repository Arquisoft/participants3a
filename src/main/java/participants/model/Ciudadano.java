package participants.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "TCiudadanos")
public class Ciudadano {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String apellidos;
	
	@NotNull
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@NotNull
	private String residencia;
	
	@NotNull
	private String nacionalidad;
	
	@NotNull
	private String dni;
	
	@OneToOne(mappedBy = "ciudadano")
	@Cascade({ CascadeType.ALL })
	private Usuario usuario;
	
	Ciudadano() { }
	
	public Ciudadano(String nombre, String apellidos, String email, 
			Date fechaNacimiento, String residencia, String nacionalidad, String dni,
			Usuario usuario) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.residencia = residencia;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
		
		Association.CiudadanoUsuario.link(this, usuario);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}
	
	public String getResidencia() {
		return residencia;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
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
		Ciudadano other = (Ciudadano) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}
