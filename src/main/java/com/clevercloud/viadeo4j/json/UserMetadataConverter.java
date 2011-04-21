package com.clevercloud.viadeo4j.json;

import com.clevercloud.viadeo4j.models.UserMetadata;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien Durillon
 */
public class UserMetadataConverter implements JsonDeserializer<UserMetadata> {

    @Override
    public UserMetadata deserialize(JsonElement je, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (je.getAsJsonObject().get("type") != null && UserMetadata.TYPE.equals(je.getAsJsonObject().get("type").getAsString())) {
            Iterator<Entry<String, JsonElement>> it = je.getAsJsonObject().entrySet().iterator();
            UserMetadata company = new UserMetadata();

            Gson g = new Gson();
            Class c = company.getClass();
            while (it.hasNext()) {
                Entry<String, JsonElement> entry = it.next();
                try {
                    Field f = c.getDeclaredField(entry.getKey());
                    Boolean b = f.isAccessible();
                    f.setAccessible(true);
                    f.set(company, g.fromJson(entry.getValue(), f.getType()));
                    f.setAccessible(b);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchFieldException ex) {
                    if (company.getUnknownField() == null) {
                        company.setUnknownField(new HashMap<String, String>());
                    }
                    company.getUnknownField().put(entry.getKey(), entry.getValue().toString());
                } catch (SecurityException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
            return company;
        } else {
            throw new JsonParseException("The given json has not 'USER' for 'type' field's value.");
        }
    }
}
