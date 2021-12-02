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
public class Borrower implements Comparable<Borrower> {
    private int maso;
    private String email;
    private String matkhau;
    private String hoten;
    private String ngaysinh;
    private String gioitinh;
    private String sdt;
    private String diachi;
    public static int numberOfBorrowers = 0;    

    public Borrower() {
    }

    public Borrower(int maso, String email, String matkhau, String hoten, String ngaysinh, String gioitinh, String sdt, String diachi) throws Exception {
        this.maso = ++numberOfBorrowers;
        setEmail(email);
        this.matkhau = matkhau;
        setHoten(hoten);
        setNgaysinh(ngaysinh);
        setGioitinh(gioitinh);
        setSdt(sdt);
        setDiachi(diachi);
    }

    public int getMaso() {
        return maso;
    }

    public String getEmail() {
        return email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }
    
    public String getSdt() {
        return sdt;
    }

    public String getDiachi() {
        return diachi;
    }   

    public void setMaso(int maso) {
        this.maso = maso;
    }  

    public void setEmail(String email) throws Exception {
        String regex1 = ".+@.+.vn";
        String regex2 = ".+@.+.com";
        if (email.matches(regex1) || email.matches(regex2))
            this.email = email;
        else throw new Exception("\t\tEmail khong hop le");
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setHoten(String hoten) throws Exception {
        String regex = ".\\D+";
        if (hoten.matches(regex))
            this.hoten = hoten;
        else throw new Exception("\t\tHo ten khong hop le");
    }

    public void setNgaysinh(String ngaysinh) throws Exception {
        String regex = "^\\d{4}(\\/)(0?[1-9]|1[012])(\\/)(0?[1-9]|[12][0-9]|3[01])$";
        if (ngaysinh.matches(regex))
            this.ngaysinh = ngaysinh;
        else throw new Exception("\t\tNgay sinh khong hop le");
    }

    public void setGioitinh(String gioitinh) throws Exception {
        String regex = ".\\D+";
        if (gioitinh.matches(regex))
            this.gioitinh = gioitinh;
        else throw new Exception("\t\tGioi tinh khong hop le");
    }
    
    public void setSdt(String sdt) throws Exception {
        String regex = "[0-9]{10}";
        if (sdt.matches(regex))
            this.sdt = sdt;
        else throw new Exception("\t\tSdt khong hop le");
    }
 
    public void setDiachi(String diachi) throws Exception {
        if (diachi.length() < 50)
            this.diachi = diachi;
        else throw new Exception("\t\tDia chi khong hop le");
    }

    public void input()
    {
        int again = 1;
        while (again == 1)
        {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("\t\tDang ky email dang nhap: ");
                setEmail(sc.nextLine());
                System.out.print("\t\tNhap mat khau: ");
                matkhau = sc.nextLine();
                System.out.print("\t\tNhap ho ten: ");
                setHoten(sc.nextLine());
                System.out.print("\t\tNhap ngay sinh (YYYY/MM/DD): ");
                setNgaysinh(sc.nextLine());
                System.out.print("\t\tNhap gioi tinh: ");
                setGioitinh(sc.nextLine());
                System.out.print("\t\tNhap so dien thoai: ");
                setSdt(sc.nextLine());
                System.out.print("\t\tNhap dia chi: ");
                setDiachi(sc.nextLine());
                again = 0;
            }
            catch (Exception e)
            {
                System.out.println("\t\tNhap sai! Vui long nhap lai");
            }
        }
    }
    
    public void outputForBorrower()
    {
        System.out.format("%-10d%-40s%-30s%-30s%-20s%-20s%-20s%-20s", maso, email, matkhau, hoten, ngaysinh, gioitinh, sdt, diachi);
        System.out.println();
    }
    
    @Override
    public String toString()
    {
        return maso + ";" + email + ";" + matkhau + ";" + hoten + ";" + ngaysinh + ";" + gioitinh + ";" + sdt + ";" + diachi;
    }
    
    @Override
    public int compareTo(Borrower bo)
    {
        if (maso > bo.maso)
            return 1;
        else if (maso == bo.maso)
            return 0;
        else return -1;
    }
}