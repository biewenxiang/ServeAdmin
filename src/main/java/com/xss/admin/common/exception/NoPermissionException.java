package com.xss.admin.common.exception;

public class NoPermissionException extends RuntimeException {
    public NoPermissionException(String msg) {
        super(msg);
    }
}