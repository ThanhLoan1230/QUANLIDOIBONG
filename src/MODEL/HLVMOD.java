/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author My PC
 */
public class HLVMOD {
    String TenHVL,NgaySinh,QueQuan,CMND,Email,ChucVu,MaHLV,SDT;

    public HLVMOD() {
    }

    public HLVMOD(String TenHVL, String NgaySinh, String QueQuan, String CMND, String Email, String ChucVu, String MaHLV, String SDT) {
        this.TenHVL = TenHVL;
        this.NgaySinh = NgaySinh;
        this.QueQuan = QueQuan;
        this.CMND = CMND;
        this.Email = Email;
        this.ChucVu = ChucVu;
        this.MaHLV = MaHLV;
        this.SDT = SDT;
    }

    public String getTenHVL() {
        return TenHVL;
    }

    public void setTenHVL(String TenHVL) {
        this.TenHVL = TenHVL;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getMaHLV() {
        return MaHLV;
    }

    public void setMaHLV(String MaHLV) {
        this.MaHLV = MaHLV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
}
