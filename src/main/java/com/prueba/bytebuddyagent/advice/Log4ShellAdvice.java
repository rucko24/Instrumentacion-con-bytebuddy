package com.prueba.bytebuddyagent.advice;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.Origin;

import java.lang.reflect.Executable;

/**
 * Advice for patching Log4Shell
 */
public class Log4ShellAdvice {

    @Advice.OnMethodEnter(skipOn = String.class )
    static String onEnter(@Origin Executable executable) {

        System.out.println("OnEnter => " + executable);

        return "Attack neutralized by agent";
    }

    @Advice.OnMethodExit
    static void onExit(@Advice.Enter String enter, @Advice.Return(readOnly = false) String pacthString) {
        System.out.println(".log4j.core.lookup.JndiLookup is patched!!!");

    }
}