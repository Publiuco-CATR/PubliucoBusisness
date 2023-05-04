package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.TipoIdentificacionDomain;
import co.edu.uco.publiuco.dto.TipoIdentificacionDTO;
import co.edu.uco.publiuco.entities.TipoIdentificacionEntity;

public final class TipoIdentificacionAssembler implements Assembler<TipoIdentificacionDomain, TipoIdentificacionDTO, TipoIdentificacionEntity> {
    public static final TipoIdentificacionAssembler INSTANCE = new TipoIdentificacionAssembler();

    private TipoIdentificacionAssembler(){
        super();
    }
    @Override
    public TipoIdentificacionDTO toDTOFromDomain(TipoIdentificacionDomain domain) {
        return TipoIdentificacionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoIdentificacionDomain toDomainFromDTO(TipoIdentificacionDTO dto) {
        return new TipoIdentificacionDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoIdentificacionEntity toEntityFromDomain(TipoIdentificacionDomain domain) {
        return new TipoIdentificacionEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public TipoIdentificacionDomain toDomainFromEntity(TipoIdentificacionEntity entity) {
        return new TipoIdentificacionDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }
    
    public static TipoIdentificacionAssembler getInstance() { 
    	return INSTANCE; 
    }

}
