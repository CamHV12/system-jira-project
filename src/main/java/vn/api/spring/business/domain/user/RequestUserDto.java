package vn.api.spring.business.domain.user;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Builder
@Value
public class RequestUserDto {
	private int id;
	private String account;
	private String name;
	private String password;
	private String email;
	private String address;
	private String permissionType;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
}
