package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.LectorDomain;
import co.edu.uco.publiuco.dto.LectorDTO;
import co.edu.uco.publiuco.entities.LectorEntity;

public final class LectorAssembler implements Assembler<LectorDomain,LectorDTO, LectorEntity> {
    public static final LectorAssembler INSTANCE = new LectorAssembler();

    private LectorAssembler(){
        super();
    }
    @Override
    public LectorDTO toDTOFromDomain(LectorDomain domain) {
        return LectorDTO.create().setIdentificador(domain.getIdentificador()).setDatosPersona(PersonaAssembler.getInstance().toDTOFromDomain(domain.getDatosPersona()))
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public LectorDomain toDomainFromDTO(LectorDTO dto) {
        return new LectorDomain(dto.getIdentificador(),PersonaAssembler.getInstance().toDomainFromDTO(dto.getDatosPersona()),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public LectorEntity toEntityFromDomain(LectorDomain domain) {
        return new LectorEntity(domain.getIdentificador(),PersonaAssembler.getInstance().toEntityFromDomain(domain.getDatosPersona()),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public LectorDomain toDomainFromEntity(LectorEntity entity) {
        return new LectorDomain(entity.getIdentificador(),PersonaAssembler.getInstance().toDomainFromEntity(entity.getDatosPersona()), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
    
    public static LectorAssembler getInstance() { 
    	return INSTANCE; 
    	}
	@Override
	public List<LectorDomain> toDomainFromEntityList(List<LectorEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();	
	}
	@Override
	public List<LectorDTO> toDTOFromDomainList(List<LectorDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

}
