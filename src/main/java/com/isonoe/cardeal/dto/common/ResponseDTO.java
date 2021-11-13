package com.isonoe.cardeal.dto.common;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@SuperBuilder(builderMethodName = "defaultBuilder")
public class ResponseDTO implements Serializable {

    @Getter
    @Setter
    private Integer statusCode;

    @Getter
    @Setter
    private String userMessage;

    @Getter
    @Setter
    private String developerMessage;

    private List<String> details;

    private List<String> successMessages;
    private List<String> errorMessages;

    public List<String> getDetails() {
        if (ObjectUtils.isEmpty(details)) {
            this.details = new ArrayList<String>();
        }
        return details;
    }

    public List<String> getSuccessMessages() {
        if (ObjectUtils.isEmpty(successMessages)) {
            this.successMessages = new ArrayList<String>();
        }
        return successMessages;
    }

    public List<String> getErrorMessages() {
        if (ObjectUtils.isEmpty(errorMessages)) {
            this.errorMessages = new ArrayList<String>();
        }
        return errorMessages;
    }
}
