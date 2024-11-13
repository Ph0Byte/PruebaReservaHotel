/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio.proyectoreserva.tools.process;

import inicio.proyectoreserva.tools.Mensaje;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author HP
 */
public class ProcesadorMensaje {
    
    public static void procesarClases(Class<?> clazz){
        if (clazz.isAnnotationPresent(Mensaje.class)) {
            Mensaje mensaje = clazz.getAnnotation(Mensaje.class);
            System.out.println("Mensaje de la clase: " + mensaje.valor());
        }
    }
    
    public static void  procesarMetodo(Class<?> clazz){
        for (Method method: clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Mensaje.class)) {
                Mensaje mensaje = method.getAnnotation(Mensaje.class);
                System.out.println("Mensaje de un metodo: "+ mensaje.valor());
            }
        }
    }
    
    public static void procesarAtributo(Class<?> clazz){
        for(Field field : clazz.getDeclaredFields()){
            if (field.isAnnotationPresent(Mensaje.class)) {
                Mensaje mensaje = field.getAnnotation(Mensaje.class);
                System.out.println("Mensaje desde un atributo: " + mensaje.valor());
            }
        }
    }
}
