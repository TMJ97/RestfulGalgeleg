package main.java.galgeleg;

import io.javalin.Context;
import io.javalin.Handler;
import org.apache.commons.lang3.StringUtils;


public class GalgelegRest {
    public static Handler restGetOrdet = new Handler() {
        @Override
        public void handle(Context context) throws Exception {
            final GalgelegImpl spil = new GalgelegImpl();
            spil.hentOrdFraDr();
            context.json(spil.getOrdet());
        }
    };


    public static Handler restGæt = new Handler() {
        @Override
        public void handle(Context context) throws Exception {
            String ordet = context.queryParam("ordet");
            String bogstav = context.queryParam("bogstav");
            boolean correct = ordet.contains(bogstav);
            int count = correct ? StringUtils.countMatches(ordet, bogstav) : 0;
            context.json("{correct: " + correct + ", count: " + count + ";}");
        }
    };


    public static Handler restLogin = new Handler() {
        @Override
        public void handle(Context context) throws Exception {
            final GalgelegImpl spil = new GalgelegImpl();
            String username = context.queryParam("username");
            String password = context.queryParam("password");
            spil.login(username, password);
            context.json(spil.isLoggedIn());
        }
    };
}
