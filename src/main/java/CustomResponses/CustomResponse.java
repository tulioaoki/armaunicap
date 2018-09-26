package CustomResponses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tulioaoki
 */
public class CustomResponse {
    private Object detail;
    private boolean success;
    private int status_code;
    private String message;
    
    @JsonCreator
    public CustomResponse(
             @JsonProperty("detail") Object detail,
             @JsonProperty("success") boolean success,
             @JsonProperty("status_code") int status_code,
             @JsonProperty("message") String message)
    {
        this.detail = detail;
        this.success = success;
        this.status_code = status_code;
        this.message = message;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}