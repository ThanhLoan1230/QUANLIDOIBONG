/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import MODEL.CauthuMOD;
import MODEL.LuongMOD;
import SQL.Connect_DTB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author My PC
 */
public class Luong {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author My PC
 */


    public List<LuongMOD> findAll() throws Exception {

        String sql = "select * from Luong";
        try (
                 Connection con = Connect_DTB.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            try ( ResultSet rs = pstmt.executeQuery();) {
                List<LuongMOD> list = new ArrayList<>();
                while (rs.next()) {
                    LuongMOD l = createLuong(rs);
                    list.add(l);
                }
                return list;
            }
        }
    }

    public boolean insert(LuongMOD l) throws Exception {

        String sql = "INSERT INTO Luong ( ma ,hovaten ,luong ,vaitro) VALUES (?, ?, ?, ? ) ";
        try (
                 Connection con = Connect_DTB.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

             pstmt.setString(1, l.getMa());
            pstmt.setString(2, l.getHovaTen());
            pstmt.setString(3, l.getLuong());
            pstmt.setString(4, l.getVaiTro());

            return pstmt.executeUpdate() > 0;
        }

    }

    public boolean update(LuongMOD l) throws Exception {

        String sql = " UPDATE dbo.Luong"
                + " SET hovaten = ? ,luong = ?, vaitro = ? "
                + " where Ma = ? ";
        try (
                 Connection con = Connect_DTB.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(4, l.getMa());
            pstmt.setString(1, l.getHovaTen());
            pstmt.setString(2, l.getLuong());
            pstmt.setString(3, l.getVaiTro());
            
            return pstmt.executeUpdate() > 0;
        }

    }
    public boolean delete(String Ma) throws Exception {

        String sql = "delete from Luong"
                + " where Ma = ? ";
        try (
                Connection con = Connect_DTB.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, Ma );

            return pstmt.executeUpdate() > 0;
        }
    }
     public LuongMOD findByID(String Ma)
            throws Exception {

        String sql = "select * from Luong where ma = ? ";
        try (
                Connection con = Connect_DTB.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1,Ma);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    LuongMOD l = createLuong(rs);
                    return l;
                }
            }
            return null;
        }

    } 
    
    public List<LuongMOD> findBy(String a, String b) throws Exception {
        String sql = "SELECT * FROM Luong   WHERE " + a + " = N'" + b + "' ;";
        try (
                Connection con = Connect_DTB.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            try (ResultSet rs = pstmt.executeQuery();) {
                List<LuongMOD> list = new ArrayList<>();

                while (rs.next()) {
                    LuongMOD l = createLuong(rs);
                    list.add(l);

                }
                return list;
            }
        }
    }
    

    private LuongMOD createLuong(final ResultSet rs) throws SQLException {
        LuongMOD l = new LuongMOD();
        l.setMa(rs.getString("ma"));
        l.setHovaTen(rs.getString("hovaten"));
        l.setLuong(rs.getString("luong"));
        l.setVaiTro(rs.getString("vaitro"));
       

        return l;
    }

}


