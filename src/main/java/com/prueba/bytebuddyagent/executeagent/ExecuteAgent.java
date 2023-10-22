package com.prueba.bytebuddyagent.executeagent;

import com.prueba.bytebuddyagent.MainClass;
import com.sun.tools.attach.VirtualMachine;
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
            showHelp();
        }
    }

    private static void showHelp() {
        System.out.println();
        System.out.println("List of eligible JVM PIDs (must be running as same user):");
        try {
            //FIXME using Runtime.getRuntime()
            listProcesses();
        } catch (NoClassDefFoundError err) {
            System.err.println("Error. Try using 'jps' or 'jcmd' to list Java processes.");
        }
        System.out.println();
    }

    public static void listProcesses() {
        VirtualMachine.list()
                .stream()
                .filter(vm -> true) //filter something
                .forEach(vm -> System.out.println(vm.id() + " \t" + vm.displayName()));
    }

}
