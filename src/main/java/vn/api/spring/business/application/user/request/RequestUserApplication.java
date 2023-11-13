package vn.api.spring.business.application.user.request;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vn.api.spring.business.domain.exception.NoSuchElementException;
import vn.api.spring.business.domain.user.RequestUserDto;
import vn.api.spring.business.rdb.repository.user.UserRdbRepository;

@Service
@RequiredArgsConstructor
public class RequestUserApplication {
	private final UserRdbRepository userRdbRepository;

	public RequestUserOutput start(RequestUserInput input) throws NoSuchElementException {
		RequestUserDto dto = userRdbRepository.getUserById(input.id());
		RequestUserOutput output = RequestUserOutput.builder().account(dto.account()).name(dto.name())
				.password(dto.password()).email(dto.email()).address(dto.address()).permissionType(dto.permissionType())
				.createDate(dto.createDate()).updateDate(dto.updateDate()).build();
		return output;
	}
}
