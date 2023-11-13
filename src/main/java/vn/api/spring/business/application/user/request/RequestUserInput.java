package vn.api.spring.business.application.user.request;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Builder
@Value
public class RequestUserInput {
	private int id;
}
