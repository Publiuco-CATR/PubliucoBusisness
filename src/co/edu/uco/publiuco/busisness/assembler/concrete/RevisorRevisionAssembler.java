package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.RevisorRevisionDomain;
import co.edu.uco.publiuco.dto.RevisorRevisionDTO;
import co.edu.uco.publiuco.entities.RevisorRevisionEntity;

public final class RevisorRevisionAssembler implements Assembler<RevisorRevisionDomain, RevisorRevisionDTO, RevisorRevisionEntity> {
    public static final RevisorRevisionAssembler INSTANCE = new RevisorRevisionAssembler();

    private RevisorRevisionAssembler(){
        super();
    }

    @Override
    public RevisorRevisionDTO toDTOFromDomain(RevisorRevisionDomain domain) {
        return RevisorRevisionDTO.create().setIdentificador(domain.getIdentificador()).setRevision(RevisionAssembler.getInstance().toDTOFromDomain(domain.getRevision()))
                .setRevisor(RevisorAssembler.getInstance().toDTOFromDomain(domain.getRevisor())).setFechaCompletitudRevision(domain.getFechaCompletitudRevision())
                .setFechaAsignacionRevision(domain.getFechaAsignacionRevision()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public RevisorRevisionDomain toDomainFromDTO(RevisorRevisionDTO dto) {
        return new RevisorRevisionDomain(dto.getIdentificador(),RevisionAssembler.getInstance().toDomainFromDTO(dto.getRevision()), RevisorAssembler.getInstance().toDomainFromDTO(dto.getRevisor()),
                dto.getFechaAsignacionRevision(),dto.getFechaCompletitudRevision(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public RevisorRevisionEntity toEntityFromDomain(RevisorRevisionDomain domain) {
        return new RevisorRevisionEntity(domain.getIdentificador(), RevisionAssembler.getInstance().toEntityFromDomain(domain.getRevision()),
                RevisorAssembler.getInstance().toEntityFromDomain(domain.getRevisor()), domain.getFechaAsignacionRevision(),domain.getFechaCompletitudRevision(),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public RevisorRevisionDomain toDomainFromEntity(RevisorRevisionEntity entity) {
        return new RevisorRevisionDomain(entity.getIdentificador(),RevisionAssembler.getInstance().toDomainFromEntity(entity.getRevision()), RevisorAssembler.getInstance().toDomainFromEntity(entity.getRevisor()),
                entity.getFechaAsignacionRevision(),entity.getFechaCompletitudRevision(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
    
    public static RevisorRevisionAssembler getInstance() { 
    	return INSTANCE; 
    }

	@Override
	public List<RevisorRevisionDomain> toDomainFromEntityList(List<RevisorRevisionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<RevisorRevisionDTO> toDTOFromDomainList(List<RevisorRevisionDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

}
