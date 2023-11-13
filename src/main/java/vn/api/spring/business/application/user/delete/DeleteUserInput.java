package vn.api.spring.business.application.user.delete;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Builder
@Value
public class DeleteUserInput {
	private int id;
}
