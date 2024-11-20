package extraChallenge;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


// Solution 1: Using Java Streams and Collectors -> Less efficient because the json file is stored in memory and doesn't complete all the operations in parallel
public class WeatherAnalyzerOption1 {

    public static void analyzeWeatherData() throws IOException {

        // Load weather data from JSON file
        InputStream inputStream = WeatherAnalyzerOption1.class.getClassLoader().getResourceAsStream("weather.json");

        if (inputStream == null) {
            throw new IOException("File not found");
        }

        // Object to convert JSON to Java objects and vice versa
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON file and convert to list of Weather objects
        List<Weather> records = mapper.readValue(
                inputStream,
                mapper.getTypeFactory().constructCollectionType(List.class, Weather.class)
        );

        // Filter all records that have negative a empty values
        List<Weather> total = records.stream()
                .filter(r -> r.getAirtemp() >= 0 && r.getAtmosphericpressure() >= 0 && r.getGustspeed() >= 0 &&
                        r.getPrecipitation() >= 0 && r.getRelativehumidity() >= 0 && r.getSolar() >= 0 &&
                        r.getStrikedistance() >= 0 && r.getStrikes() >= 0 && r.getVapourpressure() >= 0 &&
                        r.getWindspeed() >= 0)
                .collect(Collectors.toList());

        // Total statistics
        System.out.println("Total Statistics are:");
        printMetricStats(total);

        // Per day statistics
        Map<String, List<Weather>> recordsByDay = total.stream()
                .collect(Collectors.groupingBy(r ->
                        r.getDayofweek() + " " + r.getYear() + "-" + r.getMonth() + "-" + r.getTime()));

        System.out.println("\nDaily Statistics are:");
        recordsByDay.forEach((day, dayRecords) -> {
            System.out.println(day + ":");
            printMetricStats(dayRecords);
        });
    }

    private static void printMetricStats(List<Weather> records) {
        printStat(records, "Air Temperature", Weather::getAirtemp);
        printStat(records, "Atmospheric Pressure", Weather::getAtmosphericpressure);
        printStat(records, "Gust Speed", Weather::getGustspeed);
        printStat(records, "Precipitation", Weather::getPrecipitation);
        printStat(records, "Relative Humidity", Weather::getRelativehumidity);
        printStat(records, "Solar", Weather::getSolar);
        printStat(records, "Strike Distance", Weather::getStrikedistance);
        printStat(records, "Strikes", Weather::getStrikes);
        printStat(records, "Vapour Pressure", Weather::getVapourpressure);
        printStat(records, "Wind Speed", Weather::getWindspeed);
    }

    private static void printStat(List<Weather> records, String metricName,
                                  java.util.function.ToDoubleFunction<Weather> getter) {

        OptionalDouble avg = records.stream().mapToDouble(getter).average();
        OptionalDouble min = records.stream().mapToDouble(getter).min();
        OptionalDouble max = records.stream().mapToDouble(getter).max();

        System.out.printf("- %s: Avg %.2f, Min %.2f, Max %.2f%n",
                metricName,
                avg.orElse(0.0),
                min.orElse(0.0),
                max.orElse(0.0)
        );
    }

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            analyzeWeatherData();
            long endTime = System.currentTimeMillis();
            System.out.println("\nExecution time: " + (endTime - startTime) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
