package com.azhar.hitungpengeluaran.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Azhar Rivaldi on 20-10-2022
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

@Entity(tableName = "tbl_keuangan")
public class ModelDatabase implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "tipe")
    public String tipe;

    @ColumnInfo(name = "keterangan")
    public String keterangan;

    @ColumnInfo(name = "jml_uang")
    public int jmlUang;

    @ColumnInfo(name = "tanggal")
    public String tanggal;

    public ModelDatabase() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.uid);
        dest.writeString(this.tipe);
        dest.writeString(this.keterangan);
        dest.writeInt(this.jmlUang);
        dest.writeString(this.tanggal);
    }

    protected ModelDatabase(Parcel in) {
        this.uid = in.readInt();
        this.tipe = in.readString();
        this.keterangan = in.readString();
        this.jmlUang = in.readInt();
        this.tanggal = in.readString();
    }

    public static final Creator<ModelDatabase> CREATOR = new Creator<ModelDatabase>() {
        @Override
        public ModelDatabase createFromParcel(Parcel source) {
            return new ModelDatabase(source);
        }

        @Override
        public ModelDatabase[] newArray(int size) {
            return new ModelDatabase[size];
        }
    };

}
