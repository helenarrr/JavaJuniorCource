package org.example.lesson1_StreamApi.seminar.Program2;

import org.example.lesson1_StreamApi.seminar.UMarket;

import java.util.Scanner;

public class Program {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UMarket market = new UMarket();
        System.out.println("Добро пожаловать в магазин U-Market");

        while (true)
        {
            System.out.println("================================================================");
            System.out.println("0 - Завершение работы приложения");
            System.out.println("1 - Отобразить полный список товаров");
            System.out.println("2 - Сформировать онлайн корзину из снеков");
            System.out.println("3 - Сформировать онлайн корзину из полуфабрикатов");
            System.out.println("4 - Сформировать онлайн корзину из продуктов для приготовления");
            System.out.println("5 - Сформировать онлайн корзину из любых продовольственные товаров");
            System.out.println("Выберите пункт меню: ");

            if (scanner.hasNextInt())
            {
                int no = scanner.nextInt();
                scanner.nextLine();
                switch (no) {
                    case 0 -> {
                        System.out.println("Завершение работы приложения.");
                        return;
                    }
                    case 1 -> {
                        System.out.println("Список товаров:");
                        market.printThings(Thing.class);
                    }
                    case 2 -> CreateCart(Snack.class, market);
                    case 3 -> CreateCart(SemiFinishedFood.class, market);
                    case 4 -> CreateCart(HealthyFood.class, market);
                    case 5 -> CreateCart(Food.class, market);
                    default -> System.out.println("Пункт меню не существует.\nПожалуйста, повторите попытку ввода.");
                }
            }
            else{
                System.out.println("Некорректный пункт меню.\nПожалуйста, повторите попытку ввода.");
                scanner.nextLine();
            }

        }

    }

    static <T extends Food> void CreateCart(Class<T> clazz, UMarket market) {
        Cart<T> cart = new Cart<>(clazz, market);

        while (true) {
            System.out.println("Список доступных товаров: ");
            System.out.println("[0] Завершение формирования корзины + балансировка");
            market.printThings(clazz);
            System.out.println("Укажите номер товара для добавления");

            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                if (no == 0) {
                    cart.cardBalancing();
                    System.out.println("Ваша корзина содержит продукты");
                    cart.printFoodstuffs();
                    return;
                } else {
                    T thing = market.getThingByIndex(clazz, no);
                    if (thing == null) {
                        System.out.println("Некорректный номер товара. Пжл, повторите попытку ввода");
                        continue;
                    }
                    cart.getFoodstuffs().add(thing);
                    System.out.println("Товар успешно добавлен в корзину");
                    System.out.println("Ваша корзина содержит продукты: ");
                    cart.printFoodstuffs();
                }

            } else {
                System.out.println("Некорректный пункт меню. Пжл, повторите попытку ввода: ");
                scanner.nextLine();
            }
        }
    }
}

