package com.hit.btvn_b4.Exception;

public class DuplicateException extends RuntimeException{
    //bởi vì lỗi này sẽ phát sinh trong thời gian chạy (runtime exception nên mk phải kế thừa nó vào)
    public DuplicateException(String message){
        super(message);//ta sẽ kế thừa lại cái lỗi này và để hiển thị ra
    }
}
