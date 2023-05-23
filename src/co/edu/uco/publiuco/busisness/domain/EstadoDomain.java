package co.edu.uco.publiuco.busisness.domain;


import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

import java.util.UUID;


public final class EstadoDomain {
    private UUID identificador;
    private String nombre;
    private String descripcion;
    private TipoEstadoDomain tipo;
    public static final EstadoDomain DEFAULT_OBJECT = new EstadoDomain();


    private EstadoDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setNombre(UtilText.getDefaultValue());
        setDescripcion(UtilText.getDefaultValue());
        setTipo(TipoEstadoDomain.getDefaultObject());
    }


    public EstadoDomain(UUID identificador, String nombre, TipoEstadoDomain tipo, String descripcion) {
        super();
        setIdentificador(identificador);
        setNombre(nombre);
        setTipo(tipo);
        setDescripcion(descripcion);
    }

    private final void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private final void setNombre(final String nombre) {
        this.nombre = UtilText.applyTrim(nombre);
    }

    private final void setTipo(final TipoEstadoDomain tipo) {

        this.tipo = UtilObject.getDefault(tipo, TipoEstadoDomain.getDefaultObject());
    }
    
    private final void setDescripcion(final String descripcion) {
        this.descripcion = UtilText.applyTrim(descripcion);
    }

    public final UUID getIdentificador() {
        return identificador;
    }

    public final String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
		return descripcion;
	}

    public final TipoEstadoDomain getTipo() {
        return tipo;
    }

    public static EstadoDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
