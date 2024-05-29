/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekakhirpbo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author ABDAN SM
 */
public class ControllerKasir extends ModelKasir {
   public Statement st;
   public ResultSet rs;
   Connection cn = projekakhirpbo.Koneksi.Koneksi();
   boolean berhasil=false;
    String sql;
    
    public void ControllerKasir(){
    jumlah_beli = 0;
    
    }
    
    public void nolkanJumlah(){
    jumlah_beli = 0;
    
    
    }
    
    public void kurangiStok(){
    for(int i = 0;i<jumlah_beli;i++){
    stok_produk[i] = stok_produk[i] - kuantitas[i];
    
    }
    
    }
    
    public void hitungKasir(){
        double buffer = 0.0;
    for(int i = 0;i<jumlah_beli;i++){
        subharga_produk[i] = harga_produk[i]*kuantitas[i];
        buffer = buffer + subharga_produk[i];  
        
    }
    totalharga_produk = buffer;
    
    }
    
    
    
    
    public boolean verifPass(String pass){
    try{
     sql = "SELECT * FROM kasir WHERE username='"+ username +"' AND password='"+pass+"'";
     st = cn.createStatement();
    rs = st.executeQuery(sql);
    if(rs.next()){
                if(username.equals(rs.getString("username")) && pass.equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "berhasil login"); berhasil = true;
                    namakasir = rs.getString("Nama") ;
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah"); berhasil = false;
                }
    
    
    
    }
    catch(Exception e){
     e.printStackTrace();
    
    }
    return berhasil;
    }
    
    
    
    
}
