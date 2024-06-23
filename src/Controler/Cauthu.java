/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import MODEL.CauthuMOD;
import SQL.Connect_DTB;
import java.util.List;
import java.awt.color.ICC_ColorSpace;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author My PC
 */
public class Cauthu {
    
    
    
    
// TRUY VÁN DỮ LIỆU TỪ DATABASE //
    
    
    public List<CauthuMOD> findAll() throws Exception {

        String sql = "select * from CauThu";
        try (
                 Connection con = Connect_DTB.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            try ( ResultSet rs = pstmt.executeQuery();) {
                List<CauthuMOD> list = new ArrayList<>();
                while (rs.next()) {
                    CauthuMOD ct = createCauThu(rs);
                    list.add(ct);
                }
                return list;
            }
        }
    }

    public boolean insert(CauthuMOD ct) throws Exception {

        String sql = "INSERT INTO CauThu ( MaCT ,Tencauthu ,Ngaysinh ,QueQuan ,CMND ,Email ,ViTri) VALUES (?, ?, ?, ? , ?, ?, ?) ";
        try (
                 Connection con = Connect_DTB.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, ct.getMaCT());
            pstmt.setString(2, ct.getTencauthu());
            pstmt.setString(3, ct.getNgaysinh());
            pstmt.setString(4, ct.getQueQuan());
            pstmt.setString(5, ct.getCMND());
            pstmt.setString(6, ct.getEmail());
            pstmt.setString(7, ct.getViTri());

            return pstmt.executeUpdate() > 0;
        }

    }

    public boolean update(CauthuMOD ct) throws Exception {

        String sql = " UPDATE dbo.CauThu"
                + " SET TenCauThu = ? ,NgaySinh = ?, QueQuan = ?,CMND = ?,Email = ?,ViTri = ? "
                + " where MaCT = ? ";
        try (
                 Connection con = Connect_DTB.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(7, ct.getMaCT());
            pstmt.setString(1, ct.getTencauthu());
            pstmt.setString(2, ct.getNgaysinh());
            pstmt.setString(3, ct.getQueQuan());
            pstmt.setString(4, ct.getCMND());
            pstmt.setString(5, ct.getEmail());
            pstmt.setString(6, ct.getViTri());

            return pstmt.executeUpdate() > 0;
        }

    }
    public boolean delete(String MaCT) throws Exception {

        String sql = "delete from CauThu"
                + " where MaCT = ? ";
        try (
                Connection con = Connect_DTB.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, MaCT );

            return pstmt.executeUpdate() > 0;
        }
    }
     public CauthuMOD findByID(String MaCT)
            throws Exception {

        String sql = "select * from CauThu where MaCT = ? ";
        try (
                Connection con = Connect_DTB.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1,MaCT);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    CauthuMOD ct = createCauThu(rs);
                    return ct;
                }
            }
            return null;
        }

    } 
    
    public List<CauthuMOD> findBy(String a, String b) throws Exception {
        String sql = "SELECT * FROM CauThu WHERE " + a + " = N'" + b + "' ;";
        try (
                Connection con = Connect_DTB.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            try (ResultSet rs = pstmt.executeQuery();) {
                List<CauthuMOD> list = new ArrayList<>();

                while (rs.next()) {
                    CauthuMOD ct = createCauThu(rs);
                    list.add(ct);

                }
                return list;
            }
        }
    }
    

    private CauthuMOD createCauThu(final ResultSet rs) throws SQLException {
        CauthuMOD ct = new CauthuMOD();
        ct.setMaCT(rs.getString("MaCT"));
        ct.setTencauthu(rs.getString("TenCauThu"));
        ct.setNgaysinh(rs.getString("NgaySinh"));
        ct.setQueQuan(rs.getString("QueQuan"));
        ct.setCMND(rs.getString("CMND"));
        ct.setEmail(rs.getString("Email"));
        ct.setViTri(rs.getString("ViTri"));

        return ct;
    }

}
