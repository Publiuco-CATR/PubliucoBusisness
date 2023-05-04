package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.TipoReporteDomain;
import co.edu.uco.publiuco.dto.TipoReporteDTO;
import co.edu.uco.publiuco.entities.TipoReporteEntity;

public final class TipoReporteAssembler implements Assembler<TipoReporteDomain, TipoReporteDTO, TipoReporteEntity> {
    public static final TipoReporteAssembler INSTANCE = new TipoReporteAssembler();

    private TipoReporteAssembler(){
        super();
    }
    @Override
    public TipoReporteDTO toDTOFromDomain(TipoReporteDomain domain) {
        return TipoReporteDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoReporteDomain toDomainFromDTO(TipoReporteDTO dto) {
        return new TipoReporteDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoReporteEntity toEntityFromDomain(TipoReporteDomain domain) {
        return new TipoReporteEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public TipoReporteDomain toDomainFromEntity(TipoReporteEntity entity) {
        return new TipoReporteDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }
    
    public static TipoReporteAssembler getInstance() { 
    	return INSTANCE; 
    }

}
