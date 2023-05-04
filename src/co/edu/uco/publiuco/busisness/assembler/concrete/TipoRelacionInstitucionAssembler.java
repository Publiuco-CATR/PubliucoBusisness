package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

public final class TipoRelacionInstitucionAssembler implements Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO,TipoRelacionInstitucionEntity> {

    public static final TipoRelacionInstitucionAssembler INSTANCE = new TipoRelacionInstitucionAssembler();

    private TipoRelacionInstitucionAssembler(){
        super();
    }
    @Override
    public TipoRelacionInstitucionDTO toDTOFromDomain(TipoRelacionInstitucionDomain domain) {
        return new TipoRelacionInstitucionDTO().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public TipoRelacionInstitucionDomain toDomainFromDTO(TipoRelacionInstitucionDTO dto) {
        return null;
    }

    @Override
    public TipoRelacionInstitucionEntity toEntityFromDomain(TipoRelacionInstitucionDomain domain) {
        return null;
    }

    @Override
    public TipoRelacionInstitucionDomain toDomainFromEntity(TipoRelacionInstitucionEntity entity) {
        return null;
    }
    
    public static TipoRelacionInstitucionAssembler getInstance() { 
    	return INSTANCE; 
    }

}
