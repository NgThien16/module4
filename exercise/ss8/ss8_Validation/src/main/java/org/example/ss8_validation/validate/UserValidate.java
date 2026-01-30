package org.example.ss8_validation.validate;

import org.example.ss8_validation.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;
@Component
public class UserValidate implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        /* ---------- First name ---------- */
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            errors.rejectValue("firstName", "firstName.empty", "First name is required");
        } else if (user.getFirstName().length() < 5 || user.getFirstName().length() > 45) {
            errors.rejectValue("firstName", "firstName.length",
                    "First name must be between 5 and 45 characters");
        }

        /* ---------- Last name ---------- */
        if (user.getLastName() == null || user.getLastName().trim().isEmpty()) {
            errors.rejectValue("lastName", "lastName.empty", "Last name is required");
        } else if (user.getLastName().length() < 5 || user.getLastName().length() > 45) {
            errors.rejectValue("lastName", "lastName.length",
                    "Last name must be between 5 and 45 characters");
        }

        /* ---------- Phone number ---------- */
        String phoneRegex = "^0\\d{9}$"; // VD: 0901234567
        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
            errors.rejectValue("phoneNumber", "phone.empty", "Phone number is required");
        } else if (!Pattern.matches(phoneRegex, user.getPhoneNumber())) {
            errors.rejectValue("phoneNumber", "phone.invalid", "Phone number is invalid");
        }

        /* ---------- Age ---------- */
        if (user.getAge() == null) {
            errors.rejectValue("age", "age.empty", "Age is required");
        } else if (user.getAge() < 18) {
            errors.rejectValue("age", "age.invalid", "Age must be >= 18");
        }

        /* ---------- Email ---------- */
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            errors.rejectValue("email", "email.empty", "Email is required");
        } else if (!Pattern.matches(emailRegex, user.getEmail())) {
            errors.rejectValue("email", "email.invalid", "Email is invalid");
        }
    }
}
