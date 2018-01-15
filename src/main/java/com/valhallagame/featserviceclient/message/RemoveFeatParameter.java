package com.valhallagame.featserviceclient.message;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoveFeatParameter {
	@NotNull
	private String characterName;
	
	@NotNull
	private FeatName featName;
}
