package com.prueba.bytebuddyagent.executeagent;

import com.prueba.bytebuddyagent.MainClass;
import net.bytebuddy.agent.ByteBuddyAgent;

import java.nio.file.Paths;

public class ExecuteAgent {

    public ExecuteAgent(final String... args) {
        System.out.println();
        System.out.println("rubn");
        System.out.println("https://rubn0x52.com");

        if (args.length > 0 && args.length < 3) {
            try {
                String pid = args[0];
                String options = args.length >= 2 ? args[1] : null;

                String filename = MainClass.class.getProtectionDomain()
                        .getCodeSource()
                        .getLocation()
                        .toURI()
                        .getPath();

                ByteBuddyAgent.attach(Paths.get(filename).toFile().getAbsoluteFile(), pid, options);
                System.out.println("Attached to target jvm correctly");
                System.out.println();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Using 'jps' or 'jcmd' to list JVM PID`s.");
        }
    }

}
