package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.ReporteDomain;
import co.edu.uco.publiuco.dto.ReporteDTO;
import co.edu.uco.publiuco.entities.ReporteEntity;

public final class ReporteAssembler implements Assembler<ReporteDomain, ReporteDTO, ReporteEntity> {
    public static final ReporteAssembler INSTANCE = new ReporteAssembler();
    public static ReporteAssembler getInstance() { return INSTANCE; }
    private ReporteAssembler(){
        super();
    }
    @Override
    public ReporteDTO toDTOFromDomain(ReporteDomain domain) {
        return ReporteDTO.create().setIdentificador(domain.getIdentificador()).setFechaReporte(domain.getFechaReporte())
                .setComentario(ComentarioLectorAssembler.getInstance().toDTOFromDomain(domain.getComentario())).setLector(LectorAssembler.getInstance().toDTOFromDomain(domain.getLector()))
                .setTipo(TipoReporteAssembler.getInstance().toDTOFromDomain(domain.getTipo())).setRazon(domain.getRazon());
    }

    @Override
    public ReporteDomain toDomainFromDTO(ReporteDTO dto) {
        return new ReporteDomain(dto.getIdentificador(),LectorAssembler.getInstance().toDomainFromDTO(dto.getLector()),
                ComentarioLectorAssembler.getInstance().toDomainFromDTO(dto.getComentario()),dto.getRazon(),TipoReporteAssembler.getInstance().toDomainFromDTO(dto.getTipo()),
                dto.getFechaReporte(), EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public ReporteEntity toEntityFromDomain(ReporteDomain domain) {
        return new ReporteEntity(domain.getIdentificador(),LectorAssembler.getInstance().toEntityFromDomain(domain.getLector()),
                ComentarioLectorAssembler.getInstance().toEntityFromDomain(domain.getComentario()), domain.getRazon(),TipoReporteAssembler.getInstance().toEntityFromDomain(domain.getTipo()),
                domain.getFechaReporte(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public ReporteDomain toDomainFromEntity(ReporteEntity entity) {
        return new ReporteDomain(entity.getIdentificador(),LectorAssembler.getInstance().toDomainFromEntity(entity.getLector()), ComentarioLectorAssembler.getInstance().toDomainFromEntity(entity.getComentario()),
                entity.getRazon(),TipoReporteAssembler.getInstance().toDomainFromEntity(entity.getTipo()),entity.getFechaReporte(), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()) );
    }

    @Override
    public List<ReporteDomain> toDomainFromEntityList(List<ReporteEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<ReporteDTO> toDTOFromDomainList(List<ReporteDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
