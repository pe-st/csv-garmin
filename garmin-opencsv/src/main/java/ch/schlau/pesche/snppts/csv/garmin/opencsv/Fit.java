package ch.schlau.pesche.snppts.csv.garmin.opencsv;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByPosition;

public class Fit {

    @CsvBindByPosition(position = 0)
    private LocalDate date;

    @CsvBindByPosition(position = 1)
    private double km;

    @CsvBindByPosition(position = 2)
    private Integer shoes;

    @CsvBindByPosition(position = 3)
    private Integer elevationGain;

    @CsvBindByPosition(position = 4)
    private double mmSs;

    @CsvBindByPosition(position = 5)
    private Double minutes;

    @CsvBindByPosition(position = 6)
    private Double pace;

    @CsvBindByPosition(position = 7)
    private Double gradeAdjustedPace;

    @CsvBindByPosition(position = 8)
    private Double gap;

    @CsvBindByPosition(position = 9)
    private Double ans;

    @CsvBindByPosition(position = 10)
    private String name;

    @CsvBindByPosition(position = 11)
    private Integer heartRate;

    @CsvBindByPosition(position = 12)
    private Integer calories;

    @CsvBindByPosition(position = 13)
    private Integer vo2max;

    @CsvBindByPosition(position = 14)
    private String place;

    @CsvBindByPosition(position = 15)
    private String finisherM;

    @CsvBindByPosition(position = 16)
    private String finisherTotal;

    @CsvBindByPosition(position = 17)
    private String percentile;

    @CsvBindByPosition(position = 18)
    private String relativePercent;

    @CsvBindByPosition(position = 19)
    private String notes;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public Integer getShoes() {
        return shoes;
    }

    public void setShoes(Integer shoes) {
        this.shoes = shoes;
    }

    public Integer getElevationGain() {
        return elevationGain;
    }

    public void setElevationGain(Integer elevationGain) {
        this.elevationGain = elevationGain;
    }

    public double getMmSs() {
        return mmSs;
    }

    public void setMmSs(double mmSs) {
        this.mmSs = mmSs;
    }

    public Double getMinutes() {
        return minutes;
    }

    public void setMinutes(Double minutes) {
        this.minutes = minutes;
    }

    public Double getPace() {
        return pace;
    }

    public void setPace(Double pace) {
        this.pace = pace;
    }

    public Double getGradeAdjustedPace() {
        return gradeAdjustedPace;
    }

    public void setGradeAdjustedPace(Double gradeAdjustedPace) {
        this.gradeAdjustedPace = gradeAdjustedPace;
    }

    public Double getGap() {
        return gap;
    }

    public void setGap(Double gap) {
        this.gap = gap;
    }

    public Double getAns() {
        return ans;
    }

    public void setAns(Double ans) {
        this.ans = ans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getVo2max() {
        return vo2max;
    }

    public void setVo2max(Integer vo2max) {
        this.vo2max = vo2max;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFinisherM() {
        return finisherM;
    }

    public void setFinisherM(String finisherM) {
        this.finisherM = finisherM;
    }

    public String getFinisherTotal() {
        return finisherTotal;
    }

    public void setFinisherTotal(String finisherTotal) {
        this.finisherTotal = finisherTotal;
    }

    public String getPercentile() {
        return percentile;
    }

    public void setPercentile(String percentile) {
        this.percentile = percentile;
    }

    public String getRelativePercent() {
        return relativePercent;
    }

    public void setRelativePercent(String relativePercent) {
        this.relativePercent = relativePercent;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
