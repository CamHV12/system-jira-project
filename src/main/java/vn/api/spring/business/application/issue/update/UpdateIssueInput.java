package vn.api.spring.business.application.issue.update;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIssueInput {
	@JsonProperty("id")
	private int id;
	@JsonProperty("type")
	private String type;
	@JsonProperty("createDate")
	private LocalDateTime createDate;
	@JsonProperty("updateDate")
	private LocalDateTime updateDate;
}
