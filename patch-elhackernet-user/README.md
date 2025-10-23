# Instrumentation with ByteBuddy

Here a simple example with the use of bytebuddy is done
instrumentation to the constructor of a class at runtime by changing the value of a variable.

Executing the premain and agentmain method

[Instrumentation-with-bytebuddy-execute-premain-method](https://rubn0x52.com/2020/10/06/instrumentation-with-bytebuddy-execute-premain-method/)

```bash
Usuario: pran-u375177
```

## The premain method

![](https://rubn0x52.com/assets/images/maximoPuntajeLogrado.png)

## The agentmain method

To implement a class, as in this case, `elhacker.User`, this class is loaded before our agent implements.

The only way it works is that we load our agent just when it asks for the user's ID. 

## Instrument User class inside Program class

![image](https://github.com/rucko24/Instrumentacion-con-bytebuddy/assets/17187599/9516b4c3-15dd-46a1-af09-9595a3b6afa0)

(1) The User instance is not yet instantiated, so the dialog input is displayed.

(2) Here, the user instance is created.

## When the instrumentation works

Point (1)

The class to implement is not yet instantiated, and allows us to load our agent, the `User class` is loaded in the main main method, but without instantiating, at that time if we load our agent the instrumentation works.

![instrument-user-class](https://github.com/rucko24/Instrumentacion-con-bytebuddy/blob/master/src/main/resources/instrumented-correctly-user-class.png?raw=true)

## When the instrumentation has not been applied

Point (2)

The User instance has been loaded to the JVM before our agent, so we cannot implement it.

![no-instrumentation](https://github.com/rucko24/Instrumentacion-con-bytebuddy/blob/master/src/main/resources/no-instrumentation-applied.png)

And there, the instrumentation will be applied to the User class.




