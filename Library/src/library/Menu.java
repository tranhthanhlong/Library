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
public class Menu {
    protected int answerIsBorrowerOrManager;
    protected String answerIfBorrowerHasAccount;
    protected int choiceMenuForBorrower;
    protected int choiceMenuForManager;
    protected int choiceBorrowerMenuForSearchBook;
    protected int choiceBorrowerMenuForSortBook;
    protected int choiceManagerMenuForSearchBook;
    protected int choiceManagerMenuForSortBook;
    protected int choiceManagerMenuForSearchBorrower;
    protected int choiceManagerMenuForSortBorrower; 
    protected int choiceMenuForBookCount;
    protected String option;

    BookLoansAndBookReturnsList managelist = new BookLoansAndBookReturnsList();
    
    public void askIsBorrowerOrManager()
    {
        while (true)
        {
            System.out.println();
            try {        
                Scanner sc = new Scanner(System.in);
                System.out.println("\t\t_________________Ban la nguoi muon sach hay quan ly thu vien_________________");
                System.out.println("\t\tNeu la nguoi muon sach thi chon 0 || Neu la nguoi quan ly thu vien thi chon 1");
                System.out.println("\t\t-----------------------------------------------------------------------------");
                System.out.print("\t\t                                Chon: ");
                answerIsBorrowerOrManager = Integer.parseInt(sc.nextLine());
                if (answerIsBorrowerOrManager >= 0 && answerIsBorrowerOrManager <= 1)
                    break;
                else System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }    
        }
    }
    
