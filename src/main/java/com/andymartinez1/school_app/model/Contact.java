package com.andymartinez1.school_app.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {

    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits long")
    private String mobileNum;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Subject is required")
    @Size(min = 5, message = "Subject must be at least 5 characters long")
    private String subject;

    @NotBlank(message = "Message is required")
    @Size(min = 10, message = "Message must be at least 10 characters long")
    private String message;

}
