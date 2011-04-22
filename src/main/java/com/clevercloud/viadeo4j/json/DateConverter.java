/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clevercloud.viadeo4j.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Date;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

/**
 *
 * @author Julien Durillon
 */
public class DateConverter implements JsonDeserializer<Date> {

    private static DateTimeFormatter crapyViadeoDateFormatter = new DateTimeFormatterBuilder().appendYear(4, 4).appendLiteral('-').
       appendMonthOfYear(2).appendLiteral('-').
       appendDayOfMonth(2).appendLiteral('T').
       appendHourOfDay(2).appendLiteral(':').
       appendMinuteOfHour(2).appendLiteral(':').
       appendSecondOfMinute(2).appendTimeZoneOffset(null, true, 2, 2).toFormatter();

    @Override
    public Date deserialize(JsonElement je, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return crapyViadeoDateFormatter.parseDateTime(je.getAsString()).toDate();
    }
}
