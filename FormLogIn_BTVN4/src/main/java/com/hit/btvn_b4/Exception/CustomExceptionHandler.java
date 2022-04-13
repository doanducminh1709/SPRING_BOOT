package com.hit.btvn_b4.Exception;
/*
Spring Boot sử dụng hai annotation @ControllerAdvice và
@ExceptionHandler bên trong để thực hiện bắt mọi Exception
xuất hiện bên trong ứng dụng

B2 sử dụng @ExceptionHandler để bắt lỗi truyền cái lỗi cần
bắt vào trong ngoặc () . Khi gặp lỗi này thì sẽ trả về
1 cái j đó mk cần cho hiển thị
@ResponseStatus là một định nghĩa Http Status trả về
cho người dùng . Khi một endpoint trên controller thực
thi thành công hay thất bại ,mặc đính spring sẽ gán Http
status code tương ứng trả về
//
ExceptionHandler : dùng để chỉ rõ method này xử lý Exception nào
@RestControllerAdvice
thường được kết hợp với @ExceptionHandler để cắt ngang quá trình
xử lý của Controller , và để xử lý ngoại lệ trong RestFul API
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleDuplicateException(NotFoundException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
