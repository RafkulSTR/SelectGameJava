package models;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;


public class Sp_games implements Serializable {

    private ArrayList<Game> sp_games = new ArrayList<Game>();
    private String path = "sp_games.ser";
    public void AddGame(String name, double weight){
        int id = sp_games.size() + 1;
        Game game = new Game(id, name, weight);
        sp_games.add(game);
    }

    public void SaveGames(){
        if (sp_games != null)
        {
            StringBuilder filegamesstring = new StringBuilder();
            for (Game val: sp_games
                 ) {
                filegamesstring.append(val.getId()+" ");
                filegamesstring.append(val.getName()+" ");
                filegamesstring.append(val.getWeight());
                filegamesstring.append(System.lineSeparator());


            }
            // Используем try-with-resources для автоматического закрытия ресурсов
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                // Записываем содержимое StringBuilder в файл
                writer.write(filegamesstring.toString());
            } catch (IOException e) {
                // Обрабатываем возможные исключения, такие как IOException
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Game> LoadGames() throws IOException {
        Path path = Paths.get(this.path);
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла", e);
        }

        String[] lines = new String(bytes, StandardCharsets.UTF_8)
                .split("\\r?\\n");

        for (String val: lines
             ) {
            Game game;
            String[] str = val.split(" ");
            int id =  Integer.parseInt(str[0]);
            String name = str[1];
            Double weigth = Double.parseDouble(str[2]);
            game = new Game(id, name, weigth);
            sp_games.add(game);
        }

        return sp_games;



    }

    public Game PlayGames(){
       sp_games.sort(new GameComparatorWeigth());
       Game game = sp_games.get(sp_games.size()-1);
       sp_games.remove(sp_games.size()-1);
       SaveGames();
       return game;

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Game val: sp_games
             ) {
            stringBuilder.append("ID = " + val.getId() + " Имя игрушки - "+val.getName() +" Вес игрушки " + val.getWeight());
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }
}
