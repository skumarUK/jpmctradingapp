/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Entity class to capture raking for entity and assign a rank on given date.
 */

public class EntityRank {

    private final String entity;
    private final int rank;
    private final LocalDate date;

    public EntityRank(String entity, int rank, LocalDate date){
        this.entity = entity;
        this.rank = rank;
        this.date = date;
    }

    public String getEntity() {

        return entity;
    }
    public int getRank() {

        return rank;
    }
    public LocalDate getDate() {

        return date;
    }

    @Override public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EntityRank that = (EntityRank) o;
        return getRank() == that.getRank() &&
            Objects.equals(getEntity(), that.getEntity()) &&
            Objects.equals(getDate(), that.getDate());
    }

    @Override public int hashCode() {

        return Objects.hash(getEntity(), getRank(), getDate());
    }
}
