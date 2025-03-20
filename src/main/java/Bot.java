import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;


import java.io.File;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    // button for start


    //URL категории жидкого коллагена
    private String urlWebPageWithLiquidCategoryCollagen = "https://kollagen.life/product-category/pitevoj-kollagen";
    //Путь к файлу с html-кодом
    private String pathToFileWithHtmlCode = "src/main/resources/data/htmlCodeWebPage.html";

    private InlineKeyboardButton buttonForStart = InlineKeyboardButton.builder()
            .text("Нажмите для запуска")
            .callbackData("запуск")
            .build();

    private InlineKeyboardMarkup keyboardForButtonStart = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(buttonForStart))
            .build();

    // button for category
    private InlineKeyboardButton buttonForCategories = InlineKeyboardButton.builder()
            .text("Перейти в категории")
            .callbackData("категории")
            .build();

    // button for basket of user
    private InlineKeyboardButton buttonForMyBasket = InlineKeyboardButton.builder()
            .text("Моя корзина")
            .callbackData("корзина")
            .build();

    private InlineKeyboardMarkup keyboardForMenu = new InlineKeyboardMarkup().builder()
            .keyboardRow(List.of(buttonForCategories))
            .keyboardRow(List.of(buttonForMyBasket))
            .build();


    // button for category
    private InlineKeyboardButton buttonForLiquidCollagen = InlineKeyboardButton.builder()
            .text("Питьевой коллаген")
            .callbackData("питьевой коллаген")
            .build();

    // button for basket of user
    private InlineKeyboardButton buttonForPowderCollagen = InlineKeyboardButton.builder()
            .text("Коллаген в порошке")
            .callbackData("коллаген в порошке")
            .build();


    private InlineKeyboardButton buttonForTabletsCollagen = InlineKeyboardButton.builder()
            .text("Коллаген в таблетках")
            .callbackData("коллаген в таблетках")
            .build();

    private InlineKeyboardMarkup keyboardForAllCategories = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(buttonForTabletsCollagen))
            .keyboardRow(List.of(buttonForPowderCollagen))
            .keyboardRow(List.of(buttonForLiquidCollagen))
            .build();

    private InlineKeyboardButton buttonForBLACKMORESCollagenDrink = InlineKeyboardButton.builder()
            .text("BLACKMORES Collagen питьевой")
            .callbackData("collagen BLACKMORES")
            .build();

    private InlineKeyboardButton buttonForWHITEMORISColagenDrink = InlineKeyboardButton.builder()
            .text("WHITEMORES Collagen питьевой")
            .callbackData("collagen WHITEMORES")
            .build();

    private InlineKeyboardButton buttonForGREENMORISColagenDrink = InlineKeyboardButton.builder()
            .text("GreenMORES Collagen питьевой")
            .callbackData("collagen GREENMORES")
            .build();


    private InlineKeyboardButton buttonForPurpleMORISColagenDrink = InlineKeyboardButton.builder()
            .text("PurpleMORES Collagen питьевой")
            .callbackData("collagen PurpleMORES")
            .build();

    private InlineKeyboardButton buttonForOrangeMORISColagenDrink = InlineKeyboardButton.builder()
            .text("OrangeMORES Collagen питьевой")
            .callbackData("collagen ORANGEMORES")
            .build();


    private InlineKeyboardMarkup keyboardForDrinkCollagen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(buttonForBLACKMORESCollagenDrink))
            .keyboardRow(List.of(buttonForWHITEMORISColagenDrink))
            .keyboardRow(List.of(buttonForGREENMORISColagenDrink))
            .keyboardRow(List.of(buttonForPurpleMORISColagenDrink))
            .keyboardRow(List.of(buttonForOrangeMORISColagenDrink))
            .build();


    private InlineKeyboardButton buttonForOrangePOROSHOCKColagen = InlineKeyboardButton.builder()
            .text("Orange Collagen порошок")
            .callbackData("collagen ORANGEPOROSHOCK")
            .build();


    private InlineKeyboardButton buttonForGreenPOROSHOCKColagen = InlineKeyboardButton.builder()
            .text("Green Collagen порошок")
            .callbackData("collagen GREENPOROSHOCK")
            .build();


    private InlineKeyboardButton buttonForPurplePOROSHOCKColagen = InlineKeyboardButton.builder()
            .text("Purple Collagen порошок")
            .callbackData("collagen PURPLEPOROSHOCK")
            .build();


    private InlineKeyboardButton buttonForWhitePOROSHOCKColagen = InlineKeyboardButton.builder()
            .text("White Collagen порошок")
            .callbackData("collagen WHITEPOROSHOCK")
            .build();


    private InlineKeyboardButton buttonForBlackPOROSHOCKColagen = InlineKeyboardButton.builder()
            .text("Black Collagen порошок")
            .callbackData("collagen BLACKPOROSHOCK")
            .build();


    private InlineKeyboardMarkup keyboardForPoroshockCollagen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(buttonForOrangePOROSHOCKColagen))
            .keyboardRow(List.of(buttonForPurplePOROSHOCKColagen))
            .keyboardRow(List.of(buttonForWhitePOROSHOCKColagen))
            .keyboardRow(List.of(buttonForGreenPOROSHOCKColagen))
            .keyboardRow(List.of(buttonForBlackPOROSHOCKColagen))
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

    public int forGetPriceCollagenWithSelectedCategory(String captionCollagen, String urlWebPageWithCategoryCollagen) {
        int priceCollagen = 0;
        try {
            Document document = Jsoup.connect(urlWebPageWithLiquidCategoryCollagen).get();
            String strHtmlCode = String.valueOf(document);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return priceCollagen;
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

            if (callbackData.equals(buttonForStart.getCallbackData())) {
                editMessageText.setText("Выберите пункт меню");
                editMessageText.setReplyMarkup(keyboardForMenu);
            } else if (callbackData.equals(buttonForCategories.getCallbackData())) {
                editMessageText.setText("Выберите категории");
                editMessageText.setReplyMarkup(keyboardForAllCategories);
            } else if (callbackData.equals(buttonForLiquidCollagen.getCallbackData())) {
                editMessageText.setText("Выберите товар");
                editMessageText.setReplyMarkup(keyboardForDrinkCollagen);
            } else if (callbackData.equals(buttonForBLACKMORESCollagenDrink.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForBLACKMORESCollagenDrink.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/black.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (callbackData.equals(buttonForOrangeMORISColagenDrink.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForOrangeMORISColagenDrink.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/OrangeMories.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (callbackData.equals(buttonForWHITEMORISColagenDrink.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForWHITEMORISColagenDrink.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/Caallagens.webp")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (callbackData.equals(buttonForGREENMORISColagenDrink.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForGREENMORISColagenDrink.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/GreenCallagen.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (callbackData.equals(buttonForPurpleMORISColagenDrink.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForPurpleMORISColagenDrink.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/PurpleMories.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        else if (callbackData.equals(buttonForPowderCollagen.getCallbackData())) {
                editMessageText.setText("Выберите товар");
                editMessageText.setReplyMarkup(keyboardForPoroshockCollagen);
            }
            else if (callbackData.equals(buttonForPurplePOROSHOCKColagen.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForPurplePOROSHOCKColagen.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/PurpleMories.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

            else if (callbackData.equals(buttonForWhitePOROSHOCKColagen.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForWhitePOROSHOCKColagen.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/Caalagens.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }


            else if (callbackData.equals(buttonForWhitePOROSHOCKColagen.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForWhitePOROSHOCKColagen.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/Caalagens.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

            else if (callbackData.equals(buttonForPurplePOROSHOCKColagen.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForPurplePOROSHOCKColagen.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/PurpleMories.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

            else if (callbackData.equals(buttonForGreenPOROSHOCKColagen.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForGreenPOROSHOCKColagen.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/GreenCallagen.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

            else if (callbackData.equals(buttonForOrangePOROSHOCKColagen.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForOrangePOROSHOCKColagen.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/OrangeMories.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

            else if (callbackData.equals(buttonForBlackPOROSHOCKColagen.getCallbackData())) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setCaption(buttonForBlackPOROSHOCKColagen.getText());
                sendPhoto.setPhoto(
                        new InputFile(
                                new File("src/main/resources/data/black.jpg")
                        )

                );

                try {
                    execute(sendPhoto);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }


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
        return "7569642086:AAFo_emwlchv4TI6f7PiKXCMKvujnL8ExVI";
    }
}
