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

public class BookLoansAndBookReturnsList extends BookLoansAndBookReturns {
    public ArrayList<BookLoansAndBookReturns> bookloanslist; 
    public ArrayList<BookLoansAndBookReturns> bookreturnslist;
    private String tensachmuon;
    private String tensachtra;
    private int flagmuon = 0;
    private int flagtra = 0;
    private int soluong;

    public BookLoansAndBookReturnsList() {
        bookloanslist = new ArrayList<BookLoansAndBookReturns>();
        bookreturnslist = new ArrayList<BookLoansAndBookReturns>();
    }
    
    public ArrayList<BookLoansAndBookReturns> getBookloanslist() {
        return bookloanslist;
    }
    
    public ArrayList<BookLoansAndBookReturns> getBookreturnslist() {
        return bookreturnslist;
    }

    public void setBookloanslist(ArrayList<BookLoansAndBookReturns> bookloanslist) {
        this.bookloanslist = bookloanslist;
    }

    public void setBookreturnlist(ArrayList<BookLoansAndBookReturns> bookreturnslist) {
        this.bookreturnslist = bookreturnslist;
    }    
    
    public void addBookLoansData()
    {
        System.out.println();
        BookLoansAndBookReturnsList bk = new BookLoansAndBookReturnsList();
        bk.readBookListFromFile();
        bk.readBorrowerListFromFile();
        bk.signIn();
        bk.bookLoans();
        if (bk.flagmuon == 1)
        {
            bk.saveBookListToFile();
            bookloanslist.add(bk);
        }
    }
        
    public void addBookReturnsData()
    {
        System.out.println();
        BookLoansAndBookReturnsList bk = new BookLoansAndBookReturnsList();
        bk.readBookListFromFile();
        bk.readBorrowerListFromFile(); 
        bk.readBookLoansListFromFile();
        bk.signIn();
        bk.bookReturns();
        if (bk.flagtra == 1)
        {
            bk.saveBookListToFile();
            bk.saveBookLoansListToFile();
            bookreturnslist.add(bk);
        }     
    }

