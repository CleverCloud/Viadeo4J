/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j.json;

import com.clevercloud.viadeo4j.models.Location;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien Durillon
 */
public class LocationConverter implements JsonDeserializer<Location> {

    @Override
    public Location deserialize(JsonElement je, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "begin deserialize location");
        Iterator<Entry<String, JsonElement>> it = je.getAsJsonObject().entrySet().iterator();
        Location company = new Location();

        Gson g = new Gson();
        Class c = company.getClass();
        while (it.hasNext()) {
            Entry<String, JsonElement> entry = it.next();
            try {
                Field f = c.getDeclaredField(entry.getKey());
                Boolean b = f.isAccessible();
                f.setAccessible(true);

                if ((entry.getKey().equals("latitude") || entry.getKey().equals("longitude")) && entry.getValue().getAsString().isEmpty()) {
                    f.set(company, 0D);
                } else {
                    f.set(company, g.fromJson(entry.getValue(), f.getType()));
                }

                f.setAccessible(b);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
        return company;
    }
}
