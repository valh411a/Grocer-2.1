package com.example.grocer21.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "food_table")
public class Food {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "upc")
    private long upc;

    @ColumnInfo(name = "name")
    private String name;

    public Food(String name, long upc) {
        this.name = name;
        this.upc = upc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUpc() {
        return upc;
    }

    public String getFood() {
        return name;
    }
}
