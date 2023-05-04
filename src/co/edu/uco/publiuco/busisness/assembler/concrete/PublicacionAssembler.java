package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.PublicacionDomain;
import co.edu.uco.publiuco.dto.PublicacionDTO;
import co.edu.uco.publiuco.entities.PublicacionEntity;

public final class PublicacionAssembler implements Assembler<PublicacionDomain, PublicacionDTO, PublicacionEntity> {

    public static final PublicacionAssembler INSTANCE = new PublicacionAssembler();

    private PublicacionAssembler(){
        super();
    }
    @Override
    public PublicacionDTO toDTOFromDomain(PublicacionDomain domain) {
        return PublicacionDTO.create().setIdentificador(domain.getIdentificador()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setCategoria(CategoriaAssembler.getInstance().toDTOFromDomain(domain.getCategoria())).setFechaPublicacion(domain.getFechaPublicacion())
                .setVersionPublicada(VersionAssembler.getInstance().toDTOFromDomain(domain.getVersionPublicada())).setTipoAcceso(TipoAccesoAssembler.getInstance().toDTOFromDomain(domain.getTipoAcceso()));
    }

    @Override
    public PublicacionDomain toDomainFromDTO(PublicacionDTO dto) {
        return new PublicacionDomain(dto.getIdentificador(), CategoriaAssembler.getInstance().toDomainFromDTO(dto.getCategoria()), TipoAccesoAssembler.getInstance().toDomainFromDTO(dto.getTipoAcceso()), dto.getFechaPublicacion(),VersionAssembler.getInstance().toDomainFromDTO(dto.getVersionPublicada()),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public PublicacionEntity toEntityFromDomain(PublicacionDomain domain) {
        return new PublicacionEntity(domain.getIdentificador(),CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoria()), TipoAccesoAssembler.getInstance().toEntityFromDomain(domain.getTipoAcceso()),
                domain.getFechaPublicacion(),VersionAssembler.getInstance().toEntityFromDomain(domain.getVersionPublicada()), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public PublicacionDomain toDomainFromEntity(PublicacionEntity entity) {
        return new PublicacionDomain(entity.getIdentificador(),CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoria()), TipoAccesoAssembler.getInstance().toDomainFromEntity(entity.getTipoAcceso()),
                entity.getFechaPublicacion(),VersionAssembler.getInstance().toDomainFromEntity(entity.getVersionPublicada()),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
    
    public static PublicacionAssembler getInstance() { 
    	return INSTANCE; 
    }

}
