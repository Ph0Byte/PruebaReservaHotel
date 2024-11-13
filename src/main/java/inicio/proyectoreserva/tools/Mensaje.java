package inicio.proyectoreserva.tools;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author HP
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Mensaje {
    String valor() ;
}
