package vn.api.spring.business.application.user.register;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vn.api.spring.business.domain.user.RequestUserDto;
import vn.api.spring.business.rdb.repository.user.UserRdbRepository;

@Service
@RequiredArgsConstructor
public class RegisterUserApplication {
	private final UserRdbRepository userRdbRepository;

	public void start(RegisterUserInput input) {
		RequestUserDto dto = RequestUserDto.builder().account(input.account()).name(input.name())
				.password(input.password()).email(input.email()).address(input.address())
				.permissionType(input.permissionType()).build();
		userRdbRepository.save(dto);
	}

}
