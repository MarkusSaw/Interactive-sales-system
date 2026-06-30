package Interactive.sales.system;

//Точка входа в программу,открывает отсюда файл и потом создаёт результат.

import Interactive.sales.system.service.Service;


public class Main {

        public static void main(String[] args) throws Exception {
    // String filePath = "C:\\Users\\user\\IdeaProjects\\Планировщик задач приложение\\gfree\\Hibernate Example\\Interactive-sales-system\\discount_day.txt";

            Service.process("discount_day.txt");

            System.out.println("Результат в result.txt");
        }
    }
