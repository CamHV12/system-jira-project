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
@Table(name = "detail_bug")
public class DetailBug {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String processingStage;
	private String diectCause;
	private String rootCause;
	private String description;
	private String causeAnalysis;
	private String correctiveAction;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
}
