package co.user.api.dto;

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
public class PhoneDto {

	private Long id;

	@NotBlank(message = "number es requerido")
	private String number;

	@NotBlank(message = "cityCode es requerido")
	private String cityCode;

	@NotBlank(message = "countryCode es requerido")
	private String countryCode;

}