package com.user.management.exception;

/**
 * 이미 존재하는 사용자에 대한 예외 처리 클래스입니다.
 *
 * @author jjunho50
 * @version 1.0.0
 */
public class UserAlreadyExistException extends RuntimeException {

    /**
     * 예외 발생 아이디를 가지는 생성자
     *
     * @param id 예외 발생 아이디
     */
    public UserAlreadyExistException(String id) {
        super(id + "는 이미 존재하는 유저 아이디 입니다.");
    }
}