    public void askIfBorrowerHasAccount()
    {       
        while (true)
        {
            System.out.println();
            try {        
                Scanner sc = new Scanner(System.in);
                System.out.println("\t\t__________________________Ban da co tai khoan chua?__________________________");
                System.out.println("\t\t                                 CO || KHONG                                 ");
                System.out.println("\t\t-----------------------------------------------------------------------------");
                System.out.print("\t\t                                Chon: ");
                answerIfBorrowerHasAccount = sc.nextLine().toLowerCase();
                if (answerIfBorrowerHasAccount.compareToIgnoreCase("co") == 0 || answerIfBorrowerHasAccount.compareToIgnoreCase("khong") == 0)
                    break;
                else System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai\n");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai\n");
            }    
        }        
    }
    
    public void menuForSignUp()
    {
        System.out.println("\n\t\t_________________________Vui long dang ky tai khoan__________________________");
        managelist.appendBorrowerToFile();
        managelist.readUpdatedBorrowerListFromFile();
        System.out.println("\t\t-----------------------------------------------------------------------------");
        System.out.println("\t\t                             DANG KY THANH CONG");
    }

    public void menuForBorrower()
    {
        while (true)
        {
            System.out.println();
            try {        
                Scanner sc = new Scanner(System.in);
                System.out.println("\t\t________________MENU FOR BORROWER____________________________________________");
                System.out.println("\t\t                            1. Xem sach                                      ");
                System.out.println("\t\t                            2. Tim kiem sach                                 ");
                System.out.println("\t\t                            3. Sap xep sach                                  ");
                System.out.println("\t\t                            4. Dang ky muon sach                             ");
                System.out.println("\t\t                            5. Dang ky tra sach                              ");
                System.out.println("\t\t                            6. Xem thong tin ca nhan                         ");
                System.out.println("\t\t                            7. Xem sach dang muon                            ");
                System.out.println("\t\t-----------------------------------------------------------------------------");
                System.out.print("\t\t                            Chon: ");
                choiceMenuForBorrower = Integer.parseInt(sc.nextLine());
                if (choiceMenuForBorrower > 0 && choiceMenuForBorrower <= 7)
                    break;
                else System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai\n");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai\n");
            }    
        }
    }
    
    public void menuForManager()
    {
        while (true)
        {
            System.out.println();
            try {        
                Scanner sc = new Scanner(System.in);
                System.out.println("\t\t_____________MENU FOR MANAGER________________________________________________________________________________");
                System.out.println("\t\t1. Xem sach             ||     7. Xem thong tin nguoi muon        ||     12. Xem lich su muon sach      ");
                System.out.println("\t\t2. Tim kiem sach        ||     8. Tim kiem nguoi muon             ||     13. Xem lich su tra sach       ");
                System.out.println("\t\t3. Sap xep sach         ||     9. Sap xep nguoi muon              ||     14. Tim kiem cac sach dang muon");
                System.out.println("\t\t4. Dem so luong sach    ||    10. Nhap moi danh sach sach         ||     15. Tim kiem nguoi muon chua tra sach");
                System.out.println("\t\t5. Them sach            ||    11. Nhap moi danh sach nguoi muon   ||     16. Sap xep lich su theo ngay muon");
                System.out.println("\t\t6. Xoa sach             ||                  ---                   ||     17. Sap xep lich su theo ngay tra");
                System.out.println("\t\t--------------------------------------------------------------------------------------------------------------");
                System.out.print("\t\t                            Chon: ");
                choiceMenuForManager = Integer.parseInt(sc.nextLine());
                if (choiceMenuForManager > 0 && choiceMenuForManager <= 17)
                    break;
                else System.out.println("\n\t\t                               Nhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                               Nhap sai! Vui long nhap lai");
            }    
        }
    }
    
    public void borrowerMenuForSearchBook()
    {
        while (true)
        {
            System.out.println();
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("\t\t________________________________Tim kiem theo________________________________");
                System.out.println("\t\t                              1. Ten sach                                    ");
                System.out.println("\t\t                              2. Ten tac gia                                 ");
                System.out.println("\t\t                              3. Nha phat hanh                               ");
                System.out.println("\t\t                              4. The loai                                    ");
                System.out.println("\t\t-----------------------------------------------------------------------------");
                System.out.print("\t\t                              Chon: ");
                choiceBorrowerMenuForSearchBook = Integer.parseInt(sc.nextLine());
                if (choiceBorrowerMenuForSearchBook > 0 && choiceBorrowerMenuForSearchBook <= 4)
                    break;
                else System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }    
        }
    }
    
    public void borrowerMenuForSortBook()
    {
        while (true)
        {
            System.out.println();
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("\t\t_________________________________Sap xep theo________________________________");
                System.out.println("\t\t                               1. Ten sach");
                System.out.println("\t\t                               2. Ten tac gia");
                System.out.println("\t\t                               3. Nha phat hanh");
                System.out.println("\t\t                               4. The loai");
                System.out.println("\t\t-----------------------------------------------------------------------------");
                System.out.print("\t\t                               Chon: ");
                choiceBorrowerMenuForSortBook = Integer.parseInt(sc.nextLine());
                if (choiceBorrowerMenuForSortBook > 0 && choiceBorrowerMenuForSortBook <= 4)
                    break;
                else System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }    
        }        
    }
    
    public void managerMenuForSearchBook()
    {
        while (true)
        {
            System.out.println();
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("\t\t________________________________Tim kiem theo________________________________");
                System.out.println("\t\t                              1. Ma sach");
                System.out.println("\t\t                              2. Ten sach");
                System.out.println("\t\t                              3. Ten tac gia");
                System.out.println("\t\t                              4. Nha phat hanh");
                System.out.println("\t\t                              5. The loai sach");
                System.out.println("\t\t                              6. Trang thai sach");
                System.out.println("\t\t-----------------------------------------------------------------------------");
                System.out.print("\t\t                              Chon: ");
                choiceManagerMenuForSearchBook = Integer.parseInt(sc.nextLine());
                if (choiceManagerMenuForSearchBook > 0 && choiceManagerMenuForSearchBook <= 6)
                    break;
                else System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }    
        }  
    }
 
    public void managerMenuForSortBook()
    {
        while (true)
        {
            System.out.println();
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("\t\t_________________________________Sap xep theo________________________________");
                System.out.println("\t\t                               1. Ma sach");
                System.out.println("\t\t                               2. Ten sach");
                System.out.println("\t\t                               3. Ten tac gia");
                System.out.println("\t\t                               4. Nha phat hanh");
                System.out.println("\t\t                               5. The loai sach");
                System.out.println("\t\t                               6. So luong sach");
                System.out.println("\t\t                               7. Trang thai sach");
                System.out.println("\t\t-----------------------------------------------------------------------------");
                System.out.print("\t\t                               Chon: ");
                choiceManagerMenuForSortBook = Integer.parseInt(sc.nextLine());
                if (choiceManagerMenuForSortBook > 0 && choiceManagerMenuForSortBook <= 7)
                    break;
                else System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }    
        }  
    }
    
    public void managerMenuForBookCount()
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println();
            try {
                System.out.println("\t\t___________________________________Dem sach__________________________________");
                System.out.println("\t\t                                 1. Toan bo sach");
                System.out.println("\t\t                                 2. Theo tac gia");
                System.out.println("\t\t                                 3. Theo nha phat hanh");
                System.out.println("\t\t                                 4. Theo the loai");
                System.out.println("\t\t-----------------------------------------------------------------------------");
                System.out.print("\t\t                                 Chon: ");
                choiceMenuForBookCount = Integer.parseInt(sc.nextLine());
                if (choiceMenuForBookCount > 0 && choiceMenuForBookCount <= 4)
                    break;
                else System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }    
        }          
    }
    
    public void managerMenuForSearchBorrower()
    {
        while (true)
        {
            System.out.println();
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("\t\t________________________________Tim kiem theo________________________________");
                System.out.println("\t\t                              1. Ma so ");
                System.out.println("\t\t                              2. Email dang nhap");
                System.out.println("\t\t                              3. Ho Ten");
                System.out.println("\t\t-----------------------------------------------------------------------------");
                System.out.print("\t\t                              Chon: ");
                choiceManagerMenuForSearchBorrower = Integer.parseInt(sc.nextLine());
                if (choiceManagerMenuForSearchBorrower > 0 && choiceManagerMenuForSearchBorrower <= 3)
                    break;
                else System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }    
        }  
    }   

    public void managerMenuForSortBorrower()
    {
        while (true)
        {
            System.out.println();
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("\t\t_________________________________Sap xep theo________________________________");
                System.out.println("\t\t                               1. Ho ten ");
                System.out.println("\t\t                               2. Ngay sinh");
                System.out.println("\t\t                               3. Gioi tinh");
                System.out.println("\t\t-----------------------------------------------------------------------------");
                System.out.print("\t\t                               Chon: ");
                choiceManagerMenuForSortBorrower = Integer.parseInt(sc.nextLine());
                if (choiceManagerMenuForSortBorrower > 0 && choiceManagerMenuForSortBorrower <= 3)
                    break;
                else System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }
            catch (Exception e) {
                System.out.println("\n\t\t                         Nhap sai! Vui long nhap lai");
            }    
        }  
    }        
}