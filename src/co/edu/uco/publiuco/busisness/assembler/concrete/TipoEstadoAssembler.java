package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.TipoEstadoDomain;
import co.edu.uco.publiuco.dto.TipoEstadoDTO;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;

public final class TipoEstadoAssembler 
	implements Assembler<TipoEstadoDomain, TipoEstadoDTO, TipoEstadoEntity>{

	private static final Assembler<TipoEstadoDomain, TipoEstadoDTO, TipoEstadoEntity> INSTANCE = new TipoEstadoAssembler();
	public static final Assembler<TipoEstadoDomain, TipoEstadoDTO, TipoEstadoEntity> getInstance(){
		return INSTANCE;
	}
	
	private TipoEstadoAssembler() {
		super();
	}
	
	@Override
	public TipoEstadoDTO toDtoFromDomain(TipoEstadoDomain domain) {
		return new TipoEstadoDTO(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public TipoEstadoDomain toDomainFromDTO(TipoEstadoDTO dto) {
		return new TipoEstadoDomain(dto.getIdentificador(), dto.getNombre());
	}

	@Override
	public TipoEstadoEntity toEntityFromDomain(TipoEstadoDomain domain) {
		return new TipoEstadoEntity(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public TipoEstadoDomain toDomainFromEntity(TipoEstadoEntity entity) {
		return new TipoEstadoDomain(entity.getIdentificador(), entity.getNombre());
	}

}
