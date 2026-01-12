package com.billing.billingsoftware.exception;

/*
 THIS IS CUSTOM EXCEPTION CLASS FOR RESOURCE NOT FOUND.

 THIS EXCEPTION IS THROWN WHEN:
 - CUSTOMER ID IS NOT FOUND
 - PRODUCT ID IS NOT FOUND
 - INVOICE ID IS NOT FOUND

 THIS HELPS TO SEND PROPER ERROR MESSAGE TO CLIENT
 INSTEAD OF SHOWING CONFUSING SERVER ERROR.
*/

public class ResourceNotFoundException extends RuntimeException {

    /*
     CONSTRUCTOR TO PASS CUSTOM ERROR MESSAGE
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
