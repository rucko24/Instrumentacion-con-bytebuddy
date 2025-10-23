package com.prueba.bytebuddyagent.executeagent;

import com.prueba.bytebuddyagent.advice.StringEqualsAdvice;
import com.prueba.bytebuddyagent.monkeybanner.ReadBanner;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * Agent with bytebuddy, to executing monkey patching
 */
public class Agent {

    public static void premain(String args, Instrumentation inst) {
        System.out.println("Execute premain method");
        ReadBanner.showBanner();
        transform(args, inst);
    }

    public static void agentmain(String args, Instrumentation inst) {
        System.out.println("Execute Agentmain method");
        ReadBanner.showBanner();
        transform(args, inst);
    }

    public static void transform(String args, Instrumentation inst) {
        new AgentBuilder.Default()
                .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
                .with(AgentBuilder.InitializationStrategy.NoOp.INSTANCE)
                .with(AgentBuilder.TypeStrategy.Default.REDEFINE)
                .disableClassFormatChanges()
                .ignore(ElementMatchers.nameStartsWith("net.bytebuddy."))
                .ignore(ElementMatchers.nameStartsWith("java."))
                .ignore(ElementMatchers.nameStartsWith("javax."))
                .ignore(ElementMatchers.nameStartsWith("sun."))
                .type(ElementMatchers.nameContains("CrackMe"))
                .transform((builder, typeDescription, classLoader, module, protectionDomain) ->
                        builder.visit(Advice.to(StringEqualsAdvice.class)
                                .on(ElementMatchers.named("actionPerformed")))
                )
                .installOn(inst);

        System.out.println("[+] Interceptor instalado en clases CrackMe");
        System.out.flush();
    }

}