package co.user.api.services.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.user.api.dto.PhoneDto;
import co.user.api.entities.PhoneEntity;
import co.user.api.exceptions.EntityNotFoundException;
import co.user.api.mappers.PhoneMapper;
import co.user.api.repositories.PhoneRepositoy;
import co.user.api.services.PhoneService;

@Service
public class PhoneServiceImple implements PhoneService {

	@Autowired
	private PhoneRepositoy repository;

	@Override
	@Transactional
	public PhoneDto save(PhoneDto dto) {

		return PhoneMapper.INSTANCE.entityToDto(repository.save(PhoneMapper.INSTANCE.dtoToEntity(dto)));
	}

	@Override
	public PhoneDto findById(Long id) throws EntityNotFoundException {

		Optional<PhoneEntity> value = repository.findById(id);

		if (value.isPresent())

			return PhoneMapper.INSTANCE.entityToDto(value.get());

		throw new EntityNotFoundException("Telenofo no encontrado con id: " + id);
	}

	@Override
	@Transactional
	public PhoneDto update(PhoneDto dto) throws EntityNotFoundException {

		Optional<PhoneEntity> value = repository.findById(dto.getId());

		if (value.isPresent())

			return PhoneMapper.INSTANCE.entityToDto(repository.save(PhoneMapper.INSTANCE.dtoToEntity(dto)));

		throw new EntityNotFoundException("Telenofo no encontrado con id: " + dto.getId());

	}

	@Override
	public void delete(Long id) throws EntityNotFoundException {
		Optional<PhoneEntity> value = repository.findById(id);

		if (value.isPresent())
			repository.deleteById(id);

		throw new EntityNotFoundException("Telenofo no encontrado con id: " + id);
	}

}
