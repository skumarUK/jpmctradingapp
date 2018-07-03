/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.Utils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import co.uk.jp.trading.constants.TradingAction;
import co.uk.jp.trading.model.Instruction;
/**
 * This class is used to load daily trading instructions sent by various
 * clients to JPMorgan Daily Trading Reporting Engine Service.
 * This uses class path resource to find the file at specified path.
 */
public class LoadDailyTradingInstructions {

    public static Set<Instruction> loadDailyTradingInstructions(String url){
        InputStream is = LoadDailyTradingInstructions.class.getClassLoader().getResourceAsStream(url);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String json = reader.lines().collect(Collectors.joining("\n"));
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(TradingAction.class, new InstructionTypeDeserializer());
        Gson gson = gsonBuilder.create();
        Instruction[] data = gson.fromJson(json, Instruction[].class);
        return new HashSet<>(Arrays.asList(data));
    }

    static class InstructionTypeDeserializer implements JsonDeserializer<TradingAction>
    {
        @Override
        public TradingAction deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
            TradingAction[] scopes = TradingAction.values();
            return Arrays.stream(scopes).filter(a->a.getValue().equalsIgnoreCase(json.getAsString())).
                findFirst().orElse(null);
        }
    }
}
