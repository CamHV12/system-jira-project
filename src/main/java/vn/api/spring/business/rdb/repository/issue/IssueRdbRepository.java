package vn.api.spring.business.rdb.repository.issue;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import jakarta.transaction.Transactional;
import vn.api.spring.business.domain.exception.NoSuchElementException;
import vn.api.spring.business.domain.issue.RequestIssueDto;
import vn.api.spring.business.entity.Issue;

@Repository
@Transactional
public class IssueRdbRepository {
	private final IssueJpaRepository issueJpaRepository;

	public IssueRdbRepository(IssueJpaRepository issueJpaRepository) {
		super();
		this.issueJpaRepository = issueJpaRepository;
	}

	public RequestIssueDto getIssueById(int id) throws NoSuchElementException {
		Assert.notNull(id, "id must not be null");
		Issue issue = issueJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Issue with identity [" + id + "] : not found"));
		RequestIssueDto dto = RequestIssueDto.builder().type(issue.type()).createDate(issue.createDate())
				.updateDate(issue.updateDate()).build();
		return dto;
	}

	public void save(RequestIssueDto dto) {
		Issue issue = Issue.builder().type(dto.type()).createDate(dto.createDate()).build();
		issueJpaRepository.save(issue);
	}

	public void update(RequestIssueDto dto) {
		LocalDateTime createDate = issueJpaRepository.findById(dto.id()).get().createDate();
		Issue issue = Issue.builder().id(dto.id()).type(dto.type()).createDate(createDate).updateDate(dto.updateDate())
				.build();
		issueJpaRepository.save(issue);
	}
}
