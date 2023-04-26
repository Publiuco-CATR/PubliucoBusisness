package co.edu.uco.publiuco.busisness.domain;

import co.edu.uco.publiuco.utils.UtilText;

import java.util.UUID;

public class TipoEstadoDomain {
    private UUID identificador;
    private String nombre;


    public TipoEstadoDomain(UUID identificador, String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }



    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombre(String nombre) {
        this.nombre = UtilText.applyTrim(nombre);
    }




}

