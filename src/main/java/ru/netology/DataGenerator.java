package ru.netology;





import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }
    public static String generateCity() {
        String[] city = new String[]{"Москва, Иркутск, Хабаровск, Краснодар, Красноярск, Владивосток, Уфа"};
        return city [new Random().nextInt(city.length)];
    }
    public static String generateName() {
        String name = Registration.faker.name().fullName();
        return name;
    }
    public static String generatePhone() {
        String phone = Registration.faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private static Faker faker;

        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            faker = new Faker(new Locale(locale));
            UserInfo user = new UserInfo(generateCity(), generateName(), generatePhone());
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
