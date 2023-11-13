package vn.api.spring.business.application.issue.update;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import vn.api.spring.business.domain.issue.RequestIssueDto;
import vn.api.spring.business.rdb.repository.issue.IssueRdbRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateIssueApplication {
	private final IssueRdbRepository issueRdbRepository;

	public void start(UpdateIssueInput input) {
		RequestIssueDto dto = RequestIssueDto.builder().id(input.id()).type(input.type()).createDate(input.createDate())
				.updateDate(input.updateDate()).build();
		issueRdbRepository.update(dto);
	}
}
