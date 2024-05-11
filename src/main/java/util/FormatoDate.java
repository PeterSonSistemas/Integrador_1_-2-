/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import CodigoEstructura.peter.unmsm.javabasico.sixcar.s.a.c.util.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JESSY
 */
public class FormatoDate {
    
    //convertir de DATE a String
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public static Date FechaParse(String fechastring){
        try {
            return sdf.parse(fechastring);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static String FechaFormat(Date fecha){
            return sdf.format(fecha);
    }
    
    
    
}
