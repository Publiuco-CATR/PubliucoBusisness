package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.RespuestaDomain;
import co.edu.uco.publiuco.dto.RespuestaDTO;
import co.edu.uco.publiuco.entities.RespuestaEntity;

public final class RespuestaAssembler implements Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity> {
    public static final RespuestaAssembler INSTANCE = new RespuestaAssembler();

    private RespuestaAssembler(){
        super();
    }
    @Override
    public RespuestaDTO toDTOFromDomain(RespuestaDomain domain) {
        return RespuestaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public RespuestaDomain toDomainFromDTO(RespuestaDTO dto) {
        return new RespuestaDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public RespuestaEntity toEntityFromDomain(RespuestaDomain domain) {
        return new RespuestaEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public RespuestaDomain toDomainFromEntity(RespuestaEntity entity) {
        return new RespuestaDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }
    
    public static RespuestaAssembler getInstance() { 
    	return INSTANCE; 
    }
	@Override
	public List<RespuestaDomain> toDomainFromEntityList(List<RespuestaEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RespuestaDTO> toDTOFromDomainList(List<RespuestaDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
