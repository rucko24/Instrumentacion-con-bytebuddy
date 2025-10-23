package com.prueba.patchlog4shell;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
class ByteBuddyAgentTest {

    @Test
    void test() throws IOException {
        ByteBuddyAgent.install();
        ClassReloadingStrategy classReloadingStrategy = ClassReloadingStrategy.fromInstalledAgent();
        new ByteBuddy()
                .redefine(Foo.class)
                .method(ElementMatchers.named("getHello"))
                .intercept(FixedValue.value("Byte Buddy!"))
                .make()
                .load(Foo.class.getClassLoader(), classReloadingStrategy);

        final Foo foo = new Foo();
        Assertions.assertEquals(foo.getHello(), "Byte Buddy!");
        classReloadingStrategy.reset(Foo.class);
        Assertions.assertEquals(foo.getHello(), "Hola");
    }

    static class Foo {

        public String getHello() {
            return "Hola";
        }
    }

    @DisplayName("Instrumented MyProgram2")
    @Test
    void testMyProgram() throws IOException {
        ByteBuddyAgent.install();
        ClassReloadingStrategy classReloadingStrategy = ClassReloadingStrategy.fromInstalledAgent();
        new ByteBuddy()
                .redefine(MyProgram2Test.class)
                .method(ElementMatchers.named("getLife"))
                .intercept(FixedValue.value(500))
                .make()
                .load(MyProgram2Test.class.getClassLoader(), classReloadingStrategy);

        final MyProgram2Test myProgram2Test = new MyProgram2Test();
        Assertions.assertEquals(myProgram2Test.getLife(), 500);
//        classReloadingStrategy.reset(Foo.class);
//        assertThat(myProgram2Test.getHello(), is("Hola"));
    }

    static class MyProgram2Test {

        public Integer getLife() {
            return 100;
        }
    }

}


