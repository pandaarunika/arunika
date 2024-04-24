public static List<LocalDateTime> generateDateTimeRange(LocalDate startDate, LocalDate endDate) {
    List<LocalDateTime> dateTimeList = new ArrayList<>();

    // Iterate through each day in the range
    LocalDate currentDate = startDate;
    while (!currentDate.isAfter(endDate)) {
        // Convert current date to the start of the day (00:00:00)
        LocalDateTime startOfDay = currentDate.atStartOfDay();
        dateTimeList.add(startOfDay);

        // Convert current date to the end of the day (23:59:59)
        LocalDateTime endOfDay = currentDate.atTime(LocalTime.MAX);
        dateTimeList.add(endOfDay);

        // Move to the next day
        currentDate = currentDate.plusDays(1);
    }

    return dateTimeList;
}

public static void main(String[] args) {
    // Define the date range
    LocalDate startDate = LocalDate.parse("2024-04-01");
    LocalDate endDate = LocalDate.parse("2024-04-05");

    // Generate the list of LocalDateTime instances
    List<LocalDateTime> dateTimeList = generateDateTimeRange(startDate, endDate);

    // Print the list
    for (LocalDateTime dateTime : dateTimeList) {
        System.out.println(dateTime);
    }
}
