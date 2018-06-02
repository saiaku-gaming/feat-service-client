package com.valhallagame.featserviceclient.message;

import org.hibernate.validator.constraints.NotBlank;

import com.valhallagame.common.validation.CheckLowercase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFeatsParameter {
	@NotBlank
	@CheckLowercase
	private String characterName;
}
