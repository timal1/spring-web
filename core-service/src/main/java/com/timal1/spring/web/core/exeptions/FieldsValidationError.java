package com.timal1.spring.web.core.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldsValidationError {
    private List<String> errorFieldsMessages;
}
