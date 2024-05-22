package com.vcriate.RestaurantManagementSystem.Exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CustomizeErrorDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private String description;
}
