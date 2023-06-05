package com.jhkwon91.hackingspringboot.reactive;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class KitchenService {
    public Flux<Dish> getDishes() {
        Flux<Dish> dish = Flux.generate(sink -> sink.next(randomDish()))
                .map(obj -> (Dish)obj)
                .delayElements(Duration.ofMillis(250));
        return dish;
    }


    private Dish randomDish() {
        return menu.get(picker.nextInt(menu.size()));
    }

    private List<Dish> menu = Arrays.asList(
            new Dish("Sesame chicken"),
            new Dish("Lo mein noodles, plain"),
            new Dish("Sweet & sour beef")
    );

    private Random picker = new Random();
}
