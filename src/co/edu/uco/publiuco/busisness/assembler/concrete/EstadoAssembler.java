package co.edu.uco.publiuco.busisness.assembler.concrete;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.EstadoDomain;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.entities.EstadoEntity;

public final class EstadoAssembler implements Assembler<EstadoDomain, EstadoDTO, EstadoEntity>{
	public static final EstadoAssembler INSTANCE = new EstadoAssembler();
	public static EstadoAssembler getInstance() { return INSTANCE; }
	private EstadoAssembler(){
	    super();
	}
	@Override
	public EstadoDTO toDTOFromDomain(EstadoDomain domain) {
	    return EstadoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
	            setTipo(TipoEstadoAssembler.getInstance().toDTOFromDomain(domain.getTipo()));
	}
	
	@Override
	public EstadoDomain toDomainFromDTO(EstadoDTO dto) {
	    return new EstadoDomain(dto.getIdentificador(),dto.getNombre(), TipoEstadoAssembler.getInstance().toDomainFromDTO(dto.getTipo()), dto.getDescripcion());
	}
	
	@Override
	public EstadoEntity toEntityFromDomain(EstadoDomain domain) {
	    return new EstadoEntity(domain.getIdentificador(),domain.getNombre(),TipoEstadoAssembler.getInstance().toEntityFromDomain(domain.getTipo()), domain.getDescripcion());
	}
	
	@Override
	public EstadoDomain toDomainFromEntity(EstadoEntity entity) {
	    return new EstadoDomain(entity.getIdentificador(), entity.getNombre(), TipoEstadoAssembler.getInstance().toDomainFromEntity(entity.getTipo()), entity.getDescripcion());
	}
	
	@Override
	public final List<EstadoDomain> toDomainFromEntityList(List<EstadoEntity> entityList) {
	    return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}
	
	@Override
	public List<EstadoDTO> toDTOFromDomainList(List<EstadoDomain> domainList) {
	    return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	
	}
	
}
