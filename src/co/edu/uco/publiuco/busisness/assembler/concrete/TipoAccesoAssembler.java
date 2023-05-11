package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.TipoAccesoDomain;
import co.edu.uco.publiuco.dto.TipoAccesoDTO;
import co.edu.uco.publiuco.entities.TipoAccesoEntity;

public final class TipoAccesoAssembler implements Assembler<TipoAccesoDomain, TipoAccesoDTO, TipoAccesoEntity> {
    public static final TipoAccesoAssembler INSTANCE = new TipoAccesoAssembler();

    private TipoAccesoAssembler(){
        super();
    }
    @Override
    public TipoAccesoDTO toDTOFromDomain(TipoAccesoDomain domain) {
        return TipoAccesoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public TipoAccesoDomain toDomainFromDTO(TipoAccesoDTO dto) {
        return new TipoAccesoDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public TipoAccesoEntity toEntityFromDomain(TipoAccesoDomain domain) {
        return new TipoAccesoEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion(), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public TipoAccesoDomain toDomainFromEntity(TipoAccesoEntity entity) {
        return new TipoAccesoDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
    
    public static TipoAccesoAssembler getInstance() { 
    	return INSTANCE; 
    }
	@Override
	public List<TipoAccesoDomain> toDomainFromEntityList(List<TipoAccesoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();	
	}
	@Override
	public List<TipoAccesoDTO> toDTOFromDomainList(List<TipoAccesoDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

}
