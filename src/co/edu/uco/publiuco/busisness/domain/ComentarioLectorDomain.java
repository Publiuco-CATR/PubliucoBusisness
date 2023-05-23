package co.edu.uco.publiuco.busisness.domain;

import co.edu.uco.publiuco.dto.ComentarioLectorDTO;
import co.edu.uco.publiuco.utils.UtilBoolean;
import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;
public final class ComentarioLectorDomain {
	private UUID identificador;
	private LectorDomain lector;
	private PublicacionDomain publicacion;
	private ComentarioLectorDomain comentarioPadre;
	private boolean tienePadre;
	private String contenido;
	private LocalDateTime fechaComentario;
	private EstadoDomain estado;
	public static final ComentarioLectorDomain DEFAULT_OBJECT = new ComentarioLectorDomain();


	private ComentarioLectorDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultValue());
		setLector(LectorDomain.getDefaultObject());
		setPublicacion(PublicacionDomain.getDefaultObject());
		setComentarioPadre(getDefaultObject());
		setContenido(UtilText.getDefaultValue());
		setFechaComentario(UtilDate.getDefaultValue());
		setEstado(EstadoDomain.getDefaultObject() );
		setTienePadre(UtilBoolean.getDefaultValue());
	}


	public ComentarioLectorDomain(UUID identificador, LectorDomain lector, PublicacionDomain publicacion, ComentarioLectorDomain comentarioPadre, String contenido, LocalDateTime fechaComentario, EstadoDomain estado,boolean tienePadre) {
		super();
		setIdentificador(identificador);
		setLector(lector);
		setComentarioPadre(comentarioPadre);
		setPublicacion(publicacion);
		setContenido(contenido);
		setFechaComentario(fechaComentario);
		setEstado(estado);
		setTienePadre(tienePadre);
	}

	

	public boolean tienePadre() {
		return tienePadre;
	}


	public void setTienePadre(boolean tienePadre) {
		this.tienePadre = UtilBoolean.getDefault(tienePadre);
	}


	public UUID getIdentificador() {
		return identificador;
	}

	public LectorDomain getLector() {
		return lector;
	}

	public PublicacionDomain getPublicacion() {
		return publicacion;
	}

	public ComentarioLectorDomain getComentarioPadre() {
		return comentarioPadre;
	}

	public String getCotenido() {
		return contenido;
	}

	public LocalDateTime getFechaComentario() {
		return fechaComentario;
	}

	public EstadoDomain getEstado() {
		return estado;
	}

	private void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	private void setLector(final LectorDomain lector) {
		this.lector = UtilObject.getDefault(lector, LectorDomain.getDefaultObject());
	}

	private void setPublicacion(final PublicacionDomain publicacion) {
		this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
	}

	private void setComentarioPadre(final ComentarioLectorDomain comentarioPadre) {
		if(tienePadre()) {
			this.comentarioPadre = UtilObject.getDefault(comentarioPadre, getDefaultObject());
		}else {
			this.comentarioPadre = (ComentarioLectorDomain) UtilObject.getNullValue();
		}	
	}

	private void setEstado(final EstadoDomain estado) {
		this.estado = estado;
	}

	private void setContenido(final String contenido) {
		this.contenido = contenido;
	}

	private void setFechaComentario(final LocalDateTime fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	public static ComentarioLectorDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
}