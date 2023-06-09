package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.EscritorDomain;
import co.edu.uco.publiuco.dto.EscritorDTO;
import co.edu.uco.publiuco.entities.EscritorEntity;

public final class EscritorAssembler implements Assembler<EscritorDomain, EscritorDTO, EscritorEntity> {
    public static final EscritorAssembler INSTANCE = new EscritorAssembler();
    
    public static EscritorAssembler getInstance() { return INSTANCE; }
    
    private EscritorAssembler(){
        super();
    }
    
    @Override
    public EscritorDTO toDTOFromDomain(EscritorDomain domain) {
        return EscritorDTO.create().setIdentificador(domain.getIdentificador())
                .setDatosPersona(PersonaAssembler.getInstance().toDTOFromDomain(domain.getDatosPersona())).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public EscritorDomain toDomainFromDTO(EscritorDTO dto) {
        return new EscritorDomain(dto.getIdentificador(),PersonaAssembler.getInstance().toDomainFromDTO(dto.getDatosPersona()), EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public EscritorEntity toEntityFromDomain(EscritorDomain domain) {
        return new EscritorEntity(domain.getIdentificador(),PersonaAssembler.getInstance().toEntityFromDomain(domain.getDatosPersona()),
                 EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public EscritorDomain toDomainFromEntity(EscritorEntity entity) {
        return new EscritorDomain(entity.getIdentificador(),PersonaAssembler.getInstance().toDomainFromEntity(entity.getDatosPersona()),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<EscritorDomain> toDomainFromEntityList(List<EscritorEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<EscritorDTO> toDTOFromDomainList(List<EscritorDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
