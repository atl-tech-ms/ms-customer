package az.atl.customerms.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class SaveCustomerDto {

    @Size(min = 3, max = 50, message = "Name Required - The name must be between 3 and 50 characters.")
    String fullName;
    @NotNull(message = "Age Required")
    Integer age;
    @NotBlank(message = "Pin Required")
    String pin;
    @NotNull(message = "Balance Required")
    BigDecimal balance;
}
