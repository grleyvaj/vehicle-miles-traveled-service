package ch.prodigio.vmt.demo.infrastructure;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gloria R. Leyva Jerez
 */
@Repository
public interface IVehicleJpaRepository extends PagingAndSortingRepository<Vehicle, Long>,
	JpaSpecificationExecutor<Vehicle> {
}
