package com.example.systemate2.Models;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalTime;

public class CashFlow {
    private Long income;
    private Long outcome;
    private Long cashOnHand;
    private final ObjectProperty<LocalTime> timeProps;
    private static long previousCashOnHand = 0;

    public Long getIncome(){
        return income;
    }

    public Long getOutcome(){
        return outcome;
    }

    public CashFlow(Long income, Long outcome, LocalTime time){
        this.income = income;
        this.outcome = outcome;
        this.timeProps = new SimpleObjectProperty<>(time);
        this.cashOnHand = 0L;
        cashOnHandAccumulative();
    }

    public LocalTime getTimeProperty(){
        return timeProps.get();
    }
    public LongProperty incomeProperty(){
        return new SimpleLongProperty(income);
    }
    public LongProperty outcomeProperty(){
        return new SimpleLongProperty(outcome);
    }
    public LongProperty cashOnHandProperty(){
        return new SimpleLongProperty(cashOnHand);
    }

    public void cashOnHandAccumulative(){
        Long currentCOH = this.getIncome() - this.getOutcome() + previousCashOnHand;
        cashOnHand = currentCOH;
        previousCashOnHand = cashOnHand;
    }
}
