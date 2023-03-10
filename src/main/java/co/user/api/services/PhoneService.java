package co.user.api.services;

import co.user.api.dto.PhoneDto;
import co.user.api.exceptions.EntityNotFoundException;

public interface PhoneService {
	
	public PhoneDto save(PhoneDto dto);

	public PhoneDto findById(Long id) throws EntityNotFoundException;

	public PhoneDto update(PhoneDto dto) throws EntityNotFoundException;

	public void delete(Long id) throws EntityNotFoundException;

}
