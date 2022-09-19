package mm.rest.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {

	private Long idDTO;

	@ApiModelProperty(value = "This is the name", required = true)
	private String nameDTO;

	@JsonProperty("last_name")	//Musis v POSTMAN-ovi pomenovat attribut 'last_name' a nie surnameDTO ocividne je to prevod medzi POSTMAN-om a CustomerDTO -om cez JACKSON
	private String surnameDTO;

	private PhoneDTO phoneDTO;
}
