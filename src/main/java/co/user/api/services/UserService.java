package co.user.api.services;

import co.user.api.dto.UserDto;
import co.user.api.exceptions.EntityNotFoundException;

public interface UserService {

	UserDto save(UserDto dto);

	UserDto findById(Long id) throws EntityNotFoundException;

	UserDto update(UserDto dto) throws EntityNotFoundException;

	void delete(Long id) throws EntityNotFoundException;

}
