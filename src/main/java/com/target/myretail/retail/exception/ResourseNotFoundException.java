package com.target.myretail.retail.exception;

public class ResourseNotFoundException extends Exception{
    String msg;
    public ResourseNotFoundException(String msg){
        this.msg=msg;
    }
}
