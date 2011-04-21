/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clevercloud.viadeo4j;

/**
 *
 * @author Julien Durillon
 */
public class ViadeoException extends Exception {

    public ViadeoException(Throwable cause) {
        super(cause);
    }

    ViadeoException(String message) {
        super(message);
    }
}
