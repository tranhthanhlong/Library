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
public class RunMenu extends Menu {        
    
    public static void Line1()
    {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");    
    }
    
    public static void Line2()
    {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public void SwitchCaseAskIsBorrowerOrManager()
    {
        askIsBorrowerOrManager();
        switch (answerIsBorrowerOrManager)
        {
            case 0: SwitchCaseAskIfBorrowerHasAccount();
                break;
            case 1: SwitchCaseManagerMenu();
                break;
        }
    } 
    
    public void SwitchCaseAskIfBorrowerHasAccount()
    {
        askIfBorrowerHasAccount();
        switch (answerIfBorrowerHasAccount)
        {
            case "co": SwitchCaseBorrowerMenu();
                break;
            case "khong": menuForSignUp();
                          SwitchCaseBorrowerMenu();
                break;
        }
    } 
    
    public void SwitchCaseBorrowerMenu()
    {       
        Scanner sc = new Scanner(System.in);   
        do {
            menuForBorrower();
            switch (choiceMenuForBorrower)
            {                
                case 1: managelist.printBookTitle();
                        managelist.outputForListBook();
                        Line1();
                    break;
                case 2: borrowerSwitchCaseForBookSearch();
                    break;
                case 3: borrowerSwitchCaseForBookSort();
                   break;
                case 4: managelist.addBookLoansData();
                        managelist.appendBookLoansToFile();
                        managelist.readUpdatedBookListFromFile();
                   break;
                case 5: managelist.addBookReturnsData();
                        managelist.appendBookReturnsToFile();
                        managelist.readUpdatedBookListFromFile();
                        managelist.readUpdatedBookLoansListFromFile();
                   break;
                case 6: managelist.readUpdatedBorrowerListFromFile();
                        managelist.printBorrowerInfo();
                   break;
                case 7: managelist.readUpdatedBookLoansListFromFile();
                        managelist.searchBorrowedBook();
                   break;
            }
            System.out.println("\n\t\tBan muon quay lai menu? Yes Or No");
            System.out.print("\t\tVui long chon: ");
            option = sc.nextLine().toLowerCase();
        } while (option.equals("yes"));
    }    
    
    public void SwitchCaseManagerMenu()
    {
        Scanner sc = new Scanner(System.in);
        try {
            do {
                menuForManager();
                switch (choiceMenuForManager)
                {
                    case 1: managelist.printBookTitle();
                            managelist.outputForListBook();
                            Line1();
                        break;
                    case 2: managerSwitchCaseForBookSearch();
                        break;
                    case 3: managerSwitchCaseForBookSort();
                       break;
                    case 4: managerSwitchCaseForBookCount();
                       break;
                    case 5: managelist.appendBookToFile();
                            managelist.readUpdatedBookListFromFile();
                       break;
                    case 6: managelist.removeBook();
                            managelist.saveBookListToFile();
                            managelist.readUpdatedBookListFromFile();
                       break;
                    case 7: managelist.printBorrowerTitle();
                            managelist.outputForListBorrower();
                            Line2();
                       break;
                    case 8: managerSwitchCaseForBorrowerSearch();   
                       break;
                    case 9: managerSwitchCaseForBorrowerSort();
                       break;
                    case 10: managelist.inputForListBookWithFor();
                             managelist.saveBookListToFile();
                       break;
                    case 11: managelist.inputForListBorrowerWithFor();
                             managelist.saveBorrowerListToFile();
                    break;
                    case 12: managelist.printBookLoansAndBookReturnsTitle();
                             managelist.readUpdatedBookLoansListFromFile();
                             managelist.outputForBookLoansList();
                       break;
                    case 13: managelist.printBookLoansAndBookReturnsTitle();
                             managelist.readUpdatedBookReturnsListFile();
                             managelist.outputForBookReturnsList();
                       break;
                    case 14: managelist.readUpdatedBookLoansListFromFile();
                             managelist.searchBorrowerHasntReturnedBook();
                       break;
                    case 15: managelist.readUpdatedBookLoansListFromFile();
                             managelist.searchBorrowerHasntReturnedBook();
                       break;
                    case 16: managelist.printBookLoansAndBookReturnsTitle();
                             managelist.readUpdatedBookLoansListFromFile();
                             managelist.sortByNgayMuon();
                             managelist.outputForBookLoansList();
                       break;
                    case 17: managelist.printBookLoansAndBookReturnsTitle();
                             managelist.readUpdatedBookLoansListFromFile();
                             managelist.sortByNgayTra();
                             managelist.outputForBookLoansList();
                       break;
                }        
                System.out.println("\n\t\tBan muon quay lai menu? Yes Or No");
                System.out.print("\t\tVui long chon: ");
                option = sc.nextLine().toLowerCase();
            } while (option.equals("yes"));
        } catch (Exception e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }    
    
    public void borrowerSwitchCaseForBookSearch()
    {
        Scanner sc = new Scanner(System.in);
        do {
            borrowerMenuForSearchBook();
            switch (choiceBorrowerMenuForSearchBook)
            {
                case 1: managelist.searchByTenSach();
                    break;
                case 2: managelist.searchByTenTacGia();
                    break;
                case 3: managelist.searchByNhaPhatHanh();
                    break;
                case 4: managelist.searchByTheLoai();
                    break;
            }
            System.out.println("\n\t\tBan muon tiep tuc? Yes Or No");
            System.out.print("\t\tVui long chon: ");
            option = sc.nextLine().toLowerCase();
        } while (option.equals("yes"));
    }
    
    public void borrowerSwitchCaseForBookSort()
    {
        Scanner sc = new Scanner(System.in);       
        do {  
            borrowerMenuForSortBook();
            switch (choiceBorrowerMenuForSortBook)
            {
                case 1: managelist.printBookTitle();
                        managelist.sortByTenSach();
                        managelist.outputForListBook();
                    break;
                case 2: managelist.printBookTitle();
                        managelist.sortByTenTacGia();
                        managelist.outputForListBook();
                    break;
                case 3: managelist.printBookTitle();
                        managelist.sortByNhaPhatHanh();
                        managelist.outputForListBook();
                    break;
                case 4: managelist.printBookTitle();
                        managelist.sortByTheLoai();
                        managelist.outputForListBook();
                    break;
            }
            Line1();
            System.out.println("\n\t\tBan muon tiep tuc? Yes Or No");
            System.out.print("\t\tVui long chon: ");
            option = sc.nextLine().toLowerCase();
        } while (option.equals("yes"));
    }
    
    public void managerSwitchCaseForBookSearch()
    {
        Scanner sc = new Scanner(System.in);
        do { 
            managerMenuForSearchBook();
            switch (choiceManagerMenuForSearchBook)
            {
                case 1: managelist.searchByMaSach();
                    break;
                case 2: managelist.searchByTenSach();
                    break;
                case 3: managelist.searchByTenTacGia();
                    break;
                case 4: managelist.searchByNhaPhatHanh();
                    break;
                case 5: managelist.searchByTheLoai();
                    break;
                case 6: managelist.searchByTrangThai();
                    break;
            }
            System.out.println("\n\t\tBan muon tiep tuc? Yes Or No");
            System.out.print("\t\tVui long chon: ");
            option = sc.nextLine().toLowerCase();
        } while (option.equals("yes"));
    }
    
    public void managerSwitchCaseForBookSort()
    {
        Scanner sc = new Scanner(System.in);
        do {
            managerMenuForSortBook();
            switch (choiceManagerMenuForSortBook)
            {
                case 1: managelist.printBookTitle();
                        managelist.sortByMaSach();
                        managelist.outputForListBook();
                    break;
                case 2: managelist.printBookTitle();
                        managelist.sortByTenSach();
                        managelist.outputForListBook();
                    break;
                case 3: managelist.printBookTitle();
                        managelist.sortByTenTacGia();
                        managelist.outputForListBook();
                    break;
                case 4: managelist.printBookTitle();
                        managelist.sortByNhaPhatHanh();
                        managelist.outputForListBook();
                    break;
                case 5: managelist.printBookTitle();
                        managelist.sortByTheLoai();
                        managelist.outputForListBook();
                    break;
                case 6: managelist.printBookTitle();
                        managelist.sortBySoLuong();
                        managelist.outputForListBook();
                    break;         
                case 7: managelist.printBookTitle();
                        managelist.sortByTrangThai();
                        managelist.outputForListBook();
                    break;        
            }
            System.out.println("\n\t\tBan muon tiep tuc? Yes Or No");
            System.out.print("\t\tVui long chon: ");
            option = sc.nextLine().toLowerCase();
        } while (option.equals("yes"));
    }
    
    public void managerSwitchCaseForBookCount()
    {
        Scanner sc = new Scanner(System.in);
        do {
            managerMenuForBookCount();
            switch (choiceMenuForBookCount)
            {
                case 1: managelist.countSoLuongAllBook();
                    break;
                case 2: managelist.countBookWithSameTacGia();
                    break;
                case 3: managelist.countBookWithSameNhaPhatHanh();
                    break;
                case 4: managelist.countBookWithSameTheLoai();
                    break;            
            }
            System.out.println("\n\t\tBan muon tiep tuc? Yes Or No");
            System.out.print("\t\tVui long chon: ");
            option = sc.nextLine().toLowerCase();
        } while (option.equals("yes"));
    }    

    public void managerSwitchCaseForBorrowerSearch()
    {
        Scanner sc = new Scanner(System.in);        
        do {
            managerMenuForSearchBorrower();
            switch (choiceManagerMenuForSearchBorrower)
            {
                case 1: managelist.searchByMaSo();
                    break;
                case 2: managelist.searchByEmail();
                    break;
                case 3: managelist.searchByHoTen();
                    break;
            }
            System.out.println("\n\t\tBan muon tiep tuc? Yes Or No");
            System.out.print("\t\tVui long chon: ");
            option = sc.nextLine().toLowerCase();
        } while (option.equals("yes"));
    }

    public void managerSwitchCaseForBorrowerSort()
    {
        Scanner sc = new Scanner(System.in);
        do {
            managerMenuForSortBorrower();
            switch (choiceManagerMenuForSortBorrower)
            {
                case 1: managelist.printBorrowerTitle();
                        managelist.sortByHoTen();
                        managelist.outputForListBorrower();
                    break;
                case 2: managelist.printBorrowerTitle();
                        managelist.sortByNgaySinh();
                        managelist.outputForListBorrower();
                    break;
                case 3: managelist.printBorrowerTitle();
                        managelist.sortByGioiTinh();
                        managelist.outputForListBorrower();
                    break;
            }
            Line2();
            System.out.println("\n\t\tBan muon tiep tuc? Yes Or No");
            System.out.print("\t\tVui long chon: ");
            option = sc.nextLine().toLowerCase();
        } while (option.equals("yes"));
    }    
    
    public void RunMenu()
    {
        Scanner sc = new Scanner(System.in);
        managelist.readBookListFromFile();
        managelist.readBorrowerListFromFile();
        do {
            SwitchCaseAskIsBorrowerOrManager();
            System.out.println("\n\t\tBan muon quay lai giao dien? Yes or No");
            System.out.print("\t\tVui long chon: ");
            option = sc.nextLine().toLowerCase();
        } while (option.equals("yes"));
    }
}