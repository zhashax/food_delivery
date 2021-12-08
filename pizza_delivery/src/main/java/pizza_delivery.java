import Model.Food;
import foods.Beverages;
import foods.Burgers;
import foods.Fries;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

public class pizza_delivery extends TelegramLongPollingBot {


    Food food = new Food();
    public Food chicken_burger = new Burgers("Chicken burger",600);
    public Food beef_burger = new Burgers("Beef burger",800);
    public Food coke = new Beverages("Coke",200);
    public Food sprite = new Beverages("Sprite",190);
    public Food fanta = new Beverages("Fanta",200);
    public Food fry = new Fries("Fry",450);


    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        String command = update.getMessage().getText();
        SendMessage response = new SendMessage();

        new Thread(()->{
            switch (command){
                case "/start":
                    setStart(update.getMessage().getChatId().toString());
                    break;
                case "Exit":
                    Exit(update.getMessage().getChatId().toString());
                    break;
            case "Burger":
                Burgers_type(update.getMessage().getChatId().toString());
                break;
            case "Beverages":
                Beverages_type(update.getMessage().getChatId().toString());
                break;
            case "Fries":
                Fries_type(update.getMessage().getChatId().toString());
                break;
            case "Calculate final price":
                Calculated_result(update.getMessage().getChatId().toString());
                break;

            default:
                setStart(update.getMessage().getChatId().toString());
        }
        }).start();
        new Thread(()->{
            if (command.equals(beef_burger.toString())){
                System.out.println("beef burger added");
                food.addProductPrice(beef_burger.getPrice());}
            if (command.equals(chicken_burger.toString())){
                System.out.println("chicken burger added");
                food.addProductPrice(chicken_burger.getPrice());}
            if (command.equals(coke.toString())){
                System.out.println("coke added");
                food.addProductPrice(coke.getPrice());}
            if (command.equals(sprite.toString())){
                System.out.println("sprite added");
                food.addProductPrice(sprite.getPrice());}
            if (command.equals(fanta.toString())){
                System.out.println("fanta added");
                food.addProductPrice(fanta.getPrice());}
            if (command.equals(fry.toString())){
                System.out.println("fry added");
                food.addProductPrice(fry.getPrice());}

        }).start();

    }

    public void Calculated_result(String chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("You total price - " + food.getResult() + "tg\nYour Order Will be Delivered!\nBye");
        try {
            execute(message);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    public void Exit(String chatId){
        SendMessage message = new SendMessage();
        food.setResult(0);
        message.setChatId(chatId);
        message.setText("Your order is cancelled\nTotal price - " + food.getResult() + "tg");
        try {
            // Send the message
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void setStart(String chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Choose food:");
        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);

        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();


        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add("Burger");
        row.add("Beverages");
        row.add("Fries");
        // Add the first row to the keyboard
        keyboard.add(row);

        // Create another keyboard row
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Calculate final price");
        row.add("Exit");

        // Add the second row to the keyboard
        keyboard.add(row);
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        try {
            // Send the message
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void Beverages_type(String chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Please, choose beverage");
        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);

        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();


        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add(new Food("Coke",200).toString());
        row.add(new Food("Sprite",190).toString());
        row.add(new Food("Fanta",200).toString());
        // Add the first row to the keyboard
        keyboard.add(row);

        // Create another keyboard row
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Exit");

        // Add the second row to the keyboard
        keyboard.add(row);
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        try {
            // Send the message
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void Fries_type(String chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Please, choose fry:");
        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);

        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();


        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add(new Food("Fry",450).toString());

        // Add the first row to the keyboard
        keyboard.add(row);

        // Create another keyboard row
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Exit");

        // Add the second row to the keyboard
        keyboard.add(row);
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        try {
            // Send the message
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void Burgers_type(String chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Please, choose burger");
        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);

        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();


        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add(chicken_burger.toString());
        row.add(beef_burger.toString());
        // Add the first row to the keyboard
        keyboard.add(row);

        // Create another keyboard row
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Calculate final price");
        row.add("Exit");

        // Add the second row to the keyboard
        keyboard.add(row);
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        try {
            // Send the message
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }




    // return the human readable name of the bot
    public String getBotUsername() {
        return "pizza_waiter_bot";
    }

    // return secret for authentication
    public String getBotToken() {
        return "5083765639:AAEyX9dX1wdM9bTceDV8dt7zJFVdPXR_CHQ";
    }

}
