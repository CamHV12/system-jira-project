package vn.api.spring.business.application.issue.register;

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
public class RegisterIssueInput {
	@JsonProperty("type")
	private String type;
}
