# Monkey patching LyCrackMe

- actionPerformed, when the user clicks on the button, the value of the variable is investigated. `_$$r_easte`

---

## The premain

```bash
java -javaagent:agent-1.0.0-jar-with-dependencies.jar -jar vulnerable-target.jar
```

## The agentmain

```bash
java -jar /target/agent-1.0.0-jar-with-dependencies.jar PID
```
## IMPORTANT.

It is important to have the `tools.jar` coming from the JDK, not the JRE (which does not work to run the agent).

```bash
java -javaagent:agent-1.0.0.jar -jar Ly-CrackME.jar <1>
Execute premain method
██████████████████████ Ly-Crackme @Leyer ██████████████████▓▓█
█████████████████████▓▓▓▓▓▓█▓▓▓▒▓▓▒▓▓▓▓▓▓██████████████▓███▓██
███████ Key: ███                                       ███████
██████▓▒░░▒▓▓▓█ X=231231321 ███(Validar)██████████████▓███████
█████████████████████▓███▓▓███▓███████████████████████████████
███████████████▓▒▓▓█▓░▒▒▒▒▒▓▓▒▒█▓▓▓▓▒▒▒▒▒▒▓▓▓█████████████████
██████████████████████████████████████████████████████████████
██████████████████████████████████████████████████████████████

Starting monkey patching :D by rubn0x52.com

[+] Interceptor instalado en clases CrackMe

[*] Botón Validar presionado!
Clave encontrada
Campo: val$_$$r_easte
Clave: 6ff173f14d9384c6b897b4be810e5699ca997e18.0 <2>

[*] Botón Validar presionado!
Clave encontrada
Campo: val$_$$r_easte
```
<1> Premain executed.
<2> Key found!