    public void bookLoans()
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\t\tNhap ten sach ban muon muon: ");
            tensachmuon = sc.nextLine();
            for (int i = 0; i < borrowerlist.size(); i++)
            {
                if (borrowerlist.get(i).getEmail().equals(emaildangnhap) && borrowerlist.get(i).getMatkhau().equals(matkhaudangnhap))
                {
                    for (int j = 0; j < booklist.size(); j++)
                    {
                        if (booklist.get(j).getTensach().compareToIgnoreCase(tensachmuon) == 0)
                        {
                            if (booklist.get(j).getTrangthai().equals("O"))
                            {
                                masachmuon = booklist.get(j).getMasach();
                                ngaymuon = java.time.LocalDate.now().toString();
                                setNgaytra(null);
                                soluong = booklist.get(j).getSoluong();
                                booklist.get(j).setSoluong(soluong-1);
                                if (booklist.get(j).getSoluong() == 0)
                                    booklist.get(j).setTrangthai("X");                                
                                flagmuon = 1;
                                System.out.print("\n\t\tBan da muon sach thanh cong!!!\n");
                                System.out.print("\t\tNgay muon: " + java.time.LocalDate.now() + "\n");                                
                            }
                            else if (booklist.get(j).getTrangthai().equals("X"))                            
                                System.out.print("\t\tCuon sach da co nguoi muon het roi\n");                            
                            break;
                        }
                    } 
                }
            }
            if (flagmuon == 0)
                System.out.println("\t\tCuon sach ban muon khong hop le");
        } catch (Exception e) {
            System.out.println("\t\tFailed: " + e.getMessage() + "\n");
        }    
    } 
    
    public String returnMaSachMuonIfFoundWithTenSachTra(String tensachtra)
    {
        for (Book bk : booklist)
        {
            if (bk.getTensach().compareToIgnoreCase(tensachtra) == 0)
            {
                masachmuon = bk.getMasach();
                return masachmuon;
            }
        }   
        return null;
    }    
    
    public void bookReturns()
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\t\tNhap ten sach ban muon tra: ");
            tensachtra = sc.nextLine(); 
            returnMaSachMuonIfFoundWithTenSachTra(tensachtra);
            for (BookLoansAndBookReturns bookloan : bookloanslist)
            {
                if (((bookloan.getEmaildangnhap().compareTo(emaildangnhap) == 0)) && (bookloan.getMatkhaudangnhap().compareTo(matkhaudangnhap) == 0) && (bookloan.getMasachmuon().compareTo(masachmuon) == 0) && (bookloan.getNgaytra().equals("null")))
                {
                    for (int i = 0; i < booklist.size(); i++)
                    {
                        if (booklist.get(i).getTensach().compareToIgnoreCase(tensachtra) == 0)
                        {
                            if (booklist.get(i).getTrangthai().equals("O"))
                            {
                                ngaymuon = bookloan.getNgaymuon();
                                ngaytra = java.time.LocalDate.now().toString();
                                System.out.print("\n\t\tBan da tra sach thanh cong!!!\n");
                                System.out.print("\t\tNgay tra: " + java.time.LocalDate.now() + "\n");                                
                                soluong = booklist.get(i).getSoluong();
                                booklist.get(i).setSoluong(soluong+1);
                                bookloan.setNgaytra(java.time.LocalDate.now().toString());                                
                            }
                            else if (booklist.get(i).getTrangthai().equals("X"))
                            {
                                ngaymuon = bookloan.getNgaymuon();
                                ngaytra = java.time.LocalDate.now().toString();
                                System.out.print("\n\t\tBan da tra sach thanh cong!!!\n");
                                System.out.print("\t\tNgay tra: " + java.time.LocalDate.now() + "\n");    
                                soluong = booklist.get(i).getSoluong();
                                booklist.get(i).setSoluong(soluong+1);
                                booklist.get(i).setTrangthai("O");
                                bookloan.setNgaytra(java.time.LocalDate.now().toString());                                
                            }
                            flagtra = 1;
                            break;
                        }
                    }
                }
                else flagtra = 0;
            }
            if (flagtra == 0)
                System.out.println("\t\tCuon sach ban tra khong hop le");
        } catch (Exception e) {
            System.out.println("\t\tFailed: " + e.getMessage() + "\n");
        }
    }
    
    public void outputForBookLoansList()
    {
        for (BookLoansAndBookReturns bk : bookloanslist)
        {
            bk.outputForBookLoansAndBookReturns();
        }
    }
    
    public void outputForBookReturnsList()
    {
        for (BookLoansAndBookReturns bk : bookreturnslist)
        {
            bk.outputForBookLoansAndBookReturns();
        }
    }
    
    public String returnHoTenNguoiMuonIfFoundWithEmail(String emailnguoimuon)
    {
        for (Borrower bo : borrowerlist)
        {
            if (bo.getEmail().compareToIgnoreCase(emailnguoimuon) == 0)
            {
                return bo.getHoten();
            }
        }   
        return null;        
    }
    
    public String returnTenSachIfFoundWithMaSach(String masachmuon)
    {
        for (Book bk : booklist)
        {
            if (bk.getMasach().compareToIgnoreCase(masachmuon) == 0)
            {
                return bk.getTensach();
            }
        }
        return null;
    }       
    
    public void searchBorrowedBook()
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\n\t\tNhap email dang nhap: ");
            emaildangnhap = sc.nextLine();
            System.out.print("\t\tNhap mat khau: ");
            matkhaudangnhap = sc.nextLine();
            boolean result = checkSignIn(emaildangnhap, matkhaudangnhap);
            if (result)
            {
                int flag1 = 0;
                int flag2 = 0;
                for (BookLoansAndBookReturns bl : bookloanslist)
                {
                    if (bl.getEmaildangnhap().equals(emaildangnhap) && bl.getMatkhaudangnhap().equals(matkhaudangnhap) && (bl.getNgaytra().equals("null")))
                    {
                        if (flag2 == 0)
                        {
                            System.out.println("\n\t\tSach dang muon: ");   
                            System.out.println("\t\t------------------------");
                            flag2 = 1;
                        }
                        String tensach = returnTenSachIfFoundWithMaSach(bl.getMasachmuon());
                        System.out.println("\t\t\t" + tensach);
                        flag1 = 1;
                    }
                }
                if (flag1 == 1)
                    System.out.println("\t\t------------------------");
                else System.out.println("\n\t\tBan dang khong muon cuon sach nao ca");
            }
        } catch (Exception e) {
            System.out.println("\n\t\tFailed: " + e.getMessage());
        }        
    }
    
    public void searchBorrowerHasntReturnedBook()
    {
        System.out.println();
        System.out.format("\t\t%-30s%-30s", "TEN SACH", "NGUOI MUON");
        System.out.println("\n\t\t------------------------------------------------------");
        for (BookLoansAndBookReturns bl : bookloanslist)
        {
            String hotennguoimuon = returnHoTenNguoiMuonIfFoundWithEmail(bl.getEmaildangnhap());
            if (bl.getNgaytra().compareTo("null") == 0)
            {
                for (Book bk : booklist)
                {
                    if (bl.getMasachmuon().compareTo(bk.getMasach()) == 0)
                    {
                        System.out.format("\t\t%-30s%-30s", bk.getTensach(), hotennguoimuon);
                    }
                }
            }
        }
        System.out.println("\n\t\t-------------------------------------------------------");
    } 
    
    public void sortByNgayMuon()
    {
        bookloanslist.sort(new Comparator<BookLoansAndBookReturns>()
        {
            @Override
            public int compare(BookLoansAndBookReturns b1, BookLoansAndBookReturns b2)
            {
                return b1.getNgaymuon().compareTo(b2.getNgaymuon());
            }
        });
    }
    
    public void sortByNgayTra()
    {
        bookreturnslist.sort(new Comparator<BookLoansAndBookReturns>()
        {
            @Override
            public int compare(BookLoansAndBookReturns b1, BookLoansAndBookReturns b2)
            {
                return b1.getNgaytra().compareTo(b2.getNgaytra());
            }
        });       
    }
    
    public void saveBookLoansListToFile()
    {
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Loans Data.txt");
        try {        
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (BookLoansAndBookReturns bk : bookloanslist)
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
    
    public void appendBookLoansToFile()
    {
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Loans Data.txt");
        try {        
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            int lastindex = bookloanslist.size()-1;
            pw.println(bookloanslist.get(lastindex).toString());
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }
    
    public void appendBookReturnsToFile()
    {
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Returns Data.txt");
        try {        
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            int lastindex = bookreturnslist.size()-1;
            pw.println(bookreturnslist.get(lastindex).toString());
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }
    
    public void readBookLoansListFromFile()
    {
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Loans Data.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.trim() == "")
                    continue;
                String arr[] = line.split("[;]+");
                BookLoansAndBookReturns bk = new BookLoansAndBookReturns(arr[0], arr[1], arr[2], arr[3], arr[4]);
                bookloanslist.add(bk);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }              
    
    public void readBookReturnsListFile()
    {
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Returns Data.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.trim() == "")
                    continue;
                String arr[] = line.split("[;]+");
                BookLoansAndBookReturns bk = new BookLoansAndBookReturns(arr[0], arr[1], arr[2], arr[3], arr[4]);
                bookreturnslist.add(bk);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }          

    public void readUpdatedBookLoansListFromFile()
    {
        bookloanslist.removeAll(bookloanslist);
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Loans Data.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.trim() == "")
                    continue;
                String arr[] = line.split("[;]+");
                BookLoansAndBookReturns bk = new BookLoansAndBookReturns(arr[0], arr[1], arr[2], arr[3], arr[4]);
                bookloanslist.add(bk);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }    
    
    public void readUpdatedBookReturnsListFile()
    {
        bookreturnslist.removeAll(bookreturnslist);
        File f = new File("G:\\Tools\\Java Code\\Library\\Book Returns Data.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.trim() == "")
                    continue;
                String arr[] = line.split("[;]+");
                BookLoansAndBookReturns bk = new BookLoansAndBookReturns(arr[0], arr[1], arr[2], arr[3], arr[4]);
                bookreturnslist.add(bk);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("\n\t\tFailed: " + e.getMessage() + "\n");
        }
    }         
}