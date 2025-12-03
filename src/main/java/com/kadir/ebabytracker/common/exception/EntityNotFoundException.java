package com.kadir.ebabytracker.common.exception;

public class EntityNotFoundException extends RuntimeException{

    private final String resourceName;
    private final Object resourceId;

    public EntityNotFoundException (String resourceName, Object resourceId){
        super(resourceName+ "not found with id :" + resourceId);
        this.resourceId = resourceId;
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Object getResourceId() {
        return resourceId;
    }
}
