package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.RevisorDomain;
import co.edu.uco.publiuco.dto.RevisorDTO;
import co.edu.uco.publiuco.entities.RevisorEntity;

public final class RevisorAssembler implements Assembler<RevisorDomain, RevisorDTO, RevisorEntity> {
    public static final RevisorAssembler INSTANCE = new RevisorAssembler();

    private RevisorAssembler(){
        super();
    }
    @Override
    public RevisorDTO toDTOFromDomain(RevisorDomain domain) {
        return RevisorDTO.create().setIdentificador(domain.getIdentificador()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setDatosPersona(PersonaAssembler.getInstance().toDTOFromDomain(domain.getDatosPersona()));
    }

    @Override
    public RevisorDomain toDomainFromDTO(RevisorDTO dto) {
        return new RevisorDomain(dto.getIdentificador(),PersonaAssembler.getInstance().toDomainFromDTO(dto.getDatosPersona()), EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public RevisorEntity toEntityFromDomain(RevisorDomain domain) {
        return new RevisorEntity(domain.getIdentificador(),PersonaAssembler.getInstance().toEntityFromDomain(domain.getDatosPersona()), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public RevisorDomain toDomainFromEntity(RevisorEntity entity) {
        return new RevisorDomain(entity.getIdentificador(),PersonaAssembler.getInstance().toDomainFromEntity(entity.getDatosPersona()),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
    
    public static RevisorAssembler getInstance() { 
    	return INSTANCE; 
    }
	@Override
	public List<RevisorDomain> toDomainFromEntityList(List<RevisorEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RevisorDTO> toDTOFromDomainList(List<RevisorDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
