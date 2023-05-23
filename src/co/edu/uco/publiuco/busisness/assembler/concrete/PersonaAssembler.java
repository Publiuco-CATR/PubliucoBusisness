package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.PersonaDomain;
import co.edu.uco.publiuco.dto.PersonaDTO;
import co.edu.uco.publiuco.entities.PersonaEntity;

public final class PersonaAssembler implements Assembler<PersonaDomain, PersonaDTO, PersonaEntity> {
    public static final PersonaAssembler INSTANCE = new PersonaAssembler();
    public static PersonaAssembler getInstance() { return INSTANCE; }
    private PersonaAssembler(){
        super();
    }
    @Override
    public PersonaDTO toDTOFromDomain(PersonaDomain domain) {
        return PersonaDTO.create().setIdentificador(domain.getIdentificador()).
                setRelacionInstitucion(TipoRelacionInstitucionAssembler.getInstance().toDTOFromDomain(domain.getRelacionInstitucion())).
                setCorreoElectronico(domain.getCorreoElectronico()).setPaisTelefono(PaisAssembler.getInstance().toDTOFromDomain(domain.getPaisTelefono()))
                .setNumeroIdentificacion(domain.getNumeroIdentificacion()).setPrimerNombre(domain.getPrimerNombre())
                .setSegundoNombre(domain.getSegundoNombre()).setPrimerApellido(domain.getPrimerApellido()).setSegundoApellido(domain.getSegundoApellido())
                .setNumeroTelefono(domain.getNumeroTelefono()).setTipoIdentificacionDTO(TipoIdentificacionAssembler.getInstance().toDTOFromDomain(domain.getTipoIdentificacionDTO()));
    }

    @Override
    public PersonaDomain toDomainFromDTO(PersonaDTO dto) {
        return new PersonaDomain(dto.getIdentificador(), TipoIdentificacionAssembler.getInstance().toDomainFromDTO(dto.getTipoIdentificacionDTO()),dto.getNumeroIdentificacion(),
                dto.getPrimerNombre(),dto.getSegundoNombre(),dto.getPrimerApellido(),dto.getSegundoApellido(),dto.getCorreoElectronico(),PaisAssembler.getInstance().toDomainFromDTO(dto.getPaisTelefono()),
                dto.getNumeroTelefono(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()),TipoRelacionInstitucionAssembler.getInstance().toDomainFromDTO(dto.getRelacionInstitucion()));

    }

    @Override
    public PersonaEntity toEntityFromDomain(PersonaDomain domain) {
        return new PersonaEntity(domain.getIdentificador(),TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacionDTO()),
                domain.getNumeroIdentificacion(),domain.getPrimerNombre(),domain.getSegundoNombre(),domain.getPrimerApellido(),domain.getSegundoApellido(),
                domain.getCorreoElectronico(),PaisAssembler.getInstance().toEntityFromDomain(domain.getPaisTelefono()), domain.getNumeroTelefono(),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()), TipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain.getRelacionInstitucion()));
    }

    @Override
    public PersonaDomain toDomainFromEntity(PersonaEntity entity) {
        return new PersonaDomain(entity.getIdentificador(),TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacionDTO()),
                entity.getNumeroIdentificacion(),entity.getPrimerNombre(),entity.getSegundoNombre(),entity.getPrimerApellido(),entity.getSegundoApellido(),
                entity.getCorreoElectronico(), PaisAssembler.getInstance().toDomainFromEntity(entity.getPaisTelefono()), entity.getNumeroTelefono(),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()), TipoRelacionInstitucionAssembler.getInstance().toDomainFromEntity(entity.getRelacionInstitucion()));
    }

    @Override
    public List<PersonaDomain> toDomainFromEntityList(List<PersonaEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<PersonaDTO> toDTOFromDomainList(List<PersonaDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
