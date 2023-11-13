package vn.api.spring.business.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
