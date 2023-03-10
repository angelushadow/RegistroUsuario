package co.user.api.services.implementation;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import co.user.api.dto.UserDto;
import co.user.api.entities.UserEntity;
import co.user.api.exceptions.EntityNotFoundException;
import co.user.api.exceptions.ValidateException;
import co.user.api.mappers.UserMapper;
import co.user.api.repositories.UserRepository;
import co.user.api.security.component.WebSecurityComponent;
import co.user.api.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	private UserEntity entity;

	@Autowired
	private WebSecurityComponent webSecurityComponent;

	@Value("${regex.password}")
	private String REGEX_PASSWORD;

	@Value("${regex.email}")
	private String REGEX_EMAIL;

	@Override
	public UserDto save(UserDto dto) {
		validEmail(dto.getEmail());
		validDuplicateEmail(dto.getEmail());
		validPassword(dto.getPassword());
		dto.setToken(webSecurityComponent.getJWTToken(dto.getName()));
		dto.setIsActive(true);

		this.entity = repository.save(UserMapper.INSTANCE.dtoToEntity(dto));

		return UserMapper.INSTANCE.entityToDto(entity);
	}

	@Override
	public UserDto findById(Long id) throws EntityNotFoundException {

		Optional<UserEntity> value = repository.findById(id);

		if (value.isPresent())

			return UserMapper.INSTANCE.entityToDto(value.get());

		throw new EntityNotFoundException("Usuario no encontrado con id: " + id);
	}

	@Override
	public UserDto update(UserDto dto) throws EntityNotFoundException {

		Optional<UserEntity> value = repository.findById(dto.getId());

		dto.setModified(new Date());
		if (value.isPresent())

			return UserMapper.INSTANCE.entityToDto(repository.save(UserMapper.INSTANCE.dtoToEntity(dto)));

		throw new EntityNotFoundException("Usuario no encontrado con id: " + dto.getId());

	}

	@Override
	public void delete(Long id) throws EntityNotFoundException {
		Optional<UserEntity> value = repository.findById(id);

		if (value.isPresent())
			repository.deleteById(id);

		throw new EntityNotFoundException("Usuario no encontrado con id: " + id);

	}

	private void validDuplicateEmail(String email) {

		Example<UserEntity> userExample = Example.of(UserEntity.builder().email(email).build());
		Optional<UserEntity> userOptional = repository.findOne(userExample);
		if (userOptional.isPresent()) {
			throw new ValidateException("El correo ya registrado: " + email);
		}
	}

	private void validPassword(String password) {

		if (!isValid(password, REGEX_PASSWORD)) {
			throw new ValidateException("Validacion de formato fallida: password ");
		}
	}

	private void validEmail(String email) {

		if (!isValid(email, REGEX_EMAIL)) {
			throw new ValidateException("Validacion de formato fallida: email ");
		}
	}

	private static boolean isValid(String value, String patern) {
		Pattern pattern = Pattern.compile(patern);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

}
