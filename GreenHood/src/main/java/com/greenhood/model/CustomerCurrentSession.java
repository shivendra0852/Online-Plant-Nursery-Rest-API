package com.greenhood.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerCurrentSession {
	@Id
	@Column(unique = true)
	private Integer customerId;
	private String uniqueId;
	private LocalDateTime localDateTime;
}
