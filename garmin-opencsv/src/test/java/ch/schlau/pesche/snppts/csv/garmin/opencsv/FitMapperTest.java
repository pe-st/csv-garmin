package ch.schlau.pesche.snppts.csv.garmin.opencsv;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class FitMapperTest {

    @Test
    void activityToFit() {
        // given
        Activity activity = new Activity();
        activity.setBeginTimestamp(LocalDateTime.parse("2017-06-11T11:02"));
        activity.setName("Murtenlauf");
        activity.setDuration(Duration.ofSeconds(80));
        activity.setDistance(42.195);
        activity.setElevationGain(365.38);

        // when
        Fit fit = FitMapper.INSTANCE.activityToFit(activity);

        // then
        assertThat(fit, not(is(nullValue())));
        assertThat(fit.getDate(), is(LocalDate.parse("2017-06-11")));
        assertThat(fit.getKm(), is(42.195));
        assertThat(fit.getElevationGain(), is(365));
        assertThat(fit.getMmSs(), is(1.2));
        assertThat(fit.getName(), is("Murtenlauf"));
    }

    @Test
    void activityToFit_emptyValues() {
        // given
        Activity activity = new Activity();

        // when
        Fit fit = FitMapper.INSTANCE.activityToFit(activity);

        // then
        assertThat(fit, not(is(nullValue())));
        assertThat(fit.getDate(), is(nullValue()));
        assertThat(fit.getKm(), is(0.0));
        assertThat(fit.getElevationGain(), is(nullValue()));
        assertThat(fit.getMmSs(), is(0.0));
        assertThat(fit.getName(), is(nullValue()));
    }

    @Test
    public void mmss() {
        assertThat(FitMapper.INSTANCE.mmss(Duration.ofSeconds(30)), is(0.30));
        assertThat(FitMapper.INSTANCE.mmss(Duration.ofSeconds(80)), is(1.20));
        assertThat(FitMapper.INSTANCE.mmss(Duration.ofSeconds(81)), is(1.21));
    }
}