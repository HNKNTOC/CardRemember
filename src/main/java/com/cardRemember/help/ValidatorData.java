package com.cardRemember.help;

import com.cardRemember.model.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Help validation data for view.
 */
public class ValidatorData {
    private static final Logger LOGGER = LogManager.getLogger(ValidatorData.class);

    private List<CustomValidator> validatorList = new ArrayList<>();

    public void addCustomValidator(CustomValidator customValidator) {
        validatorList.add(customValidator);
    }

    public void romeveCustomValidator(CustomValidator customValidator) {
        validatorList.remove(customValidator);
    }

    /**
     * Data validation all CustomValidator.
     *
     * @param data Data for validation.
     * @throws FailedValidation If data fails validation.
     */
    public void validation(Data data) throws FailedValidation {
        for (CustomValidator customValidator : validatorList) {
            if (!customValidator.validation(data)) {
                failed(data, customValidator);
            }
        }
    }

    /**
     * Use if validation failed.
     * Throws FailedValidation
     *
     * @param data            Data which failed validation.
     * @param customValidator CustomValidator which checked.
     * @throws FailedValidation Always.
     */
    private void failed(Data data, CustomValidator customValidator) throws FailedValidation {
        FailedValidation failedValidation = new FailedValidation(String.format(
                "This %s fails validation by the validator %s Read more: %s",
                data,
                customValidator,
                customValidator.getLastException()));

        LOGGER.warn(failedValidation);
        throw failedValidation;
    }

    /**
     * Need to add new custom checks.
     */
    public interface CustomValidator {
        /**
         * Custom validation for data.
         *
         * @param data Data for validation.
         * @return true if validation successful.
         */
        boolean validation(Data data);

        String getLastException();
    }

}
