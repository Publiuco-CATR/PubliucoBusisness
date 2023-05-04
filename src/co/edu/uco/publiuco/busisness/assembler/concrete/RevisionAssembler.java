package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.RevisionDomain;
import co.edu.uco.publiuco.dto.RevisionDTO;

import co.edu.uco.publiuco.entities.RevisionEntity;

public final class RevisionAssembler implements Assembler<RevisionDomain, RevisionDTO, RevisionEntity> {
    public static final RevisionAssembler INSTANCE = new RevisionAssembler();

    private RevisionAssembler(){
        super();
    }
    @Override
    public RevisionDTO toDTOFromDomain(RevisionDomain domain) {
        return RevisionDTO.create().setIdentificador(domain.getIdentificador()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setFechaCompletitudRevision(domain.getFechaCompletitudRevision()).setFechaLimiteRevision(domain.getFechaLimiteRevision()).setFechaSolicitudRevision(domain.getFechaSolicitudRevision())
                .setTipoRevision(TipoRevisionAssembler.getInstance().toDTOFromDomain(domain.getTipoRevision())).setVersion(VersionAssembler.getInstance().toDTOFromDomain(domain.getVersion()));
    }

    @Override
    public RevisionDomain toDomainFromDTO(RevisionDTO dto) {
        return new RevisionDomain(dto.getIdentificador(),VersionAssembler.getInstance().toDomainFromDTO(dto.getVersion()), TipoRevisionAssembler.getInstance().toDomainFromDTO(dto.getTipoRevision()), dto.getFechaSolicitudRevision(),
                dto.getFechaLimiteRevision(),dto.getFechaCompletitudRevision(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public RevisionEntity toEntityFromDomain(RevisionDomain domain) {
        return new RevisionEntity(domain.getIdentificador(),VersionAssembler.getInstance().toEntityFromDomain(domain.getVersion()),
                TipoRevisionAssembler.getInstance().toEntityFromDomain(domain.getTipoRevision()),domain.getFechaSolicitudRevision(),domain.getFechaSolicitudRevision(),
                domain.getFechaCompletitudRevision(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public RevisionDomain toDomainFromEntity(RevisionEntity entity) {
        return new RevisionDomain(entity.getIdentificador(), VersionAssembler.getInstance().toDomainFromEntity(entity.getVersion()),
                TipoRevisionAssembler.getInstance().toDomainFromEntity(entity.getTipoRevision()), entity.getFechaSolicitudRevision(),
                entity.getFechaLimiteRevision(), entity.getFechaCompletitudRevision(), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
    
    public static RevisionAssembler getInstance() { 
    	return INSTANCE; 
    }
}
