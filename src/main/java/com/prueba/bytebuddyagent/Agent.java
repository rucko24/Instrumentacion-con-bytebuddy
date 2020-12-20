package com.prueba.bytebuddyagent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 *
 * Agent with bytebuddy, execute premain method
 *
 */
public class Agent {

    private static final String TARGET_CONSTRUCTOR = "User";

    public static void premain(String args, Instrumentation inst) {
        System.out.println("premain");
        new AgentBuilder.Default()
                .with(new AgentBuilder.InitializationStrategy.SelfInjection.Eager())
                .with(AgentBuilder.Listener.StreamWriting.toSystemOut())
                .type((ElementMatchers.nameContains(TARGET_CONSTRUCTOR)))
                .transform((builder, typeDescription, classLoader, module) ->
                        builder.visit(Advice.to(MoreLifeAdvice.class)
                                .on(ElementMatchers.isConstructor()))
                )
                .installOn(inst);
    }
}