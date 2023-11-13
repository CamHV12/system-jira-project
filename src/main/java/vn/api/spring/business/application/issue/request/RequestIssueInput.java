package vn.api.spring.business.application.issue.request;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Builder
@Value
public class RequestIssueInput {
	private int id;
}
