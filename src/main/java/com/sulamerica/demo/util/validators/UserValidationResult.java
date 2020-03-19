package com.sulamerica.demo.util.validators;

import java.util.ArrayList;
import java.util.List;

public class UserValidationResult {
    public boolean isValid;
    public List<String> errors;

    public UserValidationResult() {
        this.isValid = false;
        this.errors = new ArrayList<String>();
    }
}