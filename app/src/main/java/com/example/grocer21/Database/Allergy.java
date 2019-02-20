package com.example.grocer21.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "allergy_table")
public class Allergy {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    public Allergy(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
