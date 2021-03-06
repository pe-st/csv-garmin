package ch.schlau.pesche.snppts.csv.garmin.supercsv;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FitMapper {

    FitMapper INSTANCE = Mappers.getMapper(FitMapper.class);

    @Mapping(target = "date", source = "beginTimestamp")
    @Mapping(target = "km", source = "distance")
    @Mapping(target = "shoes", ignore = true)
    @Mapping(target = "elevationGain", source = "elevationGain")
    @Mapping(target = "mmSs", source = "duration", qualifiedByName = "MMSS")
    @Mapping(target = "minutes", ignore = true)
    @Mapping(target = "pace", ignore = true)
    @Mapping(target = "gradeAdjustedPace", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "heartRate", source = "heartRate")
    @Mapping(target = "calories", source = "calories")
    @Mapping(target = "caloriesPercent", ignore = true)
    @Mapping(target = "notes", source = "description")
    Fit activityToFit(Activity activity);

    default LocalDate map(LocalDateTime value) {
        return value == null
                ? null
                : value.toLocalDate();
    }

    /**
     * Convert seconds into minutes with the seconds as decimal fraction from 00 to 59
     *
     * @param duration
     * @return
     */
    @Named("MMSS")
    default double mmss(double duration) {
        int minutes = (int) (duration / 60);
        long seconds = Math.round(duration % 60);

        return minutes + (double) seconds / 100;
    }
}
