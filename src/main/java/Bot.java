import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class Bot extends TelegramLongPollingBot {
    // button for start

    private InlineKeyboardButton buttonForStart = InlineKeyboardButton.builder()
            .text("Нажмите для запуска")
            .callbackData("запуск")
            .build();

    private InlineKeyboardMarkup keyboardForButtonStart = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(buttonForStart))
            .build();

    @Override
    public void onUpdateReceived(Update update) {
        forWorkWithText(update);
        forWorkWithButtons(update);
    }


    public void forWorkWithText(Update update) {
        if (update.hasMessage()) {
            Long userId = update.getMessage().getFrom().getId();
            SendMessage sendMessage = SendMessage.builder()
                    .chatId(userId)
                    .text("Вас приветсвует тг-бот\n +" +
                            "интернет магазин kollagen.life =)")
                    .replyMarkup(keyboardForButtonStart)
                    .build();
            try {
                execute(sendMessage);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void forWorkWithButtons(Update update) {
        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            Long chatId = update.getCallbackQuery().getMessage().getChatId();
            Integer messageId = update.getCallbackQuery().getMessage().getMessageId();

            EditMessageText editMessageText = EditMessageText.builder()
                    .chatId(chatId)
                    .messageId(messageId)
                    .text("")
                    .build();

            try {
                execute(editMessageText);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "@dajva324bot";
    }

    @Override
    public String getBotToken() {
        return "7569642086:AAHZgGLmMoI0lYApX--tyemCpOH7oIyX-YI";
    }
}
