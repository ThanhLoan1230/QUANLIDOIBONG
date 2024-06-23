/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * KHAI BÁO 
 */
public class CauthuMOD {

    String maCT, Tencauthu, QueQuan, CMND, Ngaysinh, Email, ViTri;

    public CauthuMOD() {
    }

    public CauthuMOD(String maCT, String Tencauthu, String QueQuan, String CMND, String Ngaysinh, String Email, String ViTri) {
        this.maCT = maCT;
        this.Tencauthu = Tencauthu;
        this.QueQuan = QueQuan;
        this.CMND = CMND;
        this.Ngaysinh = Ngaysinh;
        this.Email = Email;
        this.ViTri = ViTri;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public String getTencauthu() {
        return Tencauthu;
    }

    public void setTencauthu(String Tencauthu) {
        this.Tencauthu = Tencauthu;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }

}
