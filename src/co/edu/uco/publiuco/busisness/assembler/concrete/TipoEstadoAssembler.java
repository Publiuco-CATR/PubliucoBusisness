package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.TipoEstadoDomain;
import co.edu.uco.publiuco.dto.TipoEstadoDTO;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;

public final class TipoEstadoAssembler implements Assembler<TipoEstadoDomain, TipoEstadoDTO, TipoEstadoEntity> {
    public static final TipoEstadoAssembler INSTANCE = new TipoEstadoAssembler();
    
    private TipoEstadoAssembler(){
        super();
    }

    @Override
    public TipoEstadoDomain toDomainFromDTO(TipoEstadoDTO dto) {
        return new TipoEstadoDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoEstadoEntity toEntityFromDomain(TipoEstadoDomain domain) {
        return new TipoEstadoEntity(domain.getIdentificador(),domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public TipoEstadoDomain toDomainFromEntity(TipoEstadoEntity entity) {
        return new TipoEstadoDomain(entity.getIdentificador(),entity.getNombre(), entity.getDescripcion());
    }
	@Override
	public TipoEstadoDTO toDTOFromDomain(TipoEstadoDomain domain) {
		return TipoEstadoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}
	
    public static TipoEstadoAssembler getInstance() { 
    	return INSTANCE; 
    }

	@Override
	public List<TipoEstadoDomain> toDomainFromEntityList(List<TipoEstadoEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoEstadoDTO> toDTOFromDomainList(List<TipoEstadoDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
