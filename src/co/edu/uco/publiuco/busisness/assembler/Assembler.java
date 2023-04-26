package co.edu.uco.publiuco.busisness.assembler;

public interface Assembler<D, T, E> {

	T toDtoFromDomain(D domain);
	D toDomainFromDTO(T dto);
	E toEntityFromDomain(D domain);
	D toDomainFromEntity(E entity);
	
}
