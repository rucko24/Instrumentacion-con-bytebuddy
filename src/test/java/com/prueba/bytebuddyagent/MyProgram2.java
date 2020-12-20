package com.prueba.bytebuddyagent;

import lombok.Data;

@Data
public class MyProgram2 {

    private static Usuario USUARIO = new Usuario();

    public MyProgram2() {}

    public int getLife() {
        return USUARIO.getLife();
    }

}
