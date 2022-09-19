package mm.repository;

import mm.model.Notes;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Notes, Long> {

}
