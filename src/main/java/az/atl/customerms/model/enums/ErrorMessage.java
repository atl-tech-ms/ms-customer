package az.atl.customerms.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    CUSTOMER_NOT_FOUND("Customer not found with id: %d");

    private final String message;

    public String format(Object... args) {
        return String.format(message, args);
    }
}
