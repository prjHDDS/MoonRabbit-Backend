package com.bigpicture.moonrabbit.exception;

public class UserAlreadyExistsException extends CustomException {
    public UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
