package com.prueba.bytebuddyagent;

import lombok.extern.log4j.Log4j2;
import net.bytebuddy.asm.Advice;

/**
 * Advice
 */
@Log4j2
public class MoreLifeAdvice {

    @Advice.OnMethodExit
    static void giveMeMoreLife(@Advice.FieldValue(value = "attack", readOnly = false) int attack,
                               @Advice.FieldValue(value = "life", readOnly = false) int life,
                               @Advice.FieldValue(value = "speed",readOnly = false) float speed,
                               @Advice.FieldValue(value = "shootSpeed",readOnly = false) float shootSpeed,
                               @Advice.FieldValue(value = "shootDelay",readOnly = false) int shootDelay,
                               @Advice.FieldValue(value = "name",readOnly = false) String name)

            throws Exception {
        life = 1000;
        System.out.println("New life set to" + life);
        attack = 1000;
        speed = 100f;
        shootSpeed = 10f;
        shootDelay = 10;
        name = "LaViejaRubena";
    }
}