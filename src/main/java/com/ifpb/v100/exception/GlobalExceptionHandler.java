package com.ifpb.v100.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.ifpb.v100.dto.ErroResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponseDTO> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();

        //Erro de sintaxe de JSON quebrado (ex: chave não fechada, vírgula sobrando)
        if (cause instanceof JsonParseException) {
            ErroResponseDTO erro = new ErroResponseDTO("INVALID_JSON", "O corpo da requisição não é um JSON válido.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
        }

        //Erro de tipo de dados (ex: String no lugar de número) ou campo incompatível
        if (cause instanceof InvalidFormatException || cause instanceof MismatchedInputException) {
            ErroResponseDTO erro = new ErroResponseDTO("INVALID_INPUT", "Os campos 'a' e 'b' devem ser números.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
        }

        //Fallback para falhas de leitura genéricas do parser
        ErroResponseDTO erro = new ErroResponseDTO("INVALID_JSON", "O corpo da requisição não é um JSON válido.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {
        ErroResponseDTO erro = new ErroResponseDTO("INVALID_INPUT", "Os campos 'a' e 'b' são obrigatórios.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponseDTO> handleGenericException(Exception ex) {
        ErroResponseDTO erro = new ErroResponseDTO("INTERNAL_ERROR", "Ocorreu um erro interno no servidor.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}