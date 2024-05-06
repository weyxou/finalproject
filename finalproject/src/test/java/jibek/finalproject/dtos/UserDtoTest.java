package jibek.finalproject.dtos;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDtoTest {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void testValidUserDTO() {
        UserDTO userDTO = UserDTO.builder()
                .id(1L)
                .name("John Doe")
                .email("john@example.com")
                .build();
        assertTrue(validator.validate(userDTO).isEmpty());
    }

    @Test
    public void testInvalidUserDTO() {
        UserDTO userDTO = UserDTO.builder()
                .id(1L)
                .name("")
                .email("invalidemail")
                .build();
        assertFalse(validator.validate(userDTO).isEmpty());
    }
}
