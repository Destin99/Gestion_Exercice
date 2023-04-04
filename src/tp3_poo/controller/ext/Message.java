/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.controller.ext;

/**
 *
 * @author gyldas_atta_kouassi
 */
public class Message {
    
    private String message;
    private Type type;

    public Message(String message, Type type) {
        this.message = message;
        this.type = type;
    }
    
    public enum Type {
        INFO,
        ERROR,
        FATAL;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
}
