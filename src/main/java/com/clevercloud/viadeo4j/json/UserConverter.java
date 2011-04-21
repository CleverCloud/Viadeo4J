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
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, "parsing the field {0} => ''{1}''", new Object[]{entry.getKey(), entry.getValue() == null ? "" : entry.getValue().toString()});

                    Field f = c.getDeclaredField(entry.getKey());
                    Boolean b = f.isAccessible();
                    f.setAccessible(true);
                    if (Date.class.equals(f.getType())) {
                        DateFormat df = new SimpleDateFormat("yyyy-dd-mm hh:mm:ssZ");

                        StringBuffer sb = new StringBuffer(entry.getValue().getAsString());
                        sb.replace(sb.lastIndexOf(":"), sb.lastIndexOf(":")+1, "").replace(sb.indexOf("T"), sb.indexOf("T") +1, " ");

                        System.out.println(sb.toString());

                        f.set(user, df.parse(sb.toString()));
                    } else {
                        f.set(user, jdc.deserialize(entry.getValue(), f.getType()));
                    }

                    f.setAccessible(b);
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, "end parsing");
                } catch (ParseException ex) {
                    Logger.getLogger(UserConverter.class.getName()).log(Level.SEVERE, null, ex);
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
