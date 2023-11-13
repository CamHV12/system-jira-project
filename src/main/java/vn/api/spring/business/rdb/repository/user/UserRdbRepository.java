package vn.api.spring.business.rdb.repository.user;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;
import vn.api.spring.business.domain.exception.NoSuchElementException;
import vn.api.spring.business.domain.issue.RequestIssueDto;
import vn.api.spring.business.domain.user.RequestUserDto;
import vn.api.spring.business.entity.Issue;
import vn.api.spring.business.entity.User;
import vn.api.spring.business.rdb.repository.issue.IssueJpaRepository;

@Repository
public class UserRdbRepository {
	private final UserJpaRepository userJpaRepository;

	public UserRdbRepository(UserJpaRepository userJpaRepository) {
		super();
		this.userJpaRepository = userJpaRepository;
	}

	public RequestUserDto getUserById(int id) throws NoSuchElementException {
		Assert.notNull(id, "id must not be null");
		User user = userJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("User with identity [" + id + "] : not found"));
		RequestUserDto dto = RequestUserDto.builder().account(user.account()).name(user.name())
				.password(user.password()).email(user.email()).address(user.address())
				.permissionType(user.permissionType()).createDate(user.createDate()).updateDate(user.updateDate())
				.build();
		return dto;
	}

	public void save(RequestUserDto dto) {
		User user = User.builder().account(dto.account()).name(dto.name()).password(dto.password()).email(dto.email())
				.address(dto.address()).permissionType(dto.permissionType()).createDate(LocalDateTime.now()).build();
		userJpaRepository.save(user);
	}

	public void update(RequestUserDto dto) {
		User user = User.builder().id(dto.id()).account(dto.account()).name(dto.name()).password(dto.password())
				.email(dto.email()).address(dto.address()).permissionType(dto.permissionType())
				.createDate(dto.createDate()).updateDate(LocalDateTime.now()).build();
		userJpaRepository.save(user);
	}

	public void deleteById(int id) {
		Assert.notNull(id, "id must not be null");
		userJpaRepository.deleteById(id);
	}
}
