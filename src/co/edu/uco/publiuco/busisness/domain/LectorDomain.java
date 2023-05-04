package co.edu.uco.publiuco.busisness.domain;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

import java.util.UUID;

public class LectorDomain {
    private UUID identificador;
    private PersonaDomain datosPersona;
    private EstadoDomain estado;
    public static LectorDomain DEFAULT_OBJECT= new LectorDomain();

    private LectorDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setDatosPersona(PersonaDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public LectorDomain(UUID identificador, PersonaDomain datosPersona, EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setDatosPersona(datosPersona);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PersonaDomain getDatosPersona() {
        return datosPersona;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public LectorDomain setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
        return this;
    }

    private void setDatosPersona(PersonaDomain datosPersona) {
        this.datosPersona = UtilObject.getDefault(datosPersona, PersonaDomain.getDefaultObject());
    }

    private void setEstado(EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static LectorDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
