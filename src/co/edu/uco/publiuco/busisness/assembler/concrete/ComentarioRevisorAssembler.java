package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.ComentarioRevisorDomain;
import co.edu.uco.publiuco.dto.ComentarioRevisorDTO;
import co.edu.uco.publiuco.entities.ComentarioRevisorEntity;

public final class ComentarioRevisorAssembler implements Assembler<ComentarioRevisorDomain, ComentarioRevisorDTO, ComentarioRevisorEntity> {
    public static final ComentarioRevisorAssembler INSTANCE = new ComentarioRevisorAssembler();

    private ComentarioRevisorAssembler(){
        super();
    }
    @Override
    public ComentarioRevisorDTO toDTOFromDomain(ComentarioRevisorDomain domain) {
        return ComentarioRevisorDTO.create().setIdentificador(domain.getIdentificador()).setComentario(domain.getComentario())
                .setTipoComentarioRevisor(TipoComentarioRevisorAssembler.getInstance().toDTOFromDomain(domain.getTipoComentarioRevisor()))
                .setRevisorRevision(RevisorRevisionAssembler.getInstance().toDTOFromDomain(domain.getRevisorRevision()));
    }

    @Override
    public ComentarioRevisorDomain toDomainFromDTO(ComentarioRevisorDTO dto) {
        return new ComentarioRevisorDomain(dto.getIdentificador(),RevisorRevisionAssembler.getInstance().toDomainFromDTO(dto.getRevisorRevision()),
                TipoComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto.getTipoComentarioRevisor()), dto.getComentario());
    }

    @Override
    public ComentarioRevisorEntity toEntityFromDomain(ComentarioRevisorDomain domain) {
        return new ComentarioRevisorEntity(domain.getIdentificador(), RevisorRevisionAssembler.getInstance().toEntityFromDomain(domain.getRevisorRevision()), TipoComentarioRevisorAssembler.getInstance().toEntityFromDomain(domain.getTipoComentarioRevisor()),
                domain.getComentario());
    }

    @Override
    public ComentarioRevisorDomain toDomainFromEntity(ComentarioRevisorEntity entity) {
        return new ComentarioRevisorDomain(entity.getIdentificador(),RevisorRevisionAssembler.getInstance().toDomainFromEntity(entity.getRevisorRevision()),TipoComentarioRevisorAssembler.getInstance().toDomainFromEntity(entity.getTipoComentarioRevisor()), entity.getComentario());
    }
    
    public static ComentarioRevisorAssembler getInstance() { 
    	return INSTANCE; 
    }
	@Override
	public List<ComentarioRevisorDomain> toDomainFromEntityList(List<ComentarioRevisorEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}
	@Override
	public List<ComentarioRevisorDTO> toDTOFromDomainList(List<ComentarioRevisorDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

}
