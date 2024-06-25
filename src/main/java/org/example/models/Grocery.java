package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("0: Uygulamayı durdur\n1: Eleman ekle\n2: Eleman çıkar");
            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz (tek ya da virgülle ayrılmış):");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (tek ya da virgülle ayrılmış):");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                default:
                    System.out.println("Geçersiz giriş, lütfen tekrar deneyin.");
            }

            printSorted();
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            groceryList.remove(item);
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        HashSet<String> uniqueItems = new HashSet<>(groceryList);
        groceryList.clear();
        groceryList.addAll(uniqueItems);
        Collections.sort(groceryList);

        System.out.println("Grocery List:");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        startGrocery();
    }
}
