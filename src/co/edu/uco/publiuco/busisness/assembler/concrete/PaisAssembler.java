package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.PaisDomain;
import co.edu.uco.publiuco.dto.PaisDTO;
import co.edu.uco.publiuco.entities.PaisEntity;

public final class PaisAssembler implements Assembler<PaisDomain, PaisDTO, PaisEntity> {
    public static final PaisAssembler INSTANCE = new PaisAssembler();

    private PaisAssembler(){
        super();
    }
    @Override
    public PaisDTO toDTOFromDomain(PaisDomain domain) {
        return PaisDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setIndicadorPais(domain.getIndicadorPais());
    }

    @Override
    public PaisDomain toDomainFromDTO(PaisDTO dto) {
        return new PaisDomain(dto.getIdentificador(), dto.getNombre(), dto.getIndicadorPais());
    }

    @Override
    public PaisEntity toEntityFromDomain(PaisDomain domain) {
        return new PaisEntity(domain.getIdentificador(), domain.getNombre(), domain.getIndicadorPais());
    }

    @Override
    public PaisDomain toDomainFromEntity(PaisEntity entity) {
        return new PaisDomain(entity.getIdentificador(), entity.getNombre(), entity.getIndicadorPais());
    }
    
   public static PaisAssembler getInstance() { 
	   return INSTANCE; 
   }

}
