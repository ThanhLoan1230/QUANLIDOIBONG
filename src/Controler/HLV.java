/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import MODEL.CauthuMOD;
import MODEL.HLVMOD;
import SQL.Connect_DTB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TRUY VÁN DỮ LIỆU TỪ DATABASE //
public class HLV {
     public List<HLVMOD> findAll() throws Exception {

        String sql = "select * from HLV";
        try (
                 Connection con = Connect_DTB.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            try ( ResultSet rs = pstmt.executeQuery();) {
                List<HLVMOD> list = new ArrayList<>();
                while (rs.next()) {
                    HLVMOD hlv = createHLV(rs);
                    list.add(hlv);
                }
                return list;
            }
        }
    }

    public boolean insert(HLVMOD hlv) throws Exception {

        String sql = "INSERT INTO HLV ( MaHLV ,TenHLV ,Ngaysinh ,QueQuan ,CMND ,Email ,ChucVu, SDT) VALUES (?, ?, ?, ? , ?, ?, ?, ?) ";
        try (
                 Connection con = Connect_DTB.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, hlv.getMaHLV());
            pstmt.setString(2, hlv.getTenHVL());
            pstmt.setString(3, hlv.getNgaySinh());
            pstmt.setString(4, hlv.getQueQuan());
            pstmt.setString(5, hlv.getCMND());
            pstmt.setString(6, hlv.getEmail());
            pstmt.setString(7, hlv.getChucVu());
            pstmt.setString(8, hlv.getSDT());
            return pstmt.executeUpdate() > 0;
        }

    }
//sua
    public boolean update(HLVMOD hlv) throws Exception {

        String sql = " UPDATE dbo.HLV"
                + " SET TenHLV = ? ,NgaySinh = ?, QueQuan = ?,CMND = ?,Email = ?,ChucVu = ?, SDT = ?"
                + " where MaHLV = ? ";
        try (
                 Connection con = Connect_DTB.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(8, hlv.getMaHLV());
            pstmt.setString(1, hlv.getTenHVL());
            pstmt.setString(2, hlv.getNgaySinh());
            pstmt.setString(3, hlv.getQueQuan());
            pstmt.setString(4, hlv.getCMND());
            pstmt.setString(5, hlv.getEmail());
            pstmt.setString(6, hlv.getChucVu());
            pstmt.setString(7, hlv.getSDT());

            return pstmt.executeUpdate() > 0;
        }
// xoa
    }
    public boolean delete(String MaHLV) throws Exception {

        String sql = "delete from HLV"
                + " where MaHLV= ? ";
        try (
                Connection con = Connect_DTB.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, MaHLV );

            return pstmt.executeUpdate() > 0;
        }
    }
     public HLVMOD findByID(String MaHLV)
            throws Exception {

        String sql = "select * from HLV where MaHLV = ? ";
        try (
                Connection con = Connect_DTB.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1,MaHLV);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    HLVMOD hlv = createHLV(rs);
                    return hlv;
                }
            }
            return null;
        }

    } 
    // tìm kiem
    public List<HLVMOD> findBy(String a, String b) throws Exception {
        String sql = "SELECT * FROM HLV WHERE " + a + " = N'" + b + "' ;";
        try (
                Connection con = Connect_DTB.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            try (ResultSet rs = pstmt.executeQuery();) {
                List<HLVMOD> list = new ArrayList<>();

                while (rs.next()) {
                    HLVMOD hlv = createHLV(rs);
                    list.add(hlv);

                }
                return list;
            }
        }
    }
    
// tạo mới
    private HLVMOD createHLV(final ResultSet rs) throws SQLException {
        HLVMOD hlv = new HLVMOD();
        hlv.setMaHLV(rs.getString("MaHLV"));
        hlv.setTenHVL(rs.getString("TenHLV"));
        hlv.setNgaySinh(rs.getString("NgaySinh"));
        hlv.setQueQuan(rs.getString("QueQuan"));
        hlv.setCMND(rs.getString("CMND"));
        hlv.setEmail(rs.getString("Email"));
        hlv.setChucVu(rs.getString("ChucVu"));
        hlv.setSDT(rs.getString("SDT"));

        return hlv;
    }



}
