package com.prueba.lycrackme.advice;

import net.bytebuddy.asm.Advice;

public class StringEqualsAdvice {

    @Advice.OnMethodEnter
    public static void enter(@Advice.This Object thiz) {
        System.out.println("\n[*] Botón Validar presionado!");
        System.out.flush();
        try {
            // Extraer todos los campos del ActionListener anónimo
            java.lang.reflect.Field[] fields = thiz.getClass().getDeclaredFields();
            for (java.lang.reflect.Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(thiz);
                if (value instanceof String) {
                    String str = (String) value;
                    // La clave correcta será un string largo (hash SHA1 + número)
                    if (field.getName().contains("easte")) {
                        System.out.println("Clave encontrada");
                        System.out.println("Campo: " + field.getName());
                        System.out.println("Clave: " + str);
                        System.out.flush();
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("[!] Error extrayendo campos: " + e.getMessage());
            e.printStackTrace();
        }
    }

}