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
public class BookLoansAndBookReturns extends BorrowerList implements Comparable<BookLoansAndBookReturns> {
    protected String emaildangnhap;
    protected String matkhaudangnhap;
    protected String masachmuon;
    protected String ngaymuon;
    protected String ngaytra;
            
    public BookLoansAndBookReturns() {
    }

    public BookLoansAndBookReturns(String emaildangnhap, String matkhaudangnhap, String masachmuon, String ngaymuon, String ngaytra) throws Exception {
        this.emaildangnhap = emaildangnhap;
        this.matkhaudangnhap = matkhaudangnhap;
        this.masachmuon = masachmuon;
        this.ngaymuon = ngaymuon;
        this.ngaytra = ngaytra;
    }

    public String getEmaildangnhap() {
        return emaildangnhap;
    }

    public String getMatkhaudangnhap() {
        return matkhaudangnhap;
    }    

    public String getMasachmuon() {
        return masachmuon;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setMasachmuon(String masachmuon) {
        this.masachmuon = masachmuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }
     
    public void signIn()
    {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("\t\tNhap email dang nhap: ");
            emaildangnhap = sc.nextLine();
            System.out.print("\t\tNhap mat khau: ");
            matkhaudangnhap = sc.nextLine();
            for (Borrower bo : borrowerlist)
            {
                if (bo.getEmail().equals(emaildangnhap) && bo.getMatkhau().equals(matkhaudangnhap))
                {
                    System.out.println("\t\tDANG NHAP THANG CONG\n");
                    return;
                }
            }
            System.out.println("\n\t\tSai email dang nhap hoac mat khau\n");
        } while(true);
    }
    
    public void outputForBookLoansAndBookReturns()
    {
        System.out.format("%-40s%-30s%-20s%-20s%-20s", emaildangnhap, matkhaudangnhap, masachmuon, ngaymuon, ngaytra);
        System.out.println();
    }
    
    public boolean checkSignIn(String emaildangnhap, String matkhaudangnhap)
    {
        for (Borrower bo : borrowerlist)
        {
            if ((bo.getEmail().compareTo(emaildangnhap) == 0) && (bo.getMatkhau().compareTo(matkhaudangnhap) == 0))
            {
                System.out.println("\t\tDANG NHAP THANH CONG");
                return true;
            }
        }
        System.out.println("\n\t\tSai email dang nhap hoac mat khau");
        return false;
    }    
    
    public void printBorrowerInfo()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\tNhap email dang nhap: ");
        emaildangnhap = sc.nextLine();
        System.out.print("\t\tNhap mat khau: ");
        matkhaudangnhap = sc.nextLine();
        boolean result = checkSignIn(emaildangnhap, matkhaudangnhap);
        if (result)
        {
            int flag = 0;
            for (Borrower bo : borrowerlist)
            {
                if (bo.getEmail().equals(emaildangnhap) && bo.getMatkhau().equals(matkhaudangnhap))
                {
                    System.out.println();
                    System.out.format("%-10s%-40s%-30s%-30s%-20s%-20s%-20s%-20s", "MA SO", "EMAIL DANG NHAP", "MAT KHAU", "HO TEN", "NGAY SINH", "GIOI TINH", "SDT", "DIA CHI");
                    System.out.println();
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    bo.outputForBorrower();
                    System.out.print("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    flag = 1;
                    break;
                }
                else flag = 0;
            }
            System.out.println();
            if (flag == 0)
            {
                System.out.println("\t\tKhong co thong tin tai khoan");
            }
        }    
    }
    
    public void printBookLoansAndBookReturnsTitle()
    {
        System.out.println();
        System.out.format("%-40s%-30s%-20s%-20s%-20s", "EMAIL DANG NHAP", "MAT KHAU", "MA SACH MUON", "NGAY MUON", "NGAY TRA");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }
    
    @Override
    public String toString()
    {
        return emaildangnhap + ";" + matkhaudangnhap + ";" + masachmuon + ";" + ngaymuon + ";" + ngaytra;
    }
    
    @Override
    public int compareTo(BookLoansAndBookReturns bo)
    {
        return emaildangnhap.compareTo(bo.emaildangnhap);
    }    
}