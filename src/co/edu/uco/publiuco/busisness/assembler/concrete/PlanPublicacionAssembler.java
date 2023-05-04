package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.PlanPublicacionDomain;
import co.edu.uco.publiuco.dto.PlanPublicacionDTO;
import co.edu.uco.publiuco.entities.PlanPublicacionEntity;


public final class PlanPublicacionAssembler implements Assembler<PlanPublicacionDomain, PlanPublicacionDTO, PlanPublicacionEntity> {
    public static final PlanPublicacionAssembler INSTANCE = new PlanPublicacionAssembler();

    private PlanPublicacionAssembler(){
        super();
    }
    @Override
    public PlanPublicacionDTO toDTOFromDomain(PlanPublicacionDomain domain) {
        return PlanPublicacionDTO.create().setIdentificador(domain.getIdentificador()).setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion()))
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setPrecio(domain.getPrecio())
                .setFechaDesde(domain.getFechaDesde()).setFechaHasta(domain.getFechaHasta());
    }

    @Override
    public PlanPublicacionDomain toDomainFromDTO(PlanPublicacionDTO dto) {
        return new PlanPublicacionDomain(dto.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),
                dto.getPrecio(),dto.getFechaDesde(),dto.getFechaHasta(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public PlanPublicacionEntity toEntityFromDomain(PlanPublicacionDomain domain) {
        return new PlanPublicacionEntity(domain.getIdentificador(), PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()),
                domain.getPrecio(),domain.getFechaDesde(),domain.getFechaHasta(),EstadoAssembler.INSTANCE.toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public PlanPublicacionDomain toDomainFromEntity(PlanPublicacionEntity entity) {
        return new PlanPublicacionDomain(entity.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()),
                entity.getPrecio(),entity.getFechaDesde(),entity.getFechaHasta(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
    
    public static PlanPublicacionAssembler getInstance() { 
    	return INSTANCE; 
    }

}
