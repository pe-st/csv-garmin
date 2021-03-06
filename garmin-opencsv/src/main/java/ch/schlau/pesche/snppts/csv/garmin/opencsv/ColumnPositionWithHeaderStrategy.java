package ch.schlau.pesche.snppts.csv.garmin.opencsv;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * Modifies the existing {@link ColumnPositionMappingStrategy} to print headers,
 * typically use when writing CSV files, e.g. with {@link com.opencsv.bean.StatefulBeanToCsvBuilder}
 *
 * @param <T> Type of object that is being processed.
 */
public class ColumnPositionWithHeaderStrategy<T> extends ColumnPositionMappingStrategy<T> {

    /**
     * Constructor taking care of setting the correct type for the strategy
     * <p>
     * {@link #setType(Class)} is usually only called when the mapping strategy is determined
     * automatically. This strategy however is intended to be set explicitly with
     * {@link com.opencsv.bean.StatefulBeanToCsvBuilder#withMappingStrategy(MappingStrategy)},
     * thus the type must be set explicitly before doing any work.
     *
     * @param clazz the class of the generic type T; as it is not directly
     *              accessible because of type erasure, it must be passed in.
     */
    public ColumnPositionWithHeaderStrategy(Class<T> clazz) {
        super();
        setType(clazz);
    }

    @Override
    public String[] generateHeader(T bean) throws CsvRequiredFieldEmptyException {

        // This code is copied from com.opencsv.bean.AbstractMappingStrategy.generateHeader,
        // but to call it with super.super.generateHeader() is not allowed by Java...

        // Always take what's been given or previously determined first.
        if (headerIndex.isEmpty()) {
            String[] header = getFieldMap().generateHeader(bean);
            headerIndex.initializeHeaderIndex(header);
            return header;
        }

        // Otherwise, put headers in the right places.
        return headerIndex.getHeaderIndex();
    }
}
