package vn.api.spring.business.domain.issue;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Builder
@Value
public class RequestIssueDto {
	private int id;
	private String type;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
}
