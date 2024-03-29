package com.user.management.handler;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Runtime 예외 처리를 위한 전역 예외 핸들러 입니다.
 * 모든 컨트롤러에서 발생하는 RuntimeException을 처리합니다.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    /**
     * RuntimeException을 처리하는 메소드입니다.
     * 발생한 예외의 메시지, 상태 코드, 발생 시간을 JSON 형태로 응답 본문에 포함하여 반환합니다.
     *
     * @param e 발생한 RuntimeException
     * @return 응답 본문에 에러 정보를 담은 ResponseEntity
     * @throws JSONException JSON 객체 생성 시 발생할 수 있는 예외
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException e) throws JSONException {

        JSONObject errorDetails = new JSONObject();
        try {
            errorDetails.put("title", e.getMessage());
            errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
            errorDetails.put("timestamp", LocalDateTime.now().toString());
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

        return new ResponseEntity<>(errorDetails.toString(4), HttpStatus.BAD_REQUEST);
    }


}