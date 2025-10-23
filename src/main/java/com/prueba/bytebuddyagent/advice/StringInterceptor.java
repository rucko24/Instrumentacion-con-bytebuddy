package com.prueba.bytebuddyagent.advice;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.This;

import java.util.concurrent.Callable;

public class StringInterceptor {

    public static boolean equalsIgnoreCase(@This String thiz,
                                           @AllArguments Object[] args,
                                           @SuperCall Callable<Boolean> zuper) throws Exception {
        boolean result = zuper.call();

        // Solo mostrar si es una comparación relevante (longitud razonable)
        if (thiz != null && thiz.length() > 10 && args.length > 0) {
            System.out.println("\n=== COMPARACIÓN DETECTADA ===");
            System.out.println("Valor esperado: " + thiz);
            System.out.println("Valor ingresado: " + args[0]);
            System.out.println("Resultado: " + (result ? "CORRECTO" : "INCORRECTO"));
            System.out.println("==============================\n");
        }

        return result;
    }
}