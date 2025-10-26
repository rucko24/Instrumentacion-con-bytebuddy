# Monkey patching log4shell

[log4shell-a-christmas-gift-jojojojojo/](https://rubn0x52.com/2021/12/26/log4shell-a-christmas-gift-jojojojojo/)

This branch can also be used for patching or dynamic attach aka monkey patching to a CVE vulnerable version **CVE-2021-44228**

Making instrumentation to the methods

- lookup
- convertJndiName

It is also possible to instrument only the lookup method by changing line 40 in the Agent class for

```java
.on(ElementMatchers.hasMethodName("lookup")))
```

---

## The Dockerfile

Other environments such as vulhub offer machines but do not have a more complete environment, and usually have very old versions of ubuntu.

This Dockerfile, mounts the complete vulnerable environment.

```dockerfile
FROM ubuntu:latest
RUN apt-get update && apt-get install -y wget && apt-get install -y ncat && apt-get install -y iputils-ping 
RUN wget https://repo.huaweicloud.com/java/jdk/8u181-b13/jdk-8u181-linux-x64.tar.gz \ 
	&& wget https://archive.apache.org/dist/lucene/solr/8.11.0/solr-8.11.0.tgz
RUN tar -xzf jdk-8u181-linux-x64.tar.gz && tar -xzf solr-8.11.0.tgz
ENV JAVA_HOME /jdk1.8.0_181
RUN rm jdk-8u181-linux-x64.tar.gz && rm solr-8.11.0.tgz
ENV PATH $PATH:$JAVA_HOME/bin
# Document port to use with docker run -ti -p 8983:8983
EXPOSE 8983
ENTRYPOINT ["/solr-8.11.0/bin/solr", "-f", "-force", "-p", "8983"]
```

## The premain

```bash
java -javaagent:agent-1.0.2-jar-with-dependencies.jar -jar vulnerable-target.jar
```

## The agentmain

```bash
java -jar /target/agent-1.0.2-jar-with-dependencies.jar PID
```
## IMPORTANT

It is important to have the `tools.jar` coming from the JDK, not the JRE (which does not work to run the agent).

```bash
2023-10-22 23:43:45.021 INFO  (main) [   ] o.a.s.m.r.SolrJmxReporter JMX monitoring for 'solr.jvm' (registry 'solr.jvm') enabled at server: com.sun.jmx.mbeanserver.JmxMBeanServer@7adda9cc
2023-10-22 23:43:45.022 INFO  (main) [   ] o.a.s.m.r.SolrJmxReporter JMX monitoring for 'solr.jetty' (registry 'solr.jetty') enabled at server: com.sun.jmx.mbeanserver.JmxMBeanServer@7adda9cc
2023-10-22 23:43:45.048 INFO  (main) [   ] o.a.s.c.CorePropertiesLocator Found 0 core definitions underneath /solr-8.11.0/server/solr
2023-10-22 23:43:45.079 INFO  (main) [   ] o.e.j.s.h.ContextHandler Started o.e.j.w.WebAppContext@5e2c3d18{/solr,file:///solr-8.11.0/server/solr-webapp/webapp/,AVAILABLE}{/solr-8.11.0/server/solr-webapp/webapp}
2023-10-22 23:43:45.089 INFO  (main) [   ] o.e.j.s.AbstractConnector Started ServerConnector@2fb3536e{HTTP/1.1, (http/1.1, h2c)}{0.0.0.0:8983}
2023-10-22 23:43:45.090 INFO  (main) [   ] o.e.j.s.Server Started @2029ms
Execute Agentmain method (1)

           ,@&@@
              &@@/*/#&
              *//*,,/*/*(
             **,*/***//**,#            #%##
              ,/,*/**/*,,**(,##   .%(***/*,*&&@@
               (*(,*,//*,/(**/*/*/(**/*,*/,/#&%@#&#%&&
                 ***/,/(/***,//*,***,////*(&%@#@%%%&&#(&&
                 /**/,/**,///**,(#((((*,%@&&&@@%&&%&@&%%&#%@
                .///*,****////**%#@&%@&@#@#@%&@%&%&(&@%&%@#&%@
             &(***,/(//*/,***,*,*#%%&@@&@%(%(**...*##@@&%@%%@#&
        ***//*,//*,,**%,/*,//**/*.,,*,,,/ ,*,,,,*/,**,./%&@#%%%%&
        (*/***,,/(/,/%@*(***//****,,.,,,.//,**.,,,**/,,*(,@%&%%#%&@&@@@@.
      @%%%%%&%&%&%&%@%,///**/(,,,,./***,*,.,,*,//.*,.,,****&#%%@@%%&%%#&%#&@
    #%&&#&&@&&&%@%&&&*/,/*//*/.*,.,,,.//*/***.,.*,,/*,*.,*./%&&&@@@%&&&#&&&#&
   .%%&&&&#/***%%&@@%%****,,*/&@@@/*.*,.,*,,*/&@@&*,,,*/*/.*%#&&@&*(,*/#&&@#%&
   #%@&&@((**#/%&%&%%(,*,//,**,*,,,**,/,/*,,**,**./*.,*.,,*@@%@(%&,/**((%%@&#&
    %&&&&@****//&%%&%%.*,,/,**.**.**,,@@@@@*/.**.,,**,*,,*%@&%&%&&*,*%/&#&&@&%
    #%@#%&&@&&%%&&%&&%,*,,,,,,,*/./*,*(#@&(.,*,/*,*.,.,*,/,/#@%%#&%@&%%@&%&%#
      %%@&@&%@&%&&&%@ ,*.**,@.,,.,,*,//,**.,,,.,*.*/&**,.*,*&%@&%@&&%@&&@%#.
         (/&&@&&@&@#&.*.,./,*@@/./*,,,,,,/.//.**./@&,//.**,,@@@%#%
                  %@%& /.*.,.*/%&@/,**,*,.,..*@&@%*.,*,*,*,%@&#%
                   /%@#&.**.,.*,,/*@@@@@@@@@@@&**,/*.*,,.#@%&&
                      %@&%,***,**,*.,,/.//,*/.,*,*,// &&%@&%
                        .#&@#&&..*///(#/*(#((/*  #&&@@@%&
                            @##@@&@@%@&&%@@%@&%@@&@/.
                                   %(%(*(&#%%

Starting monkey patching :D by rubn0x52.com

[Byte Buddy] REDEFINE BATCH #0 [1 of 1 type(s)]
[Byte Buddy] TRANSFORM org.apache.logging.log4j.core.lookup.JndiLookup [startJarLoader@497470ed, null, Thread[Attach Listener,9,system], loaded=true]
[Byte Buddy] REDEFINE COMPLETE 1 batch(es) containing 1 types [0 failed batch(es)]
OnEnter => public java.lang.String org.apache.logging.log4j.core.lookup.JndiLookup.lookup(org.apache.logging.log4j.core.LogEvent,java.lang.String)
OnEnter => private java.lang.String org.apache.logging.log4j.core.lookup.JndiLookup.convertJndiName(java.lang.String)
.log4j.core.lookup.JndiLookup is patched!!!
.log4j.core.lookup.JndiLookup is patched!!!
(2)
OnEnter => public java.lang.String org.apache.logging.log4j.core.lookup.JndiLookup.lookup(org.apache.logging.log4j.core.LogEvent,java.lang.String)
OnEnter => private java.lang.String org.apache.logging.log4j.core.lookup.JndiLookup.convertJndiName(java.lang.String)
.log4j.core.lookup.JndiLookup is patched!!!
.log4j.core.lookup.JndiLookup is patched!!!
(3)
2023-10-22 23:44:42.096 INFO  (qtp1083962448-25) [   ] o.a.s.s.HttpSolrCall [admin] webapp=null path=/admin/cores params={foo=Attack neutralized by agent} status=0 QTime=27
```
<1> Agentmain executed.

<2> Here the attacker's call was intercepted, but at the same time it is neutralized, because the lookUp method of the vulnerable JndiLookup class returns is this Attack neutralized by agent 😈 as String, zero invocations to any server.

<3> Already this GET by the attacker does not work.
