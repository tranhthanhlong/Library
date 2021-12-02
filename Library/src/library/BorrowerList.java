/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author Admin
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BorrowerList extends BookList {
    public ArrayList <Borrower>borrowerlist;
    private int soluongnguoimuon;
    private String option;

    public BorrowerList() {
        borrowerlist = new ArrayList<Borrower>();
    }

    public ArrayList getBorrowerlist() {
        return borrowerlist;
    }

    public int getSoluongnguoimuon() {
        return soluongnguoimuon;
    }

    public void setSoluongnguoimuon(int soluongnguoimuon) {
        this.soluongnguoimuon = soluongnguoimuon;
    }

    public void setBorrowerlist(ArrayList borrowerlist) {
        this.borrowerlist = borrowerlist;
    }
    
    public void addBorrower()
    { 
        Borrower bo = new Borrower();
        bo.input();
        borrowerlist.add(bo);
    }
    
    public void inputForListBorrowerWithFor()
    {
        while (true)
        {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("\t\tBan muon dang ky bao nhieu nguoi muon? ");
                soluongnguoimuon = Integer.parseInt(sc.nextLine());
                if (soluongnguoimuon > 0 && soluongnguoimuon <= 100)
                    break;
                else System.out.println("\t\tNhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\t\tNhap sai! Vui long nhap lai");
            }    
        }
        for (int i = 0; i < soluongnguoimuon; i++)
        {
            System.out.println("\t\tDang ky thong tin cho nguoi muon thu " + (i + 1));
            Borrower bo = new Borrower();
            bo.input();
            borrowerlist.add(bo);
        }  
    }

    public void inputForListBorrowerWithDoWhile()
    {
        Scanner sc = new Scanner(System.in);
        do
        {            
            addBorrower();
            System.out.println("\t\tBan muon nhap tiep? Yes or No");
            System.out.print("\t\tChon: ");
            option = sc.nextLine();
        }
        while(option.compareToIgnoreCase("yes") == 0);
    }
         
    public void printBorrowerTitle()
    {
        System.out.println();
        System.out.format("%-10s%-40s%-30s%-30s%-20s%-20s%-20s%-20s", "MA SO", "EMAIL DANG NHAP", "MAT KHAU", "HO TEN", "NGAY SINH", "GIOI TINH", "SDT", "DIA CHI");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public void outputForListBorrower()
    {
        for (Borrower bo : borrowerlist)
        {
            bo.outputForBorrower();
        }
    }  
        
    public void searchByMaSo()
    {
        try {
            int flag1 = 0;
            int flag2 = 0;
            Scanner sc = new Scanner(System.in);
            System.out.print("\n\t\tNhap ma so nguoi muon ban can tim: ");
            int masocantim = Integer.parseInt(sc.nextLine());    
            for (Borrower bo : borrowerlist)
            {
                if (bo.getMaso() == masocantim)
                {
                    if (flag2 == 0)
                    {
                        printBorrowerTitle();
                        flag2 = 1;
                    }        
                    bo.outputForBorrower();
                    flag1 = 1;
                }
            }
            if (flag1 == 1)
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            else System.out.println("\n\t\tKhong co ma so nguoi muon ban can tim");
        } catch  (Exception e) {
            System.out.println("\n\t\tNhap sai! Vui long nhap lai");
        }
    }
    
    public void searchByEmail()
    {
        int flag1 = 0;
        int flag2 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\tNhap email dang nhap ban can tim: ");
        String emailcantim = sc.nextLine();      
        for (Borrower bo : borrowerlist)
        {
            if (bo.getEmail().compareTo(emailcantim) == 0)
            {
                if (flag2 == 0)
                {
                    printBorrowerTitle();
                    flag2 = 1;
                }       
                bo.outputForBorrower();
                flag1 = 1;
            }
        }    
        if (flag1 == 1)
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        else System.out.println("\n\t\tKhong co email dang nhap ban can tim");
    }
    
    public void searchByHoTen()
    {
        int flag1 = 0;
        int flag2 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\tNhap ho ten ban can tim: ");
        String hotencantim = sc.nextLine();      
        for (Borrower bo : borrowerlist)
        {         
            if (bo.getHoten().compareToIgnoreCase(hotencantim) == 0)
            {
                if (flag2 == 0)
                {
                    printBorrowerTitle();
                    flag2 = 1;
                }                   
                bo.outputForBorrower();
                flag1 = 1;
            }
        }
        if (flag1 == 1)
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        else System.out.println("\n\t\tKhong co ho ten nguoi muon ban can tim");
    }
    
    public void sortByHoTen()
    {
        borrowerlist.sort(new Comparator<Borrower>()
        {
            @Override
            public int compare(Borrower bo1, Borrower bo2)
            {
                return bo1.getHoten().compareTo(bo2.getHoten());
            }
        });
    }
    
    public void sortByNgaySinh()
    {
        borrowerlist.sort(new Comparator<Borrower>()
        {
            @Override
            public int compare(Borrower bo1, Borrower bo2)
            {
                return bo1.getNgaysinh().compareTo(bo2.getNgaysinh());
            }
        });
    }
    
    public void sortByGioiTinh()
    {
        borrowerlist.sort(new Comparator<Borrower>()
        {
            @Override
            public int compare(Borrower bo1, Borrower bo2)
            {
                return bo1.getGioitinh().compareTo(bo2.getGioitinh());
            }
        });
    }

    public void saveBorrowerListToFile()
    {
        File f = new File("G:\\Tools\\Java Code\\Library\\Borrower Data.txt");
        try {        
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Borrower bo : borrowerlist)
            {
                pw.println(bo.toString());
            }
            pw.close();
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }
    
    public void appendBorrowerToFile()
    {

        Scanner sc = new Scanner(System.in);
        File f = new File("G:\\Tools\\Java Code\\Library\\Borrower Data.txt");
        try {
            int again = 1;
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            Borrower bo = new Borrower();
            do {
                bo.input();         
                for (Borrower bor : borrowerlist)
                {
                    if (bor.getEmail().compareToIgnoreCase(bo.getEmail()) == 0)
                    {
                        again = 0;
                        break;
                    }
                    else again = 1;
                }
                if (again == 0)
                    System.out.println("\n\t\tEmail nay da co nguoi dang ky\n");
            } while (again == 0);
            int tam = borrowerlist.size();
            bo.setMaso(++tam);
            pw.println(bo.toString());
            fw.close();
            pw.close();
        }
        catch (Exception e) {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }
    
    public void readBorrowerListFromFile()
    {
        File f = new File("G:\\Tools\\Java Code\\Library\\Borrower Data.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.trim() == "")
                    continue;
                String arr[] = line.split("[;]+");
                Borrower bo = new Borrower(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                borrowerlist.add(bo);
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.out.println("\t\tFailed: " + e.getMessage() + "\n");
        }
    }    
    
    public void readUpdatedBorrowerListFromFile()
    {
        borrowerlist.removeAll(borrowerlist);
        File f = new File("G:\\Tools\\Java Code\\Library\\Borrower Data.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            Borrower bo = new Borrower();
            bo.numberOfBorrowers = 0;
            while ((line = br.readLine()) != null)
            {
                if (line.trim() == "")
                    continue;
                String arr[] = line.split("[;]+");
                bo = new Borrower(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                borrowerlist.add(bo);
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.out.println("\t\tFailed: " + e.getMessage() + "\n");
        }        
    }    
}