package org.example;

import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.PublishProcessor;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        // Создаем Observable
//        Observable<String> observable = Observable.create(emitter -> {
//            Scanner scanner = new Scanner(System.in);
//            String input;
//            do {
//                System.out.println("Введите значение (для завершения введите 'exit'):");
//                input = scanner.nextLine();
//                emitter.onNext(input); // Отправляем значение в поток
//            } while (!input.equals("exit"));
//            scanner.close();
//            emitter.onComplete(); // Завершаем поток
//        });
//
//        // Подписываемся на Observable
//        observable
////                .takeUntil(event -> event == "exit")
//                .map(event -> Integer.parseInt(event))
////                .all(number -> number < 10)
//                .buffer(2)
//                .subscribe(
//                s -> System.out.println("Получено: " + s),
//                throwable -> System.err.println("Ошибка: " + throwable.getMessage()),
//                () -> System.out.println("Последовательность завершена!")
//        );

        Observable.just("Hello, world!")
                .subscribeOn(Schedulers.io()) // Где будет происходить подписка -  Операция будет выполнена в потоке ввода/вывода
                .observeOn(Schedulers.computation()) // Где будет выполняться результата следующий операторов - Результат будет обработан в потоке вычислений
                .map(s -> s + " - processed") // Пример операции над элементом Observable
                .observeOn(Schedulers.single()) // Результат будет обработан в однопоточном пуле
                .subscribe(System.out::println); // Подписываемся на Observable и выводим результат в консоль


// Приостанавливаем основной поток на 2 секунды, чтобы дать время Observable выполниться
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}