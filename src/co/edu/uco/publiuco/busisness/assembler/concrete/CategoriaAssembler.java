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
                .setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setTienePadre(domain.tienePadre());
    }

    @Override
    public CategoriaDomain toDomainFromDTO(CategoriaDTO dto) {
        return new CategoriaDomain(dto.getIdentificador(),CategoriaAssembler.getInstance().toDomainFromDTO(dto.getCategoriaPadre()),dto.getNombre(),dto.getDescripcion(),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()), dto.tienePadre());
    }

    @Override
    public CategoriaEntity toEntityFromDomain(CategoriaDomain domain) {
    	return new CategoriaEntity(domain.getIdentificador(), CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoriaPadre()), domain.getNombre(), domain.getDescripcion(), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()), domain.tienePadre());
    }

    @Override
    public CategoriaDomain toDomainFromEntity(CategoriaEntity entity) {
        return new CategoriaDomain(entity.getIdentificador(),CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoriaPadre()),
                entity.getNombre(),entity.getDescripcion(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()), entity.tienePadre());
    }
    
    public static CategoriaAssembler getInstance() { 
    	return INSTANCE; 
    }
	@Override
	public List<CategoriaDomain> toDomainFromEntityList(List<CategoriaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}
	@Override
	public List<CategoriaDTO> toDTOFromDomainList(List<CategoriaDomain> domainList) {
		return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
	}

}
