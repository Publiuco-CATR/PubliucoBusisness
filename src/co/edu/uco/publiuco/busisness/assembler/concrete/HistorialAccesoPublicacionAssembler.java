package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.HistorialAccesoPublicacionDomain;
import co.edu.uco.publiuco.dto.HistorialAccesoPublicacionDTO;
import co.edu.uco.publiuco.entities.HistorialAccesoPublicacionEntity;

public final class HistorialAccesoPublicacionAssembler implements Assembler<HistorialAccesoPublicacionDomain, HistorialAccesoPublicacionDTO, HistorialAccesoPublicacionEntity> {
    public static final HistorialAccesoPublicacionAssembler INSTANCE = new HistorialAccesoPublicacionAssembler();

    private HistorialAccesoPublicacionAssembler(){
        super();
    }
    @Override
    public HistorialAccesoPublicacionDTO toDTOFromDomain(HistorialAccesoPublicacionDomain domain) {
        return HistorialAccesoPublicacionDTO.create().setIdentificador(domain.getIdentificador()).setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion()))
                .setFechaAcceso(domain.getFechaAcceso()).setLector(LectorAssembler.getInstance().toDTOFromDomain(domain.getLector()));
    }

    @Override
    public HistorialAccesoPublicacionDomain toDomainFromDTO(HistorialAccesoPublicacionDTO dto) {
        return new HistorialAccesoPublicacionDomain(dto.getIdentificador(),LectorAssembler.getInstance().toDomainFromDTO(dto.getLector()),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),
                dto.getFechaAcceso());
    }

    @Override
    public HistorialAccesoPublicacionEntity toEntityFromDomain(HistorialAccesoPublicacionDomain domain) {
        return new HistorialAccesoPublicacionEntity(domain.getIdentificador(), LectorAssembler.getInstance().toEntityFromDomain(domain.getLector()),
                PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()), domain.getFechaAcceso());
    }

    @Override
    public HistorialAccesoPublicacionDomain toDomainFromEntity(HistorialAccesoPublicacionEntity entity) {
        return new HistorialAccesoPublicacionDomain(entity.getIdentificador(), LectorAssembler.getInstance().toDomainFromEntity(entity.getLector()),
                PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()), entity.getFechaAcceso());
    }
    
    public static HistorialAccesoPublicacionAssembler getInstance() { 
    	return INSTANCE; 
    }

}
