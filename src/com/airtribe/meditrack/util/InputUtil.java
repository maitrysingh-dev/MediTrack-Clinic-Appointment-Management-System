package com.airtribe.meditrack.util;

import java.time.LocalDateTime;
import java.util.Scanner;

public class InputUtil {

    public static String readString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: value cannot be empty");
                continue;
            }

            return input;
        }
    }

    public static String readEmail(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: email cannot be empty");
                continue;
            }

            if (!input.contains("@")) {
                System.out.println("Error: invalid email");
                continue;
            }

            return input;
        }
    }

    public static String readPhone(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: phone cannot be empty");
                continue;
            }

            if (!input.matches("\\d{10}")) {
                System.out.println("Error: phone must contain exactly 10 digits");
                continue;
            }

            return input;
        }
    }

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: value cannot be empty");
                continue;
            }

            try {
                int value = Integer.parseInt(input);

                if (value <= 0) {
                    System.out.println("Error: value must be greater than 0");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Error: please enter valid integer");
            }
        }
    }

    public static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: value cannot be empty");
                continue;
            }

            try {
                double value = Double.parseDouble(input);

                if (value <= 0) {
                    System.out.println("Error: value must be greater than 0");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Error: please enter valid decimal number");
            }
        }
    }

    public static LocalDateTime readDateTime(
            Scanner sc,
            String message
    ) {
        while (true) {
            try {
                System.out.println(message);

                System.out.print("Enter date (dd-MM-yyyy): ");
                String dateInput = sc.nextLine();

                java.time.format.DateTimeFormatter formatter =
                        java.time.format.DateTimeFormatter.ofPattern(
                                "dd-MM-yyyy"
                        );

                java.time.LocalDate date =
                        java.time.LocalDate.parse(
                                dateInput,
                                formatter
                        );

                int hour = readHour(sc, "Enter hour (0-23): ");
                int minute = readMinute(sc, "Enter minute (0-59): ");

                return LocalDateTime.of(
                        date.getYear(),
                        date.getMonthValue(),
                        date.getDayOfMonth(),
                        hour,
                        minute
                );

            } catch (Exception e) {
                System.out.println("Invalid date format.");
                System.out.println("Example: 02-05-2026");
            }
        }
    }

    public static <T extends Enum<T>> T readEnum(
            Scanner sc,
            String message,
            Class<T> enumClass
    ) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: value cannot be empty");
                continue;
            }

            try {
                return Enum.valueOf(enumClass, input.trim());

            } catch (Exception e) {
                System.out.println("Error: invalid option");
            }
        }
    }

    public static int readHour(
            Scanner sc,
            String message
    ) {
        while (true) {
            int hour = readInt(sc, message);

            if (hour < 0 || hour > 23) {
                System.out.println(
                        "Hour must be between 0 and 23"
                );
                continue;
            }

            return hour;
        }
    }

    public static int readMinute(
            Scanner sc,
            String message
    ) {
        while (true) {
            int minute = readInt(sc, message);

            if (minute < 0 || minute > 59) {
                System.out.println(
                        "Minute must be between 0 and 59"
                );
                continue;
            }

            return minute;
        }
    }
}