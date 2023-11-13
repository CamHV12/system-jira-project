package vn.api.spring.business.application.user.register;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Builder
@Value
public class RegisterUserInput {
	private String account;
	private String name;
	private String password;
	private String email;
	private String address;
	private String permissionType;

}
