package com.aston.project.view;

import java.util.Scanner;

/**
 * Класс View предоставляет методы для чтения и записи строки в консоль
 */
public class View {

    private final Scanner scanner = new Scanner(System.in);

    public String read(){
        return scanner.nextLine();
    }

    public void write(String message){
        System.out.println(message);
    }
}
