package Interactive.sales.system;

// Точка входа в программу, вносим сюда числа для расчёта,потом открывает отсюда файл и потом создаёт результат.

import Interactive.sales.system.processor.OrderProcessor;


public class Main {

        public static void main(String[] args) throws Exception {
    // String filePath = "C:\\Users\\user\\IdeaProjects\\Планировщик задач приложение\\gfree\\Hibernate Example\\Interactive-sales-system\\discount_day.txt";

            OrderProcessor.process("discount_day.txt", 10.0, 50.0, 5.0);

            System.out.println("Результат в result.txt");
        }
    }
