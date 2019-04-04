package ch.schlau.pesche.snppts.csv.garmin.opencsv;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
     * @throws FileNotFoundException
     */
    public static List<Activity> parse(String filename) throws FileNotFoundException {

        return activityReaderBuilder(filename)
                .build()
                .parse();
    }

    /**
     * Parse and return Activity records from a CSV file with the given Activity Type
     *
     * @param filename     file to parse
     * @param activityType type to filter with
     * @return List of Activity Records with the given Activity Type
     *
     * @throws FileNotFoundException
     */
    public static List<Activity> parse(String filename, String activityType) throws FileNotFoundException {

        return activityReaderBuilder(filename)
                .withVerifier(new ActivityTypeFilter(activityType))
                .build()
                .parse();
    }

    private static CsvToBeanBuilder<Activity> activityReaderBuilder(String filename) throws FileNotFoundException {

        return new CsvToBeanBuilder<Activity>(new FileReader(filename))
                .withType(Activity.class);
    }
}
