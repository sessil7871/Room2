package accommodation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DashBoardRepository extends CrudRepository<DashBoard, Long> {

    List<DashBoard> findByCompanyId(Long companyId);

}