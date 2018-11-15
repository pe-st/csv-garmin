package ch.schlau.pesche.snppts.csv.garmin.opencsv.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

/**
 * Custom converter to Java 8 {@link LocalDateTime} for the time stamps used in the Garmin Export.
 *
 * @param <T>
 */
public class LocalDateTimeConverter<T> extends AbstractBeanField<T> {

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

        try {
            return LocalDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            CsvDataTypeMismatchException csve = new CsvDataTypeMismatchException(
                    value, field.getType(), "Input wasn't in the expected timestamp format.");
            csve.initCause(e);
            throw csve;
        }
    }
}
