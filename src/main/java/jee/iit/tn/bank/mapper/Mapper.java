package jee.iit.tn.bank.mapper;

import jee.iit.tn.bank.models.Identifiable;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Mapper interface for map from/to entity and DTO.
 *
 * @param <ENTITY> the entity type.
 * @param <DTO>    the DTO type.
 * @author Oussema Ben Jmeaa
 */
public interface Mapper<ENTITY extends Identifiable<?>, DTO> {

    String SPRING = "spring";

    /**
     * Convert from ENTITY to DTO.
     *
     * @param entity the object to be converted.
     * @return the entity converted to DTO.
     */
    DTO map(ENTITY entity);

    /**
     * Convert from DTO to ENTITY.
     *
     * @param dto the object to be converted.
     * @return the dto converted to ENTITY.
     */
    ENTITY map(DTO dto);

    /**
     * Convert from List<DTO> to List<ENTITY>.
     *
     * @param dtos the list of DTO's
     * @return the dtos converted to entities.
     */
    default List<ENTITY> mapToEntities(final Collection<DTO> dtos) {
        if (CollectionUtils.isEmpty(dtos)) {
            return Collections.emptyList();
        }
        return dtos.stream()
                .map(this::map)
                .collect(toList());
    }

    /**
     * Convert from List<ENTITY> to List<DTO>.
     *
     * @param entities the list of entity.
     * @return the entities converted to dtos.
     */
    default List<DTO> mapToDtos(final Collection<ENTITY> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(this::map)
                .collect(toList());
    }

}
