package com.ycu.wedding.pojo.customClass;

public class ApiResponse {
    private boolean success;
    private int code;
    private Object data;
    private String message;

    public ApiResponse() {}

    public ApiResponse(boolean success, int code, Object data, String message) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static ApiResponse success(Object data, String message) {
        return new ApiResponse(true, 200, data, message);
    }

    public static ApiResponse failure(int code, String message) {
        return new ApiResponse(false, code, null, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
