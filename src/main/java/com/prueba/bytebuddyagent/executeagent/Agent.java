package com.prueba.bytebuddyagent.executeagent;

import com.prueba.bytebuddyagent.advice.StringInterceptor;
import com.prueba.bytebuddyagent.monkeybanner.ReadBanner;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;

import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * Agent with bytebuddy, to executing monkey patching
 */
public class Agent {

    public static void premain(String args, Instrumentation inst) {
        System.out.println("Execute premain method");
        transform(args, inst);
    }

    public static void agentmain(String args, Instrumentation inst) {
        System.out.println("Execute Agentmain method");
        ReadBanner.showTheMonkey("banner.txt");
        transform(args, inst);
    }

    public static void transform(String args, Instrumentation inst) {
        new AgentBuilder.Default()
                .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
                .disableClassFormatChanges()
                .type(ElementMatchers.is(String.class))
                .transform((builder, typeDescription, classLoader, module, protectionDomain) ->
                        builder.method(ElementMatchers.named("equalsIgnoreCase"))
                                .intercept(MethodDelegation.to(StringInterceptor.class))
                )
                .installOn(inst);
        System.out.println("[+] Interceptor instalado en String.equalsIgnoreCase");

    }

}