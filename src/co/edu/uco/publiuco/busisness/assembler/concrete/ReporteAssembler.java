package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.ReporteDomain;
import co.edu.uco.publiuco.dto.ReporteDTO;
import co.edu.uco.publiuco.entities.ReporteEntity;

public final class ReporteAssembler implements Assembler<ReporteDomain, ReporteDTO, ReporteEntity> {
    public static final ReporteAssembler INSTANCE = new ReporteAssembler();
	
    @Override
    public ReporteDTO toDTOFromDomain(ReporteDomain domain) {
        return ReporteDTO.create().setIdentificador(domain.getIdentificador()).setFechaReporte(domain.getFechaReporte())
                .setComentario(ComentarioLectorAssembler.getInstance().toDTOFromDomain(domain.getComentario())).setLector(LectorAssembler.getInstance().toDTOFromDomain(domain.getLector()))
                .setTipoReporte(TipoReporteAssembler.getInstance().toDTOFromDomain(domain.getTipoReporte())).setRazon(domain.getRazon());
    }

    @Override
    public ReporteDomain toDomainFromDTO(ReporteDTO dto) {
        return new ReporteDomain(dto.getIdentificador(),LectorAssembler.getInstance().toDomainFromDTO(dto.getLector()),
                ComentarioLectorAssembler.getInstance().toDomainFromDTO(dto.getComentario()),dto.getRazon(),TipoReporteAssembler.getInstance().toDomainFromDTO(dto.getTipoReporte()),
                dto.getFechaReporte());
    }

    @Override
    public ReporteEntity toEntityFromDomain(ReporteDomain domain) {
        return new ReporteEntity(domain.getIdentificador(),LectorAssembler.getInstance().toEntityFromDomain(domain.getLector()),
                ComentarioLectorAssembler.getInstance().toEntityFromDomain(domain.getComentario()), domain.getRazon(),TipoReporteAssembler.getInstance().toEntityFromDomain(domain.getTipoReporte()),
                domain.getFechaReporte());
    }

    @Override
    public ReporteDomain toDomainFromEntity(ReporteEntity entity) {
        return new ReporteDomain(entity.getIdentificador(),LectorAssembler.getInstance().toDomainFromEntity(entity.getLector()), ComentarioLectorAssembler.getInstance().toDomainFromEntity(entity.getComentario()),
                entity.getRazon(),TipoReporteAssembler.getInstance().toDomainFromEntity(entity.getTipoReporte()),entity.getFechaReporte() );
    }
    
    public static ReporteAssembler getInstance() { 
    	return INSTANCE; 
    }

	@Override
	public List<ReporteDomain> toDomainFromEntityList(List<ReporteEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReporteDTO> toDTOFromDomainList(List<ReporteDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
}
