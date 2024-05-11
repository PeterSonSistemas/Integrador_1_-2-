/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import CodigoEstructura.peter.unmsm.javabasico.sixcar.s.a.c.util.*;

/**
 *
 * @author Timothy
 */
public class StringsUtil {

    // Esta función recibe una cadena y un número máximo de caracteres permitidos.
// Si la longitud de la cadena excede el número máximo de caracteres,
// la función la trunca y añade puntos suspensivos al final para indicar que ha sido truncada.
// Si la longitud de la cadena es menor o igual al número máximo de caracteres,
// la función la devuelve sin modificar.
    public static String truncateString(String str, int maxLength) {
        if (str.length() > maxLength) {
            // Si la longitud de la cadena es mayor que maxLength,
            // truncamos la cadena y añadimos puntos suspensivos al final
            return str.substring(0, maxLength - 3) + "...";
        } else {
            // Si la longitud de la cadena es menor o igual a maxLength,
            // no necesitamos truncarla, así que la devolvemos tal como está
            return str;
        }
    }

}
