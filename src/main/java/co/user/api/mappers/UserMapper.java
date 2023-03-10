package co.user.api.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.user.api.dto.UserDto;
import co.user.api.entities.UserEntity;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserDto entityToDto(UserEntity entity);

	UserEntity dtoToEntity(UserDto dto);

	List<UserDto> entityToDto(List<UserEntity> entity);

	List<UserEntity> dtoToEntity(List<UserDto> dto);

}
