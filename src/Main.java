import Classes.Account;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> AccountsList = new ArrayList<>();
        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1. Создать счет.");
            System.out.println("2. Использовать счет.");
            System.out.println("3. Выйти.");
            int ChosenMenuOption = 0;
            while (true) {
                Scanner InputScanner = new Scanner(System.in);
                System.out.print("Введите номер варианта: ");
                try {
                    ChosenMenuOption = InputScanner.nextInt();
                    if (!(ChosenMenuOption >= 1 && ChosenMenuOption <= 3)) {
                        System.out.println("Ошибка: Такого варианта нет!");
                    }
                    else {
                        break;
                    }
                }
                catch(Exception Ex) {
                    System.out.println("Ошибка: Вариант должен быть целым числом!");
                }
            }
            if (ChosenMenuOption == 1) {
                Account NewAccount = new Account();
                while (true) {
                    Scanner InputScanner = new Scanner(System.in);
                    System.out.print("Введите ID Счета: ");
                    int ID = 0;
                    boolean IsIDTaken = false;
                    try {
                        ID = InputScanner.nextInt();
                        if (ID < 0) {
                            System.out.println("Ошибка: Идентификатор не может быть отрицательным!");
                            continue;
                        }
                        for (Account CurrentAccount: AccountsList) {
                            if (CurrentAccount.GetID() == ID) {
                                System.out.println("Ошибка: Этот ID Занят!");
                                IsIDTaken = true;
                                break;
                            }
                        }
                        if (!IsIDTaken) {
                            NewAccount.SetID(ID);
                            break;
                        }
                    }
                    catch (Exception Ex) {
                        System.out.println("Ошибка: Идентификатор должен быть целым положительным числом!");
                    }
                }

                while (true) {
                    Scanner InputScanner = new Scanner(System.in);
                    System.out.print("Введите баланс: ");
                    double Balance = 0;
                    try {
                        Balance = InputScanner.nextDouble();
                        if (Balance < 0) {
                            System.out.println("Ошибка: Баланс не может быть отрицательным!");
                        }
                        else {
                            NewAccount.SetBalance(Balance);
                            break;
                        }
                    }
                    catch (Exception Ex) {
                        System.out.println("Ошибка: Баланс должен быть положительным числом!");
                    }
                }

                AccountsList.add(NewAccount);
                System.out.println("Аккаунт успешно создан!");
            }
            else if (ChosenMenuOption == 2) {
                int SelectedAccountID = 0;
                Account SelectedAccount = null;
                while (true) {
                    Scanner InputScanner = new Scanner(System.in);
                    System.out.print("Введите ID Счета: ");
                    boolean IsAccountFound = false;
                    try {
                        SelectedAccountID = InputScanner.nextInt();
                        for (Account CurrentAccount : AccountsList) {
                            if (CurrentAccount.GetID() == SelectedAccountID) {
                                SelectedAccount = CurrentAccount;
                                IsAccountFound = true;
                                break;
                            }
                        }
                        if (!IsAccountFound) {
                            System.out.println("Ошибка: Такого аккаунта нет!");
                        }
                        else {
                            break;
                        }
                    }
                    catch (Exception Ex) {
                        System.out.println("Ошибка: Идентификатор должен быть целым положительным числом!");
                    }
                }
                System.out.println("Что вы хотите сделать?");
                System.out.println("1. Получить идентификатор счета.");
                System.out.println("2. Получить баланс счета.");
                System.out.println("3. Получить годовую процентную ставку.");
                System.out.println("4. Получить сумму ежемесячных процентов.");
                System.out.println("5. Получить дату создания счета.");
                System.out.println("6. Изменить идентификатор счета.");
                System.out.println("7. Снять деньги со счета.");
                System.out.println("8. Пополнить счет.");
                System.out.println("9. Выйти в главное меню.");
                int ChosenAccountOption = 0;
                while (true) {
                    Scanner InputScanner = new Scanner(System.in);
                    System.out.print("Введите номер варианта: ");
                    try {
                        ChosenAccountOption = InputScanner.nextInt();
                        if (!(ChosenAccountOption >= 1 && ChosenAccountOption <= 9)) {
                            System.out.println("Ошибка: Такого варианта нет!");
                        }
                        else {
                            switch (ChosenAccountOption) {
                                case 1:
                                    System.out.println("ID: " + SelectedAccount.GetID());
                                    break;
                                case 2:
                                    System.out.println("Баланс: " +SelectedAccount.GetBalance());
                                    break;
                                case 3:
                                    System.out.println("Годовая процентная ставка: " + SelectedAccount.GetAnnualInterestRate());
                                    break;
                                case 4:
                                    System.out.println("Сумма ежемесячных процентов: " + SelectedAccount.GetMonthlyInterest());
                                    break;
                                case 5:
                                    System.out.println("Дата создания: " + SelectedAccount.GetDateCreated());
                                    break;
                                case 6:
                                    Scanner IDScanner = new Scanner(System.in);
                                    System.out.print("Введите ID Счета: ");
                                    int ID = 0;
                                    boolean IsIDTaken = false;
                                    try {
                                        ID = IDScanner.nextInt();
                                        if (ID < 0) {
                                            System.out.println("Ошибка: Идентификатор не может быть отрицательным!");
                                            continue;
                                        }
                                        for (Account CurrentAccount: AccountsList) {
                                            if (CurrentAccount.GetID() == ID) {
                                                System.out.println("Ошибка: Этот ID Занят!");
                                                IsIDTaken = true;
                                                break;
                                            }
                                        }
                                        if (!IsIDTaken) {
                                            SelectedAccount.SetID(ID);
                                            break;
                                        }
                                    }
                                    catch (Exception Ex) {
                                        System.out.println("Ошибка: Идентификатор должен быть целым положительным числом!");
                                    }
                                    break;
                                case 7:
                                    Scanner SumScanner = new Scanner(System.in);
                                    System.out.print("Введите сумму: ");
                                    double Sum = 0;
                                    try {
                                        Sum = SumScanner.nextDouble();
                                        if (Sum < 0) {
                                            System.out.println("Ошибка: Сумма не может быть отрицательной!");
                                        }
                                        else {
                                            if (!SelectedAccount.Withdraw(Sum)) {
                                                System.out.println("Ошибка: Сумма слишком большая!");
                                            }
                                        }
                                    }
                                    catch (Exception Ex) {
                                        System.out.println("Ошибка: Сумма должна быть положительным числом!");
                                    }
                                    break;
                                case 8:
                                    Scanner PutScanner = new Scanner(System.in);
                                    System.out.print("Введите сумму: ");
                                    double Put = 0;
                                    try {
                                        Put = PutScanner.nextDouble();
                                        if (Put < 0) {
                                            System.out.println("Ошибка: Сумма не может быть отрицательной!");
                                        }
                                        else {
                                            SelectedAccount.Deposit(Put);
                                        }
                                    }
                                    catch (Exception Ex) {
                                        System.out.println("Ошибка: Сумма должна быть положительным числом!");
                                    }
                                    break;
                            }
                            if (ChosenAccountOption == 9) {
                                break;
                            }
                        }
                    }
                    catch (Exception Ex) {
                        System.out.println("Ошибка: Вариант должен быть целым числом!");
                    }
                }
            }
            else {
                break;
            }
        }
    }
}