package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.VersionDomain;
import co.edu.uco.publiuco.dto.VersionDTO;
import co.edu.uco.publiuco.entities.VersionEntity;

public final class VersionAssembler implements Assembler<VersionDomain, VersionDTO, VersionEntity> {
	   public static final VersionAssembler INSTANCE = new VersionAssembler();
	    public static VersionAssembler getInstance() { return INSTANCE; }
	    private VersionAssembler(){
	        super();
	    }
	    @Override
	    public VersionDTO toDTOFromDomain(VersionDomain domain) {
	        return VersionDTO.create().setIdentificador(domain.getIdentificador()).setNumeroVersion(domain.getNumeroVersion())
	                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setCuerpo(domain.getCuerpo())
	                .setFechaCreacion(domain.getFechaCreacion())
	                .setResumen(domain.getResumen()).setTitulo(domain.getTitulo()).setFechaUltimaModificacion(domain.getFechaUltimaModificacion()).setVersionAnterior(VersionAssembler.getInstance().toDTOFromDomain(domain.getVersionAnterior()));
	    }

	    @Override
	    public VersionDomain toDomainFromDTO(VersionDTO dto) {
	        return new VersionDomain(dto.getIdentificador(),VersionAssembler.getInstance().toDomainFromDTO(dto.getVersionAnterior()),
	                dto.getNumeroVersion(),dto.getFechaCreacion(),dto.getFechaUltimaModificacion(),dto.getTitulo(),dto.getResumen(),dto.getCuerpo(),
	                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()), dto.tieneVersionAnterior());
	    }

	    @Override
	    public VersionEntity toEntityFromDomain(VersionDomain domain) {
	        return new VersionEntity(domain.getIdentificador(),VersionAssembler.getInstance().toEntityFromDomain(domain.getVersionAnterior()),
	                domain.getNumeroVersion(),domain.getFechaCreacion(),domain.getFechaUltimaModificacion(),domain.getTitulo(),domain.getResumen(),domain.getCuerpo(),
	                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()), domain.tieneVersionAnterior());
	    }

	    @Override
	    public VersionDomain toDomainFromEntity(VersionEntity entity) {
	        return new VersionDomain(entity.getIdentificador(), VersionAssembler.getInstance().toDomainFromEntity(entity.getVersionAnterior()),
	                entity.getNumeroVersion(),entity.getFechaCreacion(),entity.getFechaUltimaModificacion(),entity.getTitulo(), entity.getResumen(),entity.getCuerpo(),
	                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()), entity.tieneVersionAnterior());
	    }

	    @Override
	    public List<VersionDomain> toDomainFromEntityList(List<VersionEntity> entityList) {
	        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

	    }

	    @Override
	    public List<VersionDTO> toDTOFromDomainList(List<VersionDomain> domainList) {
	        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

	    }
}
