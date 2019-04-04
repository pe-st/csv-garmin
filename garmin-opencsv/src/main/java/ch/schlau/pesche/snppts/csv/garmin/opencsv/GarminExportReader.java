package ch.schlau.pesche.snppts.csv.garmin.opencsv;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class GarminExportReader {

    private GarminExportReader() {
        // Utility classes should not have public constructors
    }

    /**
     * Parse and return all Activity records from the given CSV file
     *
     * @param filename file to parse
     * @return List of Activity Records
     *
     * @throws IOException
     */
    public static List<Activity> parse(String filename) throws IOException {
        CsvToBeanBuilder<Activity> reader = new CsvToBeanBuilder<>(new FileReader(filename));
        return reader.withType(Activity.class).build().parse();
    }

    /**
     * Parse and return Activity records from a CSV file with the given Activity Type
     *
     * @param filename     file to parse
     * @param activityType type to filter with
     * @return List of Activity Records with the given Activity Type
     *
     * @throws IOException
     */
    public static List<Activity> parse(String filename, String activityType) throws IOException {
        CsvToBeanBuilder<Activity> reader = new CsvToBeanBuilder<>(new FileReader(filename));

        return reader
                .withType(Activity.class)
                .withVerifier(new ActivityTypeFilter(activityType))
                .build()
                .parse();
    }
}
