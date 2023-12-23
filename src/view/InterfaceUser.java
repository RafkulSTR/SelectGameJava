package view;

import java.util.Scanner;

public class InterfaceUser {
    private Scanner  scanner;

    public InterfaceUser(){
        scanner = new Scanner(System.in);
    }
    public String InputName(){
        System.out.println("Введите имя игрушки");
        return scanner.nextLine();
    }

    public Double InputWeight(){
        System.out.println("Введите вес игрушки");
        return Double.parseDouble(scanner.nextLine());
    }



}
