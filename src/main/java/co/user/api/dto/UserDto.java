package co.user.api.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

	private Long id;

	@NotBlank(message = "name es requerido")
	private String name;

	@NotBlank(message = "email es requerido")
	private String email;

	@NotBlank(message = "password es requerido")
	private String password;

	private Date created;
	private Date modified;
	private Date lastLogin;
	private String token;
	private Boolean isActive;

	@Valid
	private List<PhoneDto> phones;

}
