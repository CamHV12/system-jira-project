package vn.api.spring.business.application.issue.delete;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import vn.api.spring.business.rdb.repository.issue.IssueRdbRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteIssueApplication {
	private final IssueRdbRepository issueRdbRepository;
	public void start(DeleteIssueInput input) {
		issueRdbRepository.deleteById(input.id());
	}
}
