package com.yourname.skillsharehub.exception;

/**
 * Custom exception to be thrown when a requested resource is not found.
 */
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    /**
     * Constructs a new ResourceNotFoundException with detailed information.
     *
     * @param resourceName Name of the resource (e.g., "User").
     * @param fieldName    Name of the field used to search (e.g., "email").
     * @param fieldValue   Value of the field that was not found (e.g., "john@example.com").
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        // Call the superclass constructor first with the formatted message
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));

        // Then assign the subclass fields
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    // Getters (optional, based on your needs)
    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
