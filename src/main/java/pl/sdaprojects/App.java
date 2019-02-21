package pl.sdaprojects;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class App {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\mkoty\\IdeaProjects\\dataprocessing\\src\\main\\resources\\users.txt");

        List<User> users = new ArrayList<User>();

        List<User> women = new ArrayList<User>();
        List<User> men = new ArrayList<User>();

        List<Book> books = new ArrayList<Book>();

        try (LineIterator fileContents = FileUtils.lineIterator(file, "UTF-8")) {

            while (fileContents.hasNext()) {

                String[] line = fileContents.nextLine().split(" ");
                users.add(new User(line[0], line[1], Integer.valueOf(line[2])));
                //Integer.valueOf(line[2]))); w tym miejscu zmienia String na int
            }
        }
        for (User user : users) {
            System.out.println(user);
        }


        for (User user : users) {
            if (user.getFirstname().endsWith("a") && user.getAge() >= 18) {
                women.add(user);
            } else if (!user.getFirstname().endsWith("a") && user.getAge() >= 18) {
                men.add(user);
            }
        }
        //w tym miejscu(wyżej) powinno być dwa razy if, ale tak też może być
        System.out.println(women);
        System.out.println(men);

        List<Book> book = Arrays.asList(new Book("Ksiazka 1", BigDecimal.valueOf(3.55), true),
                new Book("DKsiazka 2", BigDecimal.valueOf(4.55), true),
                new Book("BKsiazka 3", BigDecimal.valueOf(5.55), false),
                new Book("CKsiazka 4", BigDecimal.valueOf(6.55), false),
                new Book("AKsiazka 5", BigDecimal.valueOf(7.55), false),
                new Book("Ksiazka 1", BigDecimal.valueOf(7.55), false));

        System.out.println(book);

        Collections.sort(book);

        System.out.println(book);


        File file1 = new File("C:\\Users\\mkoty\\IdeaProjects\\dataprocessing\\src\\main\\resources\\weather-data.csv");

        List<Weather> listaTemperatury = new ArrayList<>();

        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("M/D/YYYY");

        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj date w formacie M/D/YYYY");
        String dataOdUzytkownika = scanner.nextLine();

        LineIterator fileContents = FileUtils.lineIterator(file1, "UTF-8");
        while (fileContents.hasNext()) {
            String[] line = fileContents.nextLine().split(",");

            try {
                int max_temp = Integer.valueOf(line[1]);
                int mean = Integer.valueOf(line[2]);
                int min_temp = Integer.valueOf(line[3]);

                listaTemperatury.add(new Weather(line[0], max_temp, mean, min_temp));
            } catch (NumberFormatException blad) {
            }
        }
        for (Weather weather : listaTemperatury) {
            boolean czyJestData = weather.getDate().equals(dataOdUzytkownika);
            if (czyJestData) {
                System.out.println(weather);
            }
        }
    }

}





















































































































