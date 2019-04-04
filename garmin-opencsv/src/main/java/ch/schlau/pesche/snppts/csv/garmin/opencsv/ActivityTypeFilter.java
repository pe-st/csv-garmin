package ch.schlau.pesche.snppts.csv.garmin.opencsv;

import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;

public class ActivityTypeFilter implements BeanVerifier<Activity> {

    private final String activityType;

    public ActivityTypeFilter(String activityType) {
        this.activityType = activityType;
    }

    @Override
    public boolean verifyBean(Activity bean) throws CsvConstraintViolationException {
        if (activityType == null || activityType.isEmpty()) {
            return true;
        }

        return activityType.equals(bean.getActivityType());
    }
}
