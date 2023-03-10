package co.user.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.user.api.dto.UserDto;
import co.user.api.services.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	public static final String URL_RESOURCE_PUBLIC = "/new/user";
	public static final String URL_RESOURCE = "/user";
	public static final String URL_ID_PATH = "/{id}";

	@PostMapping(URL_RESOURCE_PUBLIC)
	@ApiOperation(value = "Crear nuevo usuario")
	public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto dto) {
		;
		return ResponseEntity.ok().body(userService.save(dto));
	}

	@GetMapping(URL_RESOURCE + URL_ID_PATH)
	@ApiOperation(value = "Encontrar un usuario por Id")
	public ResponseEntity<UserDto> findById(@PathVariable("id") long id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}

	@PutMapping(URL_RESOURCE)
	@ApiOperation(value = "Actualizar de usuario")
	public ResponseEntity<HttpStatus> update(@RequestBody UserDto dto) {
		userService.update(dto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(URL_RESOURCE + URL_ID_PATH)
	@ApiOperation(value = "Eliminar un usuario por Id")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
