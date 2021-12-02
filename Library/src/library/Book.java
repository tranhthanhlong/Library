/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Book implements Comparable<Book> {
    private String masach;
    private String tensach;
    private String tentacgia;
    private String nhaphathanh;
    private String theloai;
    private int soluong;
    private String trangthai;
    
    public Book() {
    }

    public Book(String masach, String tensach, String tentacgia, String nhaphathanh, String theloai, int soluong, String trangthai) throws Exception {
        setMasach(masach);
        this.tensach = tensach;
        this.tentacgia = tentacgia;
        this.nhaphathanh = nhaphathanh;
        setTheloai(theloai);
        setSoluong(soluong);
        if (soluong > 0)
            this.trangthai = "O";
        else this.trangthai = "X";
    }

    public String getMasach() {
        return masach;
    }

    public String getTensach() {
        return tensach;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public String getNhaphathanh() {
        return nhaphathanh;
    }

    public String getTheloai() {
        return theloai;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getTrangthai() {
        if (soluong > 0)
            return trangthai = "O";
        else return trangthai = "X";
    }

    public void setMasach(String masach) throws Exception {
        String regex = "[a-zA-Z]{2}[0-9]{4}";
        if (masach.matches(regex) == false)
            throw new Exception("\t\tMa sach khong hop le");
        else this.masach = masach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public void setNhaphathanh(String nhaphathanh) {
        this.nhaphathanh = nhaphathanh;
    }

    public void setTheloai(String theloai) throws Exception {
        String regex = ".\\D+";
        if (theloai.matches(regex))
            this.theloai = theloai;
        else throw new Exception("\t\tThe loai khong hop le");
    }

    public void setSoluong(int soluong) throws Exception {
        if (soluong >= 0)
            this.soluong = soluong;
        else throw new Exception("\t\tSo luong khong hop le");
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
    public void input()
    {
        int again = 1;
        while (again == 1) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("\t\tNhap ma sach: ");            
                setMasach(sc.nextLine());                
                System.out.print("\t\tNhap ten sach: ");
                tensach = sc.nextLine();
                System.out.print("\t\tNhap ten tac gia: ");
                tentacgia = sc.nextLine();
                System.out.print("\t\tNhap nha phat hanh: ");
                nhaphathanh = sc.nextLine();
                System.out.print("\t\tNhap the loai sach: ");
                setTheloai(theloai = sc.nextLine());
                System.out.print("\t\tNhap so luong: ");            
                setSoluong(Integer.parseInt(sc.nextLine()));
                again = 0;
                } 
            catch (Exception e) {
                System.out.println("\n\t\tNhap sai! vui long nhap lai\n");
            }
        }
    }
    
    public void outputForBook()
    {
        System.out.format("%-20s%-30s%-30s%-25s%-25s%-20d%-25s", masach, tensach, tentacgia, nhaphathanh, theloai, soluong, getTrangthai());
        System.out.println();
    }
    
    @Override
    public String toString()
    {
        return masach + ";" + tensach + ";" + tentacgia + ";" + nhaphathanh + ";" + theloai + ";" + soluong + ";" + getTrangthai();
    }
    
    @Override
    public int compareTo(Book bk)
    {
        return masach.compareTo(bk.masach);
    }
}