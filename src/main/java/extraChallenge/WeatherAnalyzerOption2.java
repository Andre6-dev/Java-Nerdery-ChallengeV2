package extraChallenge;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


// Final Solution: Using ConcurrentHashMap to store the metrics for each entry and then calculate the statistics
public class WeatherAnalyzerOption2 {

    // Track the metrics for each entry
    private static class MetricStats {
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        long count = 0;

        void update(double value) {
            sum += value;
            min = Math.min(min, value);
            max = Math.max(max, value);
            count++;
        }

        double getAverage() {
            return count > 0 ? sum / count : 0;
        }
    }

    public static void analyzeWeatherData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = WeatherAnalyzerOption2.class
                .getClassLoader().getResourceAsStream("weather.json");

        if (inputStream == null) {
            throw new IOException("File not found");
        }

        // Maps to store statistics
        Map<String, MetricStats> totalStats = new ConcurrentHashMap<>();
        Map<String, Map<String, MetricStats>> dailyStats = new ConcurrentHashMap<>();

        // Initialize metric keys
        List<String> metricKeys = Arrays.asList(
                "airtemp", "atmosphericpressure", "gustspeed", "precipitation",
                "relativehumidity", "solar", "strikedistance", "strikes",
                "vapourpressure", "windspeed"
        );

        // Initialize maps for all metrics
        metricKeys.forEach(key -> {
            totalStats.put(key, new MetricStats());
        });

        // Read the JSON array
        Weather[] records = mapper.readValue(inputStream, Weather[].class);

        // Process each record
        for (Weather record : records) {

            // Skip records with missing data
            if (!isValidRecord(record)) {
                continue;
            }

            String dayKey = record.getDayofweek() + " " +
                    record.getYear() + "-" +
                    record.getMonth() + "-" +
                    record.getTime().substring(0, 10);

            // update total stats
            updateStats(totalStats, record);

            // update daily stats
            dailyStats.computeIfAbsent(dayKey, k -> {
                Map<String, MetricStats> stats = new ConcurrentHashMap<>();
                metricKeys.forEach(key -> {
                    stats.put(key, new MetricStats());
                });
                return stats;
            });
            updateStats(dailyStats.get(dayKey), record);
        }

        // Print total stats
        System.out.println("Total Statistics are:");
        printStats(totalStats);

        // Print daily stats
        System.out.println("\nDaily Statistics are:");
        dailyStats.forEach((day, stats) -> {
            System.out.println(day + ":");
            printStats(stats);
        });
    }

    private static boolean isValidRecord(Weather record) {
        return record != null
                && record.getAirtemp() >= 0
                && record.getAtmosphericpressure() >= 0
                && record.getGustspeed() >= 0
                && record.getPrecipitation() >= 0
                && record.getRelativehumidity() >= 0
                && record.getSolar() >= 0
                && record.getStrikedistance() >= 0
                && record.getStrikes() >= 0
                && record.getVapourpressure() >= 0
                && record.getWindspeed() >= 0;
    }

    private static void updateStats(Map<String, MetricStats> stats, Weather record) {
        stats.get("airtemp").update(record.getAirtemp());
        stats.get("atmosphericpressure").update(record.getAtmosphericpressure());
        stats.get("gustspeed").update(record.getGustspeed());
        stats.get("precipitation").update(record.getPrecipitation());
        stats.get("relativehumidity").update(record.getRelativehumidity());
        stats.get("solar").update(record.getSolar());
        stats.get("strikedistance").update(record.getStrikedistance());
        stats.get("strikes").update(record.getStrikes());
        stats.get("vapourpressure").update(record.getVapourpressure());
        stats.get("windspeed").update(record.getWindspeed());
    }

    private static void printStats(Map<String, MetricStats> stats) {
        stats.forEach((metric, stat) -> {
            System.out.printf("- %s: Avg %.2f, Min %.2f, Max %.2f%n",
                    metric,
                    stat.getAverage(),
                    stat.min,
                    stat.max
            );
        });
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
