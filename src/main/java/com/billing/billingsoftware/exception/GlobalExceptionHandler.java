package com.billing.billingsoftware.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 THIS IS GLOBAL EXCEPTION HANDLER CLASS.
 THIS CLASS IS USED TO HANDLE ALL EXCEPTIONS IN ONE PLACE.

 USING @ControllerAdvice, SPRING AUTOMATICALLY CALLS THIS CLASS
 WHEN ANY EXCEPTION OCCURS IN CONTROLLER OR SERVICE LAYER.

 THIS HELPS TO SEND PROPER ERROR MESSAGE AND STATUS CODE TO CLIENT.
*/

@ControllerAdvice   // TELLS SPRING THIS CLASS WILL HANDLE GLOBAL EXCEPTIONS
public class GlobalExceptionHandler {

    /*
     HANDLES RESOURCE NOT FOUND EXCEPTION
     THIS IS USED WHEN CUSTOMER / PRODUCT / INVOICE ID IS NOT FOUND
     RETURNS 404 NOT FOUND STATUS
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /*
     HANDLES INSUFFICIENT STOCK EXCEPTION
     THIS IS USED WHEN PRODUCT STOCK IS LESS THAN REQUIRED QUANTITY
     RETURNS 400 BAD REQUEST STATUS
     */
    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<String> handleStockException(InsufficientStockException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /*
     HANDLES ALL OTHER GENERAL EXCEPTIONS
     USED AS FALLBACK ERROR HANDLER
     PRINTS REAL ERROR IN CONSOLE FOR DEBUGGING
     RETURNS 500 INTERNAL SERVER ERROR STATUS
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex) {
        ex.printStackTrace();   // PRINT REAL ERROR IN CONSOLE
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
