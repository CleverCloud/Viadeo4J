/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j.json;

import com.clevercloud.viadeo4j.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.DateTimeAtCompleted;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

/**
 *
 * @author Julien Durillon
 */
public class UserConverter implements JsonDeserializer<User> {

    @Override
    public User deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        if (je.getAsJsonObject().get("type") != null && User.TYPE.equals(je.getAsJsonObject().get("type").getAsString())) {
            Iterator<Entry<String, JsonElement>> it = je.getAsJsonObject().entrySet().iterator();
            User user = new User();
            Class c = user.getClass();
            while (it.hasNext()) {
                Entry<String, JsonElement> entry = it.next();
                try {
                    Field f = c.getDeclaredField(entry.getKey());
                    Boolean b = f.isAccessible();
                    f.setAccessible(true);
                    f.set(user, jdc.deserialize(entry.getValue(), f.getType()));

                    f.setAccessible(b);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchFieldException ex) {
                    if (user.getUnknownField() == null) {
                        user.setUnknownField(new HashMap<String, String>());
                    }
                    user.getUnknownField().put(entry.getKey(), entry.getValue().toString());
                } catch (SecurityException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
            return user;
        } else {
            throw new JsonParseException("The given json has not 'USER' for 'type' field's value.");
        }

    }
}
