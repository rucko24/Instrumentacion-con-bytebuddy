package com.prueba.bytebuddyagent;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Unit test for simple App.
 */
@Slf4j
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
        assertThat(foo.getHello(), is("Byte Buddy!"));
        classReloadingStrategy.reset(Foo.class);
        assertThat(foo.getHello(), is("Hola"));
    }

    static class Foo {

        public String getHello() {
            return "Hola";
        }
    }

}


