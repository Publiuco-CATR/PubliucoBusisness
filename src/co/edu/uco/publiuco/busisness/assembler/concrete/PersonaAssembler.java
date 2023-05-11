package co.edu.uco.publiuco.busisness.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.PersonaDomain;
import co.edu.uco.publiuco.dto.PersonaDTO;
import co.edu.uco.publiuco.entities.PersonaEntity;

public final class PersonaAssembler implements Assembler<PersonaDomain, PersonaDTO, PersonaEntity> {
    public static final PersonaAssembler INSTANCE = new PersonaAssembler();

    private PersonaAssembler(){
        super();
    }
    @Override
    public PersonaDTO toDTOFromDomain(PersonaDomain domain) {
        return PersonaDTO.create().setIdentificador(domain.getIdentificador()).
                setTipoRelacionInstitucion(TipoRelacionInstitucionAssembler.getInstance().toDTOFromDomain(domain.getTipoRelacionInstitucion())).
                setCorreoElectronico(domain.getCorreoElectronico()).setIndicadorPais(PaisAssembler.getInstance().toDTOFromDomain(domain.getIndicadorPais()))
                .setNumeroIdentificacion(domain.getNumeroIdentificacion()).setPrimerNombre(domain.getPrimerNombre())
                .setSegundoNombre(domain.getSegundoNombre()).setPrimerApellido(domain.getPrimerApellido()).setSegundoApellido(domain.getSegundoApellido())
                .setNumeroTelefonoMovil(domain.getNumeroTelefonoMovil()).setTipoIdentificacionDTO(TipoIdentificacionAssembler.getInstance().toDTOFromDomain(domain.getTipoIdentificacionDTO()));
    }

    @Override
    public PersonaDomain toDomainFromDTO(PersonaDTO dto) {
        return new PersonaDomain(dto.getIdentificador(), TipoIdentificacionAssembler.getInstance().toDomainFromDTO(dto.getTipoIdentificacionDTO()),dto.getNumeroIdentificacion(),
                dto.getPrimerNombre(),dto.getSegundoNombre(),dto.getPrimerApellido(),dto.getSegundoApellido(),dto.getCorreoElectronico(),PaisAssembler.getInstance().toDomainFromDTO(dto.getIndicadorPais()),
                dto.getNumeroTelefonoMovil(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()),TipoRelacionInstitucionAssembler.getInstance().toDomainFromDTO(dto.getTipoRelacionInstitucion()));

    }

    @Override
    public PersonaEntity toEntityFromDomain(PersonaDomain domain) {
        return new PersonaEntity(domain.getIdentificador(),TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacionDTO()),
                domain.getNumeroIdentificacion(),domain.getPrimerNombre(),domain.getSegundoNombre(),domain.getPrimerApellido(),domain.getSegundoApellido(),
                domain.getCorreoElectronico(),PaisAssembler.getInstance().toEntityFromDomain(domain.getIndicadorPais()), domain.getNumeroTelefonoMovil(),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()), TipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain.getTipoRelacionInstitucion()));
    }

    @Override
    public PersonaDomain toDomainFromEntity(PersonaEntity entity) {
        return new PersonaDomain(entity.getIdentificador(),TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacionDTO()),
                entity.getNumeroIdentificacion(),entity.getPrimerNombre(),entity.getSegundoNombre(),entity.getPrimerApellido(),entity.getSegundoApellido(),
                entity.getCorreoElectronico(), PaisAssembler.getInstance().toDomainFromEntity(entity.getIndicadorPais()), entity.getNumeroTelefonoMovil(),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()), TipoRelacionInstitucionAssembler.getInstance().toDomainFromEntity(entity.getTipoRelacionInstitucion()));
    }
    
    public static PersonaAssembler getInstance() {
    	return INSTANCE; 
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
