package Service;

import models.Sp_games;
import view.InterfaceUser;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    Sp_games sp_games = new Sp_games();
    InterfaceUser iu = new InterfaceUser();
    private Scanner scanner;
    private boolean work = true;
    public MainMenu() throws IOException {
        scanner = new Scanner(System.in);
        sp_games.LoadGames();
    }

    public void StartMenu() throws IOException {

        while (work){
            ViewMenu();
            String com = scanner.nextLine();
            switch (com){
                case "1":{
                    sp_games.AddGame(iu.InputName(), iu.InputWeight());
                    break;}
                case "2":{
                    sp_games.LoadGames();
                    System.out.println(sp_games.toString());
                    break;}
                case "3":{
                    sp_games.SaveGames();
                    System.out.println(sp_games.toString());
                    break;}
                case "4":{
                    System.out.println(sp_games.toString());
                    break;}
                case "5":{
                    System.out.println(sp_games.PlayGames());
                    break;}
                case "10": {
                    work = false;
                    System.out.println("Досвидание");
                    break;
                }
            }
        }
    }

    private void ViewMenu(){
        System.out.println("Введите команду");
        System.out.println("1 - Добавить игрушку");
        System.out.println("2 - Загрузить из файла");
        System.out.println("3 - Сохранить в файл");
        System.out.println("4 - Просмотреть игрушки");
        System.out.println("5 - Вытащить игрушку");

        System.out.println("10 - Выход");
    }

    private void SaveFile(){
        sp_games.SaveGames();
        sp_games.toString();
        System.out.println("Файл успешно сохранен");
    }



}
