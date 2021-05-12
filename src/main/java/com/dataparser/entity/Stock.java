package com.dataparser.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Stock {
    public Stock() {
    }

    public Stock(String[] split) {
        super();
        this.quarter = split[0];
        this.stock = split[1];
        this.date = split[2];
        this.open = split[3];
        this.high = split[4];
        this.low = split[5];
        this.close = split[6];
        this.volume = split[7];
        this.percent_change_price = split[8];
        this.percent_change_volume_over_last_wk = split[9];
        this.previous_weeks_volume = split[10];
        this.next_weeks_open = split[11];
        this.next_weeks_close = split[12];
        this.percent_change_next_weeks_price = split[13];
        this.days_to_next_dividend = split[14];
        this.percent_return_next_dividend = split[15];
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String quarter;
    @Column
    private String stock;
    @Column
    private String date;
    @Column
    private String open;
    @Column
    private String high;
    @Column
    private String low;
    @Column
    private String close;
    @Column
    private String volume;
    @Column
    private String percent_change_price;
    @Column
    private String percent_change_volume_over_last_wk;
    @Column
    private String previous_weeks_volume;
    @Column
    private String next_weeks_open;
    @Column
    private String next_weeks_close;
    @Column
    private String percent_change_next_weeks_price;
    @Column
    private String days_to_next_dividend;
    @Column
    private String percent_return_next_dividend;
}