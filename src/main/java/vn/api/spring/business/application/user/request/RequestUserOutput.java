package vn.api.spring.business.application.user.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Builder
@Value
public class RequestUserOutput {
	private String account;
	private String name;
	private String password;
	private String email;
	private String address;
	private String permissionType;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
}
