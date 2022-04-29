package com.give928.java.bytecode.intro;

public class Meeting {
    int maxNumberOfAttendees;
    int numberOfEnrollment;

    public boolean isEnrollmentFull() {
        if (maxNumberOfAttendees == 0) {
            return false;
        }

        if (numberOfEnrollment < maxNumberOfAttendees) {
            return false;
        }

        return true;
    }
}
