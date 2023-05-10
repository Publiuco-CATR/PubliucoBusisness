package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.CategoriaDomain;
import co.edu.uco.publiuco.dto.CategoriaDTO;
import co.edu.uco.publiuco.entities.CategoriaEntity;

public final class CategoriaAssembler implements Assembler<CategoriaDomain, CategoriaDTO, CategoriaEntity> {
    public static final CategoriaAssembler INSTANCE = new CategoriaAssembler();

    private CategoriaAssembler(){
        super();
    }
    @Override
    public CategoriaDTO toDTOFromDomain(CategoriaDomain domain) {
        return CategoriaDTO.create().setCategoriaPadre(CategoriaAssembler.getInstance().toDTOFromDomain(domain.getCategoriaPadre()))
                .setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public CategoriaDomain toDomainFromDTO(CategoriaDTO dto) {
        return new CategoriaDomain(dto.getIdentificador(),CategoriaAssembler.getInstance().toDomainFromDTO(dto.getCategoriaPadre()),dto.getNombre(),dto.getDescripcion(),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public CategoriaEntity toEntityFromDomain(CategoriaDomain domain) {
        return new CategoriaEntity(domain.getIdentificador(),CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoriaPadre()),domain.getNombre(),domain.getDescripcion(),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public CategoriaDomain toDomainFromEntity(CategoriaEntity entity) {
        return new CategoriaDomain(entity.getIdentificador(),CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoriaPadre()),
                entity.getNombre(),entity.getDescripcion(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
    
    public static CategoriaAssembler getInstance() { 
    	return INSTANCE; 
    }
	@Override
	public List<CategoriaDomain> toDomainFromEntityList(List<CategoriaEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CategoriaDTO> toDTOFromDomainList(List<CategoriaDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
