package co.edu.uco.publiuco.busisness.assembler.concrete;

import co.edu.uco.publiuco.busisness.assembler.Assembler;
import co.edu.uco.publiuco.busisness.domain.PalabraClavePublicacionDomain;
import co.edu.uco.publiuco.dto.PalabraClavePublicacionDTO;
import co.edu.uco.publiuco.entities.PalabraClavePublicacionEntity;

public final class PalabraClavePublicacionAssembler implements Assembler<PalabraClavePublicacionDomain, PalabraClavePublicacionDTO, PalabraClavePublicacionEntity> {
    @Override
    public PalabraClavePublicacionDTO toDTOFromDomain(PalabraClavePublicacionDomain domain) {
        return PalabraClavePublicacionDTO.create().setIdentificador(domain.getIdentificador()).setPalabraClave(domain.getPalabraClave())
                .setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion()));
    }

    @Override
    public PalabraClavePublicacionDomain toDomainFromDTO(PalabraClavePublicacionDTO dto) {
        return new PalabraClavePublicacionDomain(dto.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),
                dto.getPalabraClave());
    }

    @Override
    public PalabraClavePublicacionEntity toEntityFromDomain(PalabraClavePublicacionDomain domain) {
        return new PalabraClavePublicacionEntity(domain.getIdentificador(), PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()),
                domain.getPalabraClave());
    }

    @Override
    public PalabraClavePublicacionDomain toDomainFromEntity(PalabraClavePublicacionEntity entity) {
        return new PalabraClavePublicacionDomain(entity.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()),entity.getPalabraClave() );
    }
}
