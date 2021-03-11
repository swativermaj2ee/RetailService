package com.target.myretail.retail.exception;

public class UpdateFailedException extends Exception{
    String msg;
    public UpdateFailedException(String msg){
        this.msg=msg;
    }

}
