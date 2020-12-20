package com.prueba.bytebuddyagent;

import lombok.Data;

@Data
public class Usuario {

    private int life= 10;

    public Usuario() {

    }

    public int getLife() {
        return life;
    }

    @Override
    public String toString() {
        return "Hi";
    }

}
