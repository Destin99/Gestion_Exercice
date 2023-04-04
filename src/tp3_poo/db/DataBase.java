/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.db;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gyldas_atta_kouassi
 */
public class DataBase {

    private static final List<Object> DATALIST = new ArrayList<>();

    public static void create(Object data) throws Exception {
        DATALIST.add(data);
    }

    public static <T extends Object> List<T> read(Class<T> dataClass) throws Exception {
        return (List<T>) DATALIST
                .stream()
                .filter((t) -> {
                    return (t.getClass().equals(dataClass));
                })
                .collect(Collectors.toList());
    }

    public static <T, K> T findById(Class<T> dataClass, K id) throws Exception {
        Field idField = dataClass.getDeclaredFields()[0];
        idField.setAccessible(true);
        T result = (T) DATALIST
                .stream()
                .filter((t) -> {
                    try { return (t.getClass().equals(dataClass)) && idField.get(t).equals(id);} 
                    catch (IllegalArgumentException | IllegalAccessException ex) {return false;}
                })
                .findFirst()
                .get();
        idField.setAccessible(false);
        return result;
    }

    public static <T extends Object> T update(T data) throws Exception {
        return (T) DATALIST.set(DATALIST.indexOf(data), data);
    }
}
