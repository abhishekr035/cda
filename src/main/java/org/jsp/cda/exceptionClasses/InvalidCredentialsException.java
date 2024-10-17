package org.jsp.cda.exceptionClasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class InvalidCredentialsException extends RuntimeException
{
	private String message;
	
	public InvalidCredentialsException(String message) 
	{
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	

}
