package ch.schlau.pesche.snppts.csv.garmin.opencsv;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

class GarminExportReaderTest {

    @Test
    void parse_activities() throws IOException {

        String csvfile = getClass().getClassLoader().getResource("activities.csv").getFile();
        List<Activity> activities = GarminExportReader.parse(csvfile);

        assertThat(activities.size(), is(8));
        assertThat(activities.get(0).getId(), is("1790839661"));
        assertThat(activities.get(0).getName(), is("Oberwald-Münster (Gommer Höhenweg)"));
        assertThat(activities.get(0).getBeginTimestamp(), is(LocalDateTime.parse("2017-06-11T11:02:22")));

        assertThat(activities.get(2).getActivityType(), is("Cycling"));
        assertThat(activities.get(2).getDescription(), is("Strassenquerung bei 19.3 km ohne Vortritt (langes Warten)\n" +
                "km 21.6-22.7 Naturstrasse\n" +
                "km 42.4-44.2 zT Naturstrasse, Hindernisse"));
    }

    @Test
    void parse_activities_onlyRunning() throws IOException {

        String csvfile = getClass().getClassLoader().getResource("activities.csv").getFile();
        List<Activity> activities = GarminExportReader.parse(csvfile, "Running");

        assertThat(activities.size(), is(3));
        assertThat(activities.get(0).getName(), is("Courtepin 15"));
        assertThat(activities.get(0).getBeginTimestamp(), is(LocalDateTime.parse("2016-03-20T09:59:15")));

        assertThat(activities.get(2).getHeartRate(), is(163));
        assertThat(activities.get(2).getCalories(), is(1732.0));
        assertThat(activities.get(2).getVo2max(), is(49.0));
        assertThat(activities.get(2).getDuration(), is(Duration.parse("PT1H48M36S")));
        assertThat(activities.get(2).getDistance(), is(21.01452));
        assertThat(activities.get(2).getElevationGain(), is(84.28));
        assertThat(activities.get(2).getGear(), is("13"));
    }
}