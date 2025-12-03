package com.kadir.ebabytracker.common.exception;

import java.time.LocalDate;

public class InvalidVaccinationDateException  extends BusinessException{

    public InvalidVaccinationDateException(LocalDate date) {
        super("VACCINATION_DATE_INVALID","Vaccination date cannot be in the future : " +  date);
    }
}
