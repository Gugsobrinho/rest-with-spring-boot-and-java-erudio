package br.com.erudio.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String menssage, String details) {

}
