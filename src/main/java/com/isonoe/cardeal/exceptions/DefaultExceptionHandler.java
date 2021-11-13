package com.isonoe.cardeal.exceptions;


import com.isonoe.cardeal.dto.common.ErrorResponseDTO;
import lombok.Getter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

public class DefaultExceptionHandler extends Exception {

    @Getter private final ErrorResponseDTO errorResponse = new ErrorResponseDTO();

    public DefaultExceptionHandler(Integer httpCode) {
        this.errorResponse.setStatusCode(httpCode);
    }

    public DefaultExceptionHandler(Integer httpCode, String userMessage) {
        super(userMessage);
        this.errorResponse.setStatusCode(httpCode);
        this.errorResponse.setUserMessage(userMessage);
        this.errorResponse.setDeveloperMessage(userMessage);
    }

    public DefaultExceptionHandler(Integer httpCode, String userMessage, Throwable cause) {
        super(userMessage, cause);
        this.errorResponse.setStatusCode(httpCode);
        this.errorResponse.setUserMessage(userMessage);
        this.errorResponse.setDeveloperMessage(ExceptionUtils.getStackTrace(cause));
    }

    public DefaultExceptionHandler(Integer httpCode, String userMessage, String developerMessage, Throwable cause) {
        super(userMessage, cause);
        this.errorResponse.setStatusCode(httpCode);
        this.errorResponse.setUserMessage(userMessage);
        this.errorResponse.setDeveloperMessage(developerMessage);
        this.errorResponse.getDetails().add(ExceptionUtils.getStackTrace(cause));
    }

    public DefaultExceptionHandler(Throwable cause) {
        super(cause);
        this.errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        this.errorResponse.setUserMessage("Operação inválida! Ocorreu um erro ao executar a operação.");
        this.errorResponse.setDeveloperMessage(ExceptionUtils.getStackTrace(cause));
    }
}