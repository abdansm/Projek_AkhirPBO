package projekakhirpbo;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
/**
 *
 * @author ABDAN SM
 */
public class ModelKasir {
    protected String username;
    protected String namakasir;
    protected String id_produk[] = new String[99];
    protected String nama_produk[] = new String[99];
    protected double harga_produk[] = new double[99];
    protected double subharga_produk[] = new double[99];
    protected double totalharga_produk;
    protected int stok_produk[] = new int[99];
    protected String id_product;
    protected int jumlah_beli;
    protected int stok;
    protected String namaproduk;
    protected int kuantitas[]= new int[99];
    protected double harga;
    
    protected int id_transaksi;
    
    
   
    
   
   
   public Statement st;
   public ResultSet rs;
   Connection cn = projekakhirpbo.Koneksi.Koneksi();
  
    
   public void updateData(){
   try {
    st = cn.createStatement();
    st.executeUpdate("UPDATE produk set " 
        + "nama_produk='"       + namaproduk + "', "
        + "harga='"      + harga + "', "
        + "stok='"   + stok +"' where id_produk ='"+id_product +"'");
    
    
  } catch (Exception e) {
    e.printStackTrace();
  }
   
   }
  
   
    public void simpanDataProd(){
    try{
    st = cn.createStatement();
    
    st.executeUpdate("INSERT INTO produk VALUES('" + id_product + "','"
        + namaproduk + "','"
        + harga + "','"
        + stok + "')");
    JOptionPane.showMessageDialog(null,"Simpan Berhasil");
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    
    }
    
    public void getIdTransaksi(){
    
    try {
    st = cn.createStatement();
    rs = st.executeQuery("SELECT MAX(id_transaksi) FROM transaksi ");
    
   String str1 = rs.getString("MAX(id_transaksi)");
         id_transaksi = Integer.parseInt(str1);
        
    
  } catch(Exception e) {
    e.printStackTrace();
  }
    
    }
    
    public void simpanDataTrans(){
    try{
    st = cn.createStatement();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String str1 = LocalDate.now().format(formatter);
    
    st.executeUpdate("INSERT INTO transaksi (username_kasir , tgl_transaksi , total_harga) VALUES('" + username + "','"
        + str1 + "','"
        + totalharga_produk + "')");
    
    }
    catch(Exception e){
        e.printStackTrace();
    }

    
    }
    
    public void simpanDataDetailTrans(){
    
    try{
        for(int i=0;i<jumlah_beli;i++){
    st = cn.createStatement();
    
    st.executeUpdate("INSERT INTO detail_transaksi VALUES('" + id_transaksi + "','"
        + id_produk[i] + "','"
        + kuantitas[i] + "','"+ subharga_produk[i]+ "')");
    
    }
       JOptionPane.showMessageDialog(null,"Pembayaran Berhasil","Sukses",JOptionPane.PLAIN_MESSAGE); 
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    
    }
    
   
    public void ModelKasir(){
    jumlah_beli = 0;
    
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return username;
    }
    
     public void setJumlahBeli(int jumlah){
        this.jumlah_beli = jumlah;
    }
    
    public int getJumlahBeli(){
        return jumlah_beli;
    }
    
    
    public void setIdProd(String idprod,int jumlah){
        this.id_produk[jumlah-1] = idprod;
    }
    
    public void setNamaProd(String namaprod,int jumlah){
        this.nama_produk[jumlah-1] = namaprod;
    }
    
    public void setHargaProd(double hargaprod,int jumlah){
        this.harga_produk[jumlah-1] = hargaprod;
    }
    
    public void setStokProd(int stokprod,int jumlah){
        this.stok_produk[jumlah-1] = stokprod;
    }
    
    public void setIdProduk(String idpro){
        this.id_product = idpro;
    }
    
    public void setKuantitas(int kuan,int jumlah){
        this.kuantitas[jumlah-1] = kuan;
    }
    
    
    public String getIdProd(){
        return id_product;
    }
    
    public void setHarga(double harga){
        this.harga = harga;
    }
    
    public double getHarga(){
        return harga;
    }
    
    public double getHargaprod(int jumlah){
        return harga_produk[jumlah];
    }
    
    public int getKuantitasprod(int jumlah){
        return kuantitas[jumlah];
    }
    
    public double getSubHargaprod(int jumlah){
        return this.subharga_produk[jumlah];
    }
    
    public double getTotalHargaprod(){
        return totalharga_produk;
    }
    
    public String getNamaprod(int jumlah){
        return nama_produk[jumlah];
    }
    
    public String getNamaKasir(){
        return namakasir;
    }
    
    public void setnamaProd(String str){
        this.namaproduk = str;
    }
    
    public String getnamaProd(){
        return namaproduk;
    }
    public void setStok(int stok){
        this.stok = stok;
    }
    
    public int getStok(){
        return stok;
    }
    
    
    
}
