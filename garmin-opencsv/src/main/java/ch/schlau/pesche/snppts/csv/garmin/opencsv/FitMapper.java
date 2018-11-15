package ch.schlau.pesche.snppts.csv.garmin.opencsv;

import java.time.Duration;
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
    @Mapping(target = "shoes", source = "gear", qualifiedByName = "ignoreNonInt")
    @Mapping(target = "elevationGain", source = "elevationGain")
    @Mapping(target = "mmSs", source = "duration", qualifiedByName = "MMSS")
    @Mapping(target = "minutes", ignore = true)
    @Mapping(target = "pace", ignore = true)
    @Mapping(target = "gradeAdjustedPace", ignore = true)
    @Mapping(target = "gap", ignore = true)
    @Mapping(target = "ans", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "heartRate", source = "heartRate")
    @Mapping(target = "calories", source = "calories")
    @Mapping(target = "vo2max", source = "vo2max")
    @Mapping(target = "place", ignore = true)
    @Mapping(target = "finisherM", ignore = true)
    @Mapping(target = "finisherTotal", ignore = true)
    @Mapping(target = "percentile", ignore = true)
    @Mapping(target = "relativePercent", ignore = true)
    @Mapping(target = "fairKaplan", ignore = true)
    @Mapping(target = "notes", source = "description")
    Fit activityToFit(Activity activity);

    default LocalDate map(LocalDateTime value) {
        return value == null
                ? null
                : value.toLocalDate();
    }

    /**
     * Convert duration into minutes with the seconds as decimal fraction from 00 to 59
     *
     * @param duration
     * @return
     */
    @Named("MMSS")
    default double mmss(Duration duration) {
        if (duration != null) {
            int minutes = (int) (duration.getSeconds() / 60);
            long seconds = Math.round(duration.getSeconds() % 60);

            return minutes + (double) seconds / 100;
        }
        return 0.0;
    }

    @Named("ignoreNonInt")
    default Integer ignoreNonInt(String gear) {
        if (gear != null && !gear.isEmpty()) {
            try {
                return Integer.valueOf(gear);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
}
