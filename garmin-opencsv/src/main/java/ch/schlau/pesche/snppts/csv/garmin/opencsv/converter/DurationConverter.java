package ch.schlau.pesche.snppts.csv.garmin.opencsv.converter;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

/**
 * Custom converter to Java 8 {@link Duration} for the durations used in the Garmin Export.
 *
 * @param <T>
 */
public class DurationConverter<T> extends AbstractBeanField<T> {

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

        try {
            return Duration.between(LocalTime.of(0,0), LocalTime.parse(value, DateTimeFormatter.ISO_LOCAL_TIME));
        } catch (DateTimeParseException e) {
            CsvDataTypeMismatchException csve = new CsvDataTypeMismatchException(
                    value, field.getType(), "Input wasn't in the expected timestamp format.");
            csve.initCause(e);
            throw csve;
        }
    }
}
