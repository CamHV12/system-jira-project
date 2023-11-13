package vn.api.spring.business.application.issue.request;

import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import vn.api.spring.business.domain.exception.NoSuchElementException;
import vn.api.spring.business.domain.issue.RequestIssueDto;
import vn.api.spring.business.rdb.repository.issue.IssueRdbRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class RequestIssueApplication {
	private final IssueRdbRepository issueRdbRepository;

	public RequestIssueOutput start(RequestIssueInput input) throws NoSuchElementException {
		RequestIssueDto dto = issueRdbRepository.getIssueById(input.id());
		RequestIssueOutput output = RequestIssueOutput.builder().type(dto.type()).createDate(dto.createDate())
				.updateDate(dto.updateDate()).build();
		return output;
	}
}
