package vn.api.spring.business.application.user.update;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Builder(toBuilder = true)
@Value
@AllArgsConstructor
public class UpdateUserInput {
	private int id;
	private String account;
	private String name;
	private String password;
	private String email;
	private String address;
	private String permissionType;
	private LocalDateTime createDate;
}
