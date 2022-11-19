package com.azhar.hitungpengeluaran.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.azhar.hitungpengeluaran.model.ModelDatabase;

import java.util.List;

/**
 * Created by Azhar Rivaldi on 20-10-2022
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

@Dao
public interface DatabaseDao {

    //Data Pengeluaran
    @Query("SELECT * FROM tbl_keuangan WHERE tipe = 'pengeluaran'")
    LiveData<List<ModelDatabase>> getAllPengeluaran();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPengeluaran(ModelDatabase... pengeluaran);

    @Query("DELETE FROM tbl_keuangan WHERE tipe = 'pengeluaran'")
    void deleteAllPengeluaran();

    @Query("DELETE FROM tbl_keuangan WHERE uid= :uid and tipe = 'pengeluaran'")
    void deleteSinglePengeluaran(int uid);

    @Query("SELECT SUM(jml_uang) FROM tbl_keuangan WHERE tipe = 'pengeluaran'")
    LiveData<Integer> getTotalPengeluaran();

    @Query("UPDATE tbl_keuangan SET keterangan = :keterangan, tanggal = :tgl, jml_uang = :harga WHERE uid = :uid and tipe = 'pengeluaran'")
    void updateDataPengeluaran(String keterangan, String tgl, int harga, int uid);

    //Data Pemasukan
    @Query("SELECT * FROM tbl_keuangan WHERE tipe = 'pemasukan'")
    LiveData<List<ModelDatabase>> getAllPemasukan();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPemasukan(ModelDatabase... pemasukan);

    @Query("DELETE FROM tbl_keuangan WHERE tipe = 'pemasukan'")
    void deleteAllPemasukan();

    @Query("DELETE FROM tbl_keuangan WHERE uid= :uid and tipe = 'pemasukan'")
    void deleteSinglePemasukan(int uid);

    @Query("SELECT SUM(jml_uang) FROM tbl_keuangan WHERE tipe = 'pemasukan'")
    LiveData<Integer> getTotalPemasukan();

    @Query("UPDATE tbl_keuangan SET keterangan = :keterangan, tanggal = :tgl, jml_uang = :harga WHERE uid = :uid and tipe = 'pemasukan'")
    void updateDataPemasukan(String keterangan, String tgl, int harga, int uid);
}
