package com.bigpicture.moonrabbit.global.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
  
    // throw는 예외를 발생시키기위해 사용함
    public static void UserAlreadyExistsException() {
        throw new CustomException(ErrorCode.USER_ALREADY_EXISTS);
    }

    public void UserNotFoundException() {
        throw new CustomException(ErrorCode.USER_NOT_FOUND);
    }
}
