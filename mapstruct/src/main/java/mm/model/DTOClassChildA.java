package mm.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class DTOClassChildA extends DTOClassParent {

	private String name;
}
