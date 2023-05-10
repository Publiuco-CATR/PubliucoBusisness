package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.TipoRevisionDomain;
import co.edu.uco.publiuco.dto.TipoRevisionDTO;
import co.edu.uco.publiuco.entities.TipoRevisionEntity;

public final class TipoRevisionAssembler implements Assembler<TipoRevisionDomain, TipoRevisionDTO, TipoRevisionEntity> {
    public static final TipoRevisionAssembler INSTANCE = new TipoRevisionAssembler();

    private TipoRevisionAssembler(){
        super();
    }
    @Override
    public TipoRevisionDTO toDTOFromDomain(TipoRevisionDomain domain) {
        return TipoRevisionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoRevisionDomain toDomainFromDTO(TipoRevisionDTO dto) {
        return new TipoRevisionDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoRevisionEntity toEntityFromDomain(TipoRevisionDomain domain) {
        return new TipoRevisionEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public TipoRevisionDomain toDomainFromEntity(TipoRevisionEntity entity) {
        return new TipoRevisionDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }
    
    public static TipoRevisionAssembler getInstance() { 
    	return INSTANCE; 
    }
	@Override
	public List<TipoRevisionDomain> toDomainFromEntityList(List<TipoRevisionEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<TipoRevisionDTO> toDTOFromDomainList(List<TipoRevisionDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
