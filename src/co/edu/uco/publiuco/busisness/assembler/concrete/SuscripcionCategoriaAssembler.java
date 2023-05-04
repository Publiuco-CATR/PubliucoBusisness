package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.SuscripcionCategoriaDomain;
import co.edu.uco.publiuco.dto.SuscripcionCategoriaDTO;
import co.edu.uco.publiuco.entities.SuscripcionCategoriaEntity;

public final class SuscripcionCategoriaAssembler implements Assembler<SuscripcionCategoriaDomain, SuscripcionCategoriaDTO, SuscripcionCategoriaEntity> {
    public static final SuscripcionCategoriaAssembler INSTANCE = new SuscripcionCategoriaAssembler();

	
	@Override
    public SuscripcionCategoriaDTO toDTOFromDomain(SuscripcionCategoriaDomain domain) {
        return SuscripcionCategoriaDTO.create().setIdentificador(domain.getIdentificador()).setPlanCategoria(PlanCategoriaAssembler.getInstance().toDTOFromDomain(domain.getPlanCategoria()))
                .setPerfil(PerfilAssembler.getInstance().toDTOFromDomain(domain.getPerfil()));
    }

    @Override
    public SuscripcionCategoriaDomain toDomainFromDTO(SuscripcionCategoriaDTO dto) {
        return new SuscripcionCategoriaDomain(dto.getIdentificador(),PerfilAssembler.getInstance().toDomainFromDTO(dto.getPerfil()),
                PlanCategoriaAssembler.getInstance().toDomainFromDTO(dto.getPlanCategoria()));
    }

    @Override
    public SuscripcionCategoriaEntity toEntityFromDomain(SuscripcionCategoriaDomain domain) {
        return new SuscripcionCategoriaEntity(domain.getIdentificador(),PerfilAssembler.getInstance().toEntityFromDomain(domain.getPerfil()),
                PlanCategoriaAssembler.getInstance().toEntityFromDomain(domain.getPlanCategoria()));
    }

    @Override
    public SuscripcionCategoriaDomain toDomainFromEntity(SuscripcionCategoriaEntity entity) {
        return new SuscripcionCategoriaDomain(entity.getIdentificador(),PerfilAssembler.getInstance().toDomainFromEntity(entity.getPerfil()),
                PlanCategoriaAssembler.getInstance().toDomainFromEntity(entity.getPlanCategoria()));
    }
    
    public static SuscripcionCategoriaAssembler getInstance() { 
    	return INSTANCE; 
    }
}
