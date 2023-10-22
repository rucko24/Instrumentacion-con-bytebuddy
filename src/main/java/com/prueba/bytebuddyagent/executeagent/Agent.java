package com.prueba.bytebuddyagent.executeagent;

import com.prueba.bytebuddyagent.advice.Log4ShellAdvice;
import com.prueba.bytebuddyagent.monkeybanner.ReadBanner;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * Agent with bytebuddy, to executing monkey patching
 */
public class Agent {

    private static final String TARGET_CLASS_JNDI_LOOKUP = ".log4j.core.lookup.JndiLookup";

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
                .ignore(ElementMatchers.none())
                .disableClassFormatChanges()
                .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
                .with(AgentBuilder.RedefinitionStrategy.Listener.StreamWriting.toSystemError())
                .with(AgentBuilder.Listener.StreamWriting.toSystemError().withErrorsOnly())
                .with(AgentBuilder.Listener.StreamWriting.toSystemError().withTransformationsOnly())
                .type(ElementMatchers.nameContains(TARGET_CLASS_JNDI_LOOKUP))
                .transform((builder, typeDescription, classLoader, module, protectionDomain) ->
                        builder.visit(Advice.to(Log4ShellAdvice.class)
                                .on(ElementMatchers.isMethod()))
                )
                .installOn(inst);
    }

}