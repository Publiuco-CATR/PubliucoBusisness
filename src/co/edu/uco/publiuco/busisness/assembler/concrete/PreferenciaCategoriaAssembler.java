package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.PreferenciaCategoriaDomain;
import co.edu.uco.publiuco.dto.PreferenciaCategoriaDTO;
import co.edu.uco.publiuco.entities.PreferenciaCategoriaEntity;

public final class PreferenciaCategoriaAssembler implements Assembler<PreferenciaCategoriaDomain, PreferenciaCategoriaDTO, PreferenciaCategoriaEntity> {
    public static final PreferenciaCategoriaAssembler INSTANCE = new PreferenciaCategoriaAssembler();
	
    @Override
    public PreferenciaCategoriaDTO toDTOFromDomain(PreferenciaCategoriaDomain domain) {
        return PreferenciaCategoriaDTO.create().setIdentificador(domain.getIdentificador()).setCategoria(CategoriaAssembler.getInstance().toDTOFromDomain(domain.getCategoria()))
                .setPerfil(PerfilAssembler.getInstance().toDTOFromDomain(domain.getPerfil()));
    }

    @Override
    public PreferenciaCategoriaDomain toDomainFromDTO(PreferenciaCategoriaDTO dto) {
        return new PreferenciaCategoriaDomain(dto.getIdentificador(), PerfilAssembler.getInstance().toDomainFromDTO(dto.getPerfil()),
                CategoriaAssembler.getInstance().toDomainFromDTO(dto.getCategoria()));
    }

    @Override
    public PreferenciaCategoriaEntity toEntityFromDomain(PreferenciaCategoriaDomain domain) {
        return new PreferenciaCategoriaEntity(domain.getIdentificador(), PerfilAssembler.getInstance().toEntityFromDomain(domain.getPerfil()),
                CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoria()));
    }

    @Override
    public PreferenciaCategoriaDomain toDomainFromEntity(PreferenciaCategoriaEntity entity) {
        return new PreferenciaCategoriaDomain(entity.getIdentificador(),PerfilAssembler.getInstance().toDomainFromEntity(entity.getPerfil()),
                CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoria()));
    }
    
    public static PreferenciaCategoriaAssembler getInstance() { 
    	return INSTANCE; 
    }

	@Override
	public List<PreferenciaCategoriaDomain> toDomainFromEntityList(List<PreferenciaCategoriaEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PreferenciaCategoriaDTO> toDTOFromDomainList(List<PreferenciaCategoriaDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
}
