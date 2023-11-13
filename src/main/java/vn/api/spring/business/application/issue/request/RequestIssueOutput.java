package vn.api.spring.business.application.issue.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Builder
@Value
public class RequestIssueOutput {
	private String type;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;

}
