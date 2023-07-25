package com.example.samplecrudapi.apicrud.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sys_reservasi")
public class LangEntity {

    @Id
    @Column(name ="NO_RESERVASI", length = 12, nullable = false)
    private String NoReservasi;

    @Column(name ="NO_PENDAFTARAN",length = 12,nullable = false)
    private String NoPendaftaran;
    @Column(name ="KD_POLI",length = 2)
    private String KdPoli;
    @Column(name ="NORM",length = 8)
    private String Norm;

    @Column(name ="TGL_RESERVASI")
    private LocalDateTime TglReservasi;
    @Column(name ="TGL_DAFTAR")
    private LocalDateTime TglDaftar;

    @Column(name ="NO_URUT",length = 7)
    private String NoUrut;
    @Column(name ="NAMA",length = 35)
    private String Nama;
    @Column(name ="KD_DOKTER",length = 7)
    private String Kd_Dokter;
    @Column(name ="KD_CARAMASUK",length = 2)
    private String KdCaramasuk;
    @Column(name ="VIA_RESERV",length = 1)
    private String ViaReserv;
    @Column(name ="NM_TELP",length = 35)
    private String NmTelp;
    @Column(name ="NO_TELP1",length = 20)
    private String NoTelp1;
    @Column(name ="NO_TELP2",length = 20)
    private String No_Telp2;
    @Column(name ="STS_BATAL",length = 1)
    private String Sts_Batal;
    @Column(name ="STS_PAGI",length = 1)
    private String StsPagi;
    @Column(name ="KD_JNS_CARABAYAR",length = 2)
    private String KdJnsCarabayar;
    @Column(name ="KD_BAYAR",length = 3)
    private String KdBayar;

    @Column(name ="MODIFIEDAT")
    private LocalDateTime Modifiedat;
    @Column(name ="MODIFIEDBY",length = 36)
    private String Modifiedby;

    public String getNoReservasi() {
        return NoReservasi;
    }

    public void setNoReservasi(String noReservasi) {
        NoReservasi = noReservasi;
    }

    public String getNoPendaftaran() {
        return NoPendaftaran;
    }

    public void setNoPendaftaran(String noPendaftaran) {
        NoPendaftaran = noPendaftaran;
    }

    public String getKdPoli() {
        return KdPoli;
    }

    public void setKdPoli(String kdPoli) {
        KdPoli = kdPoli;
    }

    public String getNorm() {
        return Norm;
    }

    public void setNorm(String norm) {
        Norm = norm;
    }

    public LocalDateTime getTglReservasi() {
        return TglReservasi;
    }

    public void setTglReservasi(LocalDateTime tglReservasi) {
        TglReservasi = tglReservasi;
    }

    public LocalDateTime getTglDaftar() {
        return TglDaftar;
    }

    public void setTglDaftar(LocalDateTime tglDaftar) {
        TglDaftar = tglDaftar;
    }

    public String getNoUrut() {
        return NoUrut;
    }

    public void setNoUrut(String noUrut) {
        NoUrut = noUrut;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getKd_Dokter() {
        return Kd_Dokter;
    }

    public void setKd_Dokter(String kd_Dokter) {
        Kd_Dokter = kd_Dokter;
    }

    public String getKdCaramasuk() {
        return KdCaramasuk;
    }

    public void setKdCaramasuk(String kdCaramasuk) {
        KdCaramasuk = kdCaramasuk;
    }

    public String getViaReserv() {
        return ViaReserv;
    }

    public void setViaReserv(String viaReserv) {
        ViaReserv = viaReserv;
    }

    public String getNmTelp() {
        return NmTelp;
    }

    public void setNmTelp(String nmTelp) {
        NmTelp = nmTelp;
    }

    public String getNoTelp1() {
        return NoTelp1;
    }

    public void setNoTelp1(String noTelp1) {
        NoTelp1 = noTelp1;
    }

    public String getNo_Telp2() {
        return No_Telp2;
    }

    public void setNo_Telp2(String no_Telp2) {
        No_Telp2 = no_Telp2;
    }

    public String getSts_Batal() {
        return Sts_Batal;
    }

    public void setSts_Batal(String sts_Batal) {
        Sts_Batal = sts_Batal;
    }

    public String getStsPagi() {
        return StsPagi;
    }

    public void setStsPagi(String stsPagi) {
        StsPagi = stsPagi;
    }

    public String getKdJnsCarabayar() {
        return KdJnsCarabayar;
    }

    public void setKdJnsCarabayar(String kdJnsCarabayar) {
        KdJnsCarabayar = kdJnsCarabayar;
    }

    public String getKdBayar() {
        return KdBayar;
    }

    public void setKdBayar(String kdBayar) {
        KdBayar = kdBayar;
    }

    public LocalDateTime getModifiedat() {
        return Modifiedat;
    }

    public void setModifiedat(LocalDateTime modifiedat) {
        Modifiedat = modifiedat;
    }

    public String getModifiedby() {
        return Modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        Modifiedby = modifiedby;
    }
}

