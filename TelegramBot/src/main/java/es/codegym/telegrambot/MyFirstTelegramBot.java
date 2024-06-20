package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Locale;
import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "Sam4432_bot";
    public static final String TOKEN = "7205978684:AAHXuQgP0btZQvf1vY0y-zoBeGo4x8ysd0w";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if(getMessageText().equals("/start")){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera","step_1_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_1_btn")){

            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("!Tomar una salchicha¡* 20 de  fama","step_2_btn",
                            "!Tomar un pescado¡ *20 de fama","step_2_btn",
                            "!Tirar una lata de pepinillos¡ *20 de fama","step_2_btn"));

        }
        if(getCallbackQueryButtonKey().equals("step_2_btn")){

            sendPhotoMessageAsync("step_3_pic");

            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("!Romper al Robot Aspiradora!","step_3_btn"));

        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")){

            sendPhotoMessageAsync("step_4_pic");
            setUserGlory(30);
            sendTextMessageAsync( STEP_4_TEXT,
                    Map.of("!Enviar al Robot por comida¡* 30 de  fama","step_4_btn",
                            "!Dar un paseo encima del robot¡ *30 de fama","step_4_btn",
                            "!Huir del robot¡ *30 de fama","step_4_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")){


            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("!Agarrar la Go Pro¡*30 de fama","step_5_btn",
                            "!Grabar en la Go Pro¡*30 de fama","step_5_btn",
                            "!jugar!*30 de fama", "step_5_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_5_btn")){

            sendPhotoMessageAsync("step_6_pic");

            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Dame  mi vaso de leche","step_6_btn",
                            "Quiero atunsito","step_6_btn",
                            "Me subo en tu cama","step_6_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_6_btn")){

            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear la computadora","step_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")){

            sendPhotoMessageAsync("step_8_pic");

            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("MIAUUU....","step_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")){
            sendPhotoMessageAsync("final_pic");

            sendTextMessageAsync(FINAL_TEXT);}








    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}