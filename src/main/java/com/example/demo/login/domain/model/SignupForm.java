package com.example.demo.login.domain.model;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignupForm {
	@NotBlank(message = "{require_check}")
	@Email(message = "{email_check}")
	private String userId;

	@NotBlank(message = "{require_check}")
	@Length(min = 4, max = 100, message = "{length_check}")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{pattern_check}")
	private String password;

	@NotBlank(message = "{require_check}")
	private String userName;

	@NotNull(message = "{require_check}")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;

	@Min(value = 20, message = "{min_check}")
	@Max(value = 100, message = "{max_check}")
	private int age;

	@AssertFalse(message="{false_check}")
	private boolean marriage;
}
