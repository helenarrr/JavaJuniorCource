package org.example.lesson1_StreamApi.seminar;

import org.example.lesson1_StreamApi.seminar.Program2.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class UMarket {
    private final Collection<Thing> things;

    public UMarket() {
        things = new ArrayList<>();
        initializeThings();
    }

    public <T extends Thing> void printThings(Class<T> clazz) {
//        int index = 1;
//        for (var thing : things) {
//            if (clazz.isInstance(thing)) {
//                if (Food.class.isAssignableFrom(thing.getClass())) {
//                    System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, thing.getName(), ((Food) thing).getProteins() ? "Да" : "Нет",
//                            ((Food) thing).getFats() ? "Да" : "Нет", ((Food) thing).getCarbohydrates() ? "Да" : "Нет");
//
//                } else {
//                    System.out.printf("[%d] %s\n", index++, thing.getName());
//                }
//            }
//        }

        int[] i = {1};

        things.stream()
                .filter(clazz::isInstance)
                .forEach(thing -> {
                    {
                        if (Food.class.isAssignableFrom(thing.getClass())) {
                            Food foodThing = (Food) thing;
                            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                                    i[0]++, thing.getName(),
                                    foodThing.getProteins() ? "Да" : "Нет",
                                    foodThing.getFats() ? "Да" : "Нет",
                                    foodThing.getCarbohydrates() ? "Да" : "Нет");

                        } else {
                            System.out.printf("[%d] %s\n", i[0]++, thing.getName());
                        }
                    }

                });
    }


    public <T extends Thing> T getThingByIndex(Class<T> clazz, int index) {
        AtomicInteger cnt = new AtomicInteger(1);
        return things.stream()
                .filter(clazz::isInstance)
                .filter(thing -> index == cnt.getAndIncrement())
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }

    public <T extends Thing> Collection<T> getThings(Class<T> clazz)
    {
      return things.stream()
              .filter(clazz::isInstance)
              .map(clazz::cast)
              .toList();
    }

    private void initializeThings() {

        things.add(new Pen());


        things.add(new Chicken());
        things.add(new Fruit());
        things.add(new OliveOil());

        things.add(new BalykCheese());
        things.add(new Crisps());
        things.add(new ChocolateBar());

        things.add(new DumplingsBerries());
        things.add(new DumplingMeat());
        things.add(new Cheburek());
    }


}
