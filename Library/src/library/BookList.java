/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BookList {
    public ArrayList<Book> booklist;
    private int soluongsach;
    private String option;

    public BookList() {
        booklist = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooklist() {
        return booklist;
    }

    public int getSoluongsach() {
        return soluongsach;
    }

    public void setSoluongsach(int soluongsach) {
        this.soluongsach = soluongsach;
    }

    public void setBooklist(ArrayList booklist) {
        this.booklist = booklist;
    }
    
    public boolean checkMaSach(String masach)
    {
        for (Book bk : booklist)
        {
            if (bk.getMasach().compareToIgnoreCase(masach) == 0)
            {
                System.out.println("\n\t\tThem sach that bai! Trung ma sach!");
                return false;
            }
        }
        return true;
    }
    
    public void addBook()
    {
        System.out.println();
        System.out.println("\t\tNhap thong tin cho cuoc sach moi them vao:");
        Book bk = new Book();
        bk.input();
        if (checkMaSach(bk.getMasach()))
            booklist.add(bk);
    }
    
    public void removeBook()
    {
        try {
            int flag = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("\t\tNhap ma so cuon sach ban muon xoa: ");
            String masosachmuonxoa = sc.nextLine();
            for (Book bk : booklist)
            {
                if (bk.getMasach().compareToIgnoreCase(masosachmuonxoa) == 0)
                {
                    booklist.remove(bk);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                System.out.println("\n\t\tDA XOA THANH CONG\n");
            else System.out.println("\n\t\tKhong tim thay cuon sach ban muon xoa\n");
        } catch (Exception e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }
    
    public void inputForListBookWithFor()
    {
        while (true)
        {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println();
                System.out.print("\t\tBan muon nhap bao nhieu cuon sach? ");
                soluongsach = Integer.parseInt(sc.nextLine());
                if (soluongsach > 0 && soluongsach <= 100)
                    break;
                else System.out.println("\n\t\tNhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\n\t\tNhap sai! Vui long nhap lai");
            }    
        }
        for (int i = 0; i < soluongsach; i++)
        {
            System.out.println("\t\tNhap thong tin cuoc sach thu " + (i + 1));
            Book bk = new Book();
            bk.input();
            booklist.add(bk);
        }  
    }
    
    public void inputForListBookWithDoWhile()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        do
        {            
            addBook();
            System.out.println("\t\tBan muon nhap tiep? Yes or No");
            System.out.print("\t\tChon: ");
            option = sc.nextLine();
        }
        while(option.compareToIgnoreCase("yes") == 0);
    }
         
    public void printBookTitle()
    {
        System.out.println();
        System.out.format("%-20s%-30s%-30s%-25s%-25s%-20s%-20s", "MA SACH", "TEN SACH", "TEN TAC GIA", "NHA PHAT HANH", "THE LOAI", "SO LUONG", "TRANG THAI");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public void outputForListBook()
    {
        for (Book bk : booklist)
        {
            bk.outputForBook();
        }
    }
        
    public void searchByMaSach()
    {
        try {
            int flag1 = 0;
            int flag2 = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("\t\tNhap ma sach ban can tim: ");
            String masachcantim = sc.nextLine();      
            for (Book bk : booklist)
            {
                if (bk.getMasach().compareToIgnoreCase(masachcantim) == 0)
                {
                    if (flag2 == 0)
                    {
                        printBookTitle();
                        flag2 = 1;
                    }
                    bk.outputForBook();
                    flag1 = 1;
                }
            }
            if (flag1 == 1)
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            else System.out.println("\n\t\tKhong co ma sach ban can tim");
        } catch (Exception e) {
            System.out.println("\n\t\tNhap sai! Vui long nhap lai");
        }

    }
    
    public void searchByTenSach()
    {
        try {
            int flag1 = 0;
            int flag2 = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("\t\tNhap ten sach ban can tim: ");
            String tensachcantim = sc.nextLine();      
            for (Book bk : booklist)
            {
                if (bk.getTensach().compareToIgnoreCase(tensachcantim) == 0)
                {
                    if (flag2 == 0)
                    {
                        printBookTitle();
                        flag2 = 1;
                    }
                    bk.outputForBook();
                    flag1 = 1;
                }
            }
            if (flag1 == 1)
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            else System.out.println("\n\t\tKhong co ten sach ban can tim");
        } catch (Exception e) {
            System.out.println("\n\t\tNhap sai! Vui long nhap lai");
        }
    }
    
    public void searchByTenTacGia()
    {
        try {
            int flag1 = 0;
            int flag2 = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("\t\tNhap ten tac gia ban can tim: ");
            String tentacgiacantim = sc.nextLine();      
            for (Book bk : booklist)
            {
                if (bk.getTentacgia().compareToIgnoreCase(tentacgiacantim) == 0)
                {
                    if (flag2 == 0)
                    {
                        printBookTitle();
                        flag2 = 1;
                    }                
                    bk.outputForBook();
                    flag1 = 1;
                }
            }        
            if (flag1 == 1)
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            else System.out.println("\n\t\tKhong co ten tac gia ban can tim");
        } catch (Exception e) {
            System.out.println("\n\t\tNhap sai! Vui long nhap lai");
        }
    }
    
    public void searchByNhaPhatHanh()
    {
        try {
            int flag1 = 0;
            int flag2 = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("\t\tNhap nha phat hanh ban can tim: ");
            String nhaphathanhcantim = sc.nextLine();      
            for (Book bk : booklist)
            {
                if (bk.getNhaphathanh().compareToIgnoreCase(nhaphathanhcantim) == 0)
                {
                    if (flag2 == 0)
                    {
                        printBookTitle();
                        flag2 = 1;
                    }                
                    bk.outputForBook();
                    flag1 = 1;
                }
            }
            if (flag1 == 1)
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            else System.out.println("\n\t\tKhong co ten nha phat hanh ban can tim");
        } catch (Exception e) {
            System.out.println("\n\t\tNhap sai! Vui long nhap lai");
        }
    }
    
    public void searchByTheLoai()
    {
        try {
            int flag1 = 0;
            int flag2 = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("\t\tNhap the loai ban can tim: ");
            String theloaicantim = sc.nextLine();      
            for (Book bk : booklist)
            {
                if (bk.getTheloai().compareToIgnoreCase(theloaicantim) == 0)
                {
                    if (flag2 == 0)
                    {
                        printBookTitle();
                        flag2 = 1;
                    }
                    bk.outputForBook();
                    flag1 = 1;
                }
            }
            if (flag1 == 1)
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            else System.out.println("\n\t\tKhong co the loai ban can tim");
        } catch (Exception e) {
            System.out.println("\n\t\tNhap sai! Vui long nhap lai");
        }
    }
    
    public void searchByTrangThai()
    {
        try {
            int flag1 = 0;
            int flag2 = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("\t\tNhap trang thai ban can tim: ");
            String trangthaicantim = sc.nextLine();      
            for (Book bk : booklist)
            {
                if (bk.getTrangthai().compareToIgnoreCase(trangthaicantim) == 0)
                {
                    if (flag2 == 0)
                    {
                        printBookTitle();
                        flag2 = 1;
                    }                
                    bk.outputForBook();
                    flag1 = 1;
                }
            }   
            if (flag1 == 1)
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            else System.out.println("\n\t\tNhap sai! Vui long nhap lai");
        } catch (Exception e) {
            System.out.println("\n\t\tKhong co cuon sach voi trang thai ban tim");
        }
    }
    
    public void sortByMaSach()
    {
        booklist.sort(new Comparator<Book>()
        {
            @Override
            public int compare(Book b1, Book b2)
            {
                return b1.getMasach().compareTo(b2.getMasach());
            }
        });
    }
    
    public void sortByTenSach()
    {
        booklist.sort(new Comparator<Book>()
        {
            @Override
            public int compare(Book b1, Book b2)
            {
                return b1.getTensach().compareTo(b2.getTensach());
            }
        });
    }
    
    public void sortByTenTacGia()
    {
        booklist.sort(new Comparator<Book>()
        {
            @Override
            public int compare(Book b1, Book b2)
            {
                return b1.getTentacgia().compareTo(b2.getTentacgia());
            }
        });
    }
    
    public void sortByNhaPhatHanh()
    {
        booklist.sort(new Comparator<Book>()
        {
            @Override
            public int compare(Book b1, Book b2)
            {
                return b1.getNhaphathanh().compareTo(b2.getNhaphathanh());
            }
        });
    }
    
    public void sortByTheLoai()
    {
        booklist.sort(new Comparator<Book>()
        {
            @Override
            public int compare(Book b1, Book b2)
            {
                return b1.getTheloai().compareTo(b2.getTheloai());
            }
        });
    }
    
    public void sortBySoLuong()
    {
        booklist.sort(new Comparator<Book>()
        {
            @Override
            public int compare(Book b1, Book b2)
            {
                if (b1.getSoluong() > b2.getSoluong())
                    return 1;
                else if (b1.getSoluong() > b2.getSoluong())
                    return 0;
                else return -1;
            }
        });
    }
    
    public void sortByTrangThai()
    {
        booklist.sort(new Comparator<Book>()
        {
            @Override
            public int compare(Book b1, Book b2)
            {
                return b1.getTrangthai().compareTo(b2.getTrangthai());
            }
        });
    }
    
    public void countSoLuongAllBook()
    {
        int tong = 0;
        System.out.println();
        for (Book bk : booklist)
        {
            tong += bk.getSoluong();
            
        }
        System.out.println("\t\tSo luong toan bo sach: " + tong);
    }    

    public void countBookWithSameTacGia()
    {
        int dem; 
        System.out.println();
        System.out.println("\t\tDem so luong tac pham cua cac tac gia: ");
        System.out.println("\t\t---------------------------------------");
        for (int i = 0; i < booklist.size(); i++)
        {
            Book same = booklist.get(i);
            if (!booklist.get(i).getTentacgia().equals(""))
            {
                same.setTentacgia(booklist.get(i).getTentacgia());
                dem = 1;
                for (int j = i + 1; j < booklist.size(); j++)
                {
                    if (booklist.get(j).getTentacgia().equals(same.getTentacgia()))
                    {
                        dem++;
                        booklist.get(j).setTentacgia("");
                    }
                }                        
                System.out.println("\t\t" + same.getTentacgia() + ": " + dem + " dau sach");
            }          
        }
        System.out.println("\t\t---------------------------------------");
    }
    
    public void countBookWithSameNhaPhatHanh()
    {
        int dem; 
        System.out.println();
        System.out.println("\t\tDem so luong dau sach cua cac nha phat hanh: ");
        System.out.println("\t\t---------------------------------------------");
        for (int i = 0; i < booklist.size(); i++)
        {
            Book same = booklist.get(i);
            if (!booklist.get(i).getNhaphathanh().equals(""))
            {
                same.setNhaphathanh(booklist.get(i).getNhaphathanh());
                dem = 1;
                for (int j = i + 1; j < booklist.size(); j++)
                {
                    if (booklist.get(j).getNhaphathanh().equals(same.getNhaphathanh()))
                    {
                        dem++;
                        booklist.get(j).setNhaphathanh("");
                    }
                }                        
                System.out.println("\t\t" + same.getNhaphathanh() + ": " + dem + " dau sach");
            }          
        }
        System.out.println("\t\t---------------------------------------------");
    }
    
    public void countBookWithSameTheLoai()
    {
        try {         
            int dem; 
            System.out.println();
            System.out.println("\t\tDem so luong dau sach cua cac the loai: ");
            System.out.println("\t\t----------------------------------------");
            for (int i = 0; i < booklist.size(); i++)
            {
                Book same = booklist.get(i);
                if (!booklist.get(i).getTheloai().equals("Rong"))
                {
                    same.setTheloai(booklist.get(i).getTheloai());
                    dem = 1;
                    for (int j = i + 1; j < booklist.size(); j++)
                    {
                        if (booklist.get(j).getTheloai().equals(same.getTheloai()))
                        {
                            dem++;
                            booklist.get(j).setTheloai("Rong");
                        }
                    }                        
                    System.out.println("\t\t" + same.getTheloai() + ": " + dem + " dau sach");
                }          
            }
            System.out.println("\t\t----------------------------------------");
        } catch (Exception e)
        {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }
    
    public void saveBookListToFile()
    {
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Data.txt");
        try {        
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Book bk : booklist)
            {
                pw.println(bk.toString());
            }
            pw.close();
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }
    
    public void appendBookToFile()
    {
        Scanner sc = new Scanner(System.in);
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Data.txt");
        try {
            do {
                FileWriter fw = new FileWriter(f, true);
                PrintWriter pw = new PrintWriter(fw);
                Book bk = new Book();
                bk.input();
                pw.println(bk.toString());
                fw.close();
                pw.close();
                System.out.println("Ban muon tiep tuc them? Yes or No");
                System.out.print("Vui long chon: ");
                option = sc.nextLine();
            } 
            while(option.compareToIgnoreCase("yes") == 0);
        }
        catch (Exception e) {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }
    
    public void readBookListFromFile()
    {
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Data.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.trim() == "")
                    continue;
                String arr[] = line.split("[;]+");
                Book bk = new Book(arr[0], arr[1], arr[2], arr[3], arr[4], Integer.parseInt(arr[5].trim()), arr[6]);
                booklist.add(bk);
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }
    
    public void readUpdatedBookListFromFile()
    {
        booklist.removeAll(booklist);
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Data.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.trim() == "")
                    continue;
                String arr[] = line.split("[;]+");
                Book bk = new Book(arr[0], arr[1], arr[2], arr[3], arr[4], Integer.parseInt(arr[5].trim()), arr[6]);
                booklist.add(bk);
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.out.println("Failed: " + e.getMessage() + "\n");
        }        
    }
}