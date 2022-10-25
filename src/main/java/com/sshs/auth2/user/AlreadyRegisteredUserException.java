package com.sshs.auth2.user;

/**
 * @author hanseongsan
 *
 * 유저 관련 Exception
 */
public class AlreadyRegisteredUserException extends RuntimeException {
    public AlreadyRegisteredUserException() { super("이미 존재하는 유저입니다."); }
}
