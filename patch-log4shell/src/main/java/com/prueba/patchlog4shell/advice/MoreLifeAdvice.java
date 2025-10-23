package com.prueba.patchlog4shell.advice;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.Origin;

import java.lang.reflect.Executable;

/**
 * Advice
 */
public class MoreLifeAdvice {

    @Advice.OnMethodEnter
    public static void onEnter(@Origin Executable method) {
        System.out.println("OnEnter Method => " + method);
    }

    @Advice.OnMethodExit
    public static void onExit(@Advice.FieldValue(value = "life", readOnly = false) int life) {
        life = 1000;
        System.out.println("OnExit Method return <= " + life);
    }

}