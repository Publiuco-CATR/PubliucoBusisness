package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.EstadoDomain;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.entities.EstadoEntity;

public final class EstadoAssembler 
	implements Assembler<EstadoDomain, EstadoDTO, EstadoEntity>{

	//TipoEstadoAssembler tipoEstadoAssembler = new TipoEstadoAssembler();
	
	@Override
	public EstadoDTO toDtoFromDomain(EstadoDomain domain) {
		return EstadoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setTipoEstado(TipoEstadoAssembler.getInstance().toDtoFromDomain(domain.getTipoEstado()));
	}

	@Override
	public EstadoDomain toDomainFromDTO(EstadoDTO dto) {
		//return new EstadoDomain(dto.getIdentificador(), dto.getNombre(), dto.getTipoEstado());
		return new EstadoDomain(dto.getIdentificador(), dto.getNombre(), TipoEstadoAssembler.getInstance().toDomainFromDTO(dto.getTipoEstado()));
	}

	@Override
	public EstadoEntity toEntityFromDomain(EstadoDomain domain) {
		// TODO Auto-generated method stub
		return new EstadoEntity(domain.getIdentificador(), domain.getNombre(), TipoEstadoAssembler.getInstance().toEntityFromDomain(domain.getTipoEstado()));
	}

	@Override
	public EstadoDomain toDomainFromEntity(EstadoEntity entity) {
		return new EstadoDomain(entity.getIdentificador(), entity.getNombre(), TipoEstadoAssembler.getInstance().toDomainFromEntity(entity.getTipoEstado()));
	}

	
	
}
