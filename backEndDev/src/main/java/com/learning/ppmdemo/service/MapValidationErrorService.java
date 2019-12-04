package com.learning.ppmdemo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> mapValidationErrorService(BindingResult result){

        if(result.hasErrors()){

            List<FieldError> errorList = result.getFieldErrors();
            Map<String, String> errorMessageMap = new HashMap<>();

            for (FieldError error : errorList){
                errorMessageMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMessageMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
