package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.TipoEscritorDomain;
import co.edu.uco.publiuco.dto.TipoEscritorDTO;
import co.edu.uco.publiuco.entities.TipoEscritorEntity;

public final class TipoEscritorAssembler implements Assembler<TipoEscritorDomain, TipoEscritorDTO, TipoEscritorEntity> {
    public static final TipoEscritorAssembler INSTANCE = new TipoEscritorAssembler();

    private TipoEscritorAssembler(){
        super();
    }
    @Override
    public TipoEscritorDTO toDTOFromDomain(TipoEscritorDomain domain) {
        return TipoEscritorDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public TipoEscritorDomain toDomainFromDTO(TipoEscritorDTO dto) {
        return new TipoEscritorDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion(), EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public TipoEscritorEntity toEntityFromDomain(TipoEscritorDomain domain) {
        return new TipoEscritorEntity(domain.getIdentificador(),domain.getNombre(), domain.getDescripcion(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public TipoEscritorDomain toDomainFromEntity(TipoEscritorEntity entity) {
        return new TipoEscritorDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
    
    public static TipoEscritorAssembler getInstance() { 
    	return INSTANCE; 
    }

}
