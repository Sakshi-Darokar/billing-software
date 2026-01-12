package com.billing.billingsoftware.exception;

/*
 THIS IS CUSTOM EXCEPTION CLASS FOR INSUFFICIENT STOCK.

 THIS EXCEPTION IS THROWN WHEN USER TRIES TO GENERATE BILL
 BUT PRODUCT STOCK IS LESS THAN REQUIRED QUANTITY.

 THIS HELPS TO STOP BILL GENERATION AND SEND PROPER ERROR MESSAGE.
*/

public class InsufficientStockException extends RuntimeException {

    /*
     CONSTRUCTOR TO PASS CUSTOM ERROR MESSAGE
     */
    public InsufficientStockException(String message) {
        super(message);
    }
}
