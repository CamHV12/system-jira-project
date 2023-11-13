package vn.api.spring.business.application.issue.register;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import vn.api.spring.business.domain.issue.RequestIssueDto;
import vn.api.spring.business.rdb.repository.issue.IssueRdbRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterIssueApplication {
	private final IssueRdbRepository issueRdbRepository;

	public void start(RegisterIssueInput input) {
		RequestIssueDto dto = RequestIssueDto.builder().type(input.type()).createDate(input.createDate()).build();
		issueRdbRepository.save(dto);
	}
}
