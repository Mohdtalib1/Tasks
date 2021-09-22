package com.mbytessolution.databinding;

public class HolidayModel {

    private String holidayDate;
    private String holidayName;

    public HolidayModel(String holidayDate, String holidayName) {
        this.holidayDate = holidayDate;
        this.holidayName = holidayName;
    }

    public HolidayModel() {
    }

    public String getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(String holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }
}
