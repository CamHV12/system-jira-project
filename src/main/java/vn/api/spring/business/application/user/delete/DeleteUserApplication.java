package vn.api.spring.business.application.user.delete;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vn.api.spring.business.rdb.repository.user.UserRdbRepository;

@Service
@RequiredArgsConstructor
public class DeleteUserApplication {
	private final UserRdbRepository userRdbRepository;

	public void start(DeleteUserInput input) {
		userRdbRepository.deleteById(input.id());
	}
}
