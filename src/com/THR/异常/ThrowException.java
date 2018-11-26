package com.THR.“Ï≥£;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ThrowException {

    private static final Log log = LogFactory.getLog(ThrowException.class);

    public static void main(String args[]){
        try {
            throw new Exception("aaaaaaaaaaa");
        }catch (Exception e) {
            log.error("", e);
        }

    }
}
