package vn.api.spring.business.application.user.update;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vn.api.spring.business.domain.user.RequestUserDto;
import vn.api.spring.business.rdb.repository.user.UserRdbRepository;

@Service
@RequiredArgsConstructor
public class UpdateUserApplication {
	private final UserRdbRepository userRdbRepository;

	public void start(UpdateUserInput input) {
		RequestUserDto dto = RequestUserDto.builder().id(input.id()).account(input.account()).name(input.name())
				.password(input.password()).email(input.email()).address(input.address())
				.permissionType(input.permissionType()).createDate(input.createDate()).build();
		userRdbRepository.update(dto);
	}
}
