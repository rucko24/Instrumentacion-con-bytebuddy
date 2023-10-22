package com.prueba.bytebuddyagent.executeagent;

import com.prueba.bytebuddyagent.advice.MoreLifeAdvice;
import com.prueba.bytebuddyagent.monkeybanner.ReadBanner;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * Agent with bytebuddy, to executing monkey patching
 */
public class Agent {

    private static final String TARGET_CLASS_MY_PROGRAM_2 = ".prueba.bytebuddyagent.MyProgram2";
    private static final String TARGET_CLASS_USER = "User";
    private static final String TARGET_CLASS_PLAYER = "Player";

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
                .type(ElementMatchers.nameContains(TARGET_CLASS_USER))
                .transform((builder, typeDescription, classLoader, module, protectionDomain) ->
                        builder.visit(Advice.to(MoreLifeAdvice.class)
                                .on(ElementMatchers.isConstructor()))
                )
                .installOn(inst);
    }

}