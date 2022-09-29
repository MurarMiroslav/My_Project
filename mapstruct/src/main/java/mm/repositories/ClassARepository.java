package mm.repositories;

import mm.model.ClassA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassARepository extends CrudRepository<ClassA, Long>{

}
