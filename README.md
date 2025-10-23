# Summary

There are currently only 3 agents, where we apply both static and dynamic instrumentation, with `bytebuddy`.

- [*patch game elhacker.net:*](https://github.com/rucko24/Instrumentacion-con-bytebuddy/tree/master/patch-elhackernet-user)
- [*patch Log4Shell*](https://github.com/rucko24/Instrumentacion-con-bytebuddy/tree/master/patch-log4shell)
- [*patch LyCrackMe:*](https://github.com/rucko24/Instrumentacion-con-bytebuddy/tree/master/patch-lycrackme)

## How to create agents

At the moment use jdk8 (example: `corretto-1.8.0_462`) to create the compilation, because the `tools.jar` is necessary, and for these examples we use it.

```sh
[INFO] Reactor Summary:
[INFO] 
[INFO] InstrumentacionByteBuddyInstallOn 1.0.0 ............ SUCCESS [  0.390 s]
[INFO] patch-log4shell 1.0.2 .............................. SUCCESS [  2.835 s]
[INFO] patch-lycrackme 1.0.0 .............................. SUCCESS [  0.832 s]
[INFO] patch-elhackernet-user 1.0.0 ....................... SUCCESS [  0.763 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.950 s
[INFO] Finished at: 2025-10-23T21:43:59+02:00
[INFO] ------------------------------------------------------------------------
```
