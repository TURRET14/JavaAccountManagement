package InputFunctions;

import Classes.Account;
import Classes.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

import static Data.BankData.AccountList;
import static InputFunctions.InputFunctions.*;

public class ChosenOptionFunctions {
    static public void ChooseOption() {
        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1. Создать счет.");
            System.out.println("2. Использовать счет.");
            System.out.println("3. Выйти.");
            int SelectedOption = GetIntInput(1, 3, "Введите номер варианта: ");
            switch (SelectedOption) {
                case 1:
                    CreateAccount();
                    break;
                case 2:
                    UseAccount();
                    break;
                case 3:
                    return;
            }
        }
    }
    static public void CreateAccount() {
        Account NewAccount = new Account();
        while (true) {
            int ID = GetIntInputOnlyMin(0, "Введите ID Счета: ");
            if (AccountList.stream().anyMatch((Account CurrentAccount) -> CurrentAccount.GetID() == ID)) {
                System.out.println("Ошибка: Этот ID Занят!");
            }
            else {
                NewAccount.SetID(ID);
                break;
            }
        }

        String Name = GetStringInput("Введите имя: ");
        NewAccount.SetName(Name);

        double Balance = GetDoubleInputOnlyMin(0, "Введите баланс: ");
        NewAccount.SetBalance(Balance);

        AccountList.add(NewAccount);
        System.out.println("Аккаунт успешно создан!");
    }

    static public void UseAccount() {
        Account SelectedAccount = null;
        while (true) {
            int SelectedAccountID = GetIntInputOnlyMin(0, "Введите ID Счета: ");
            try {
                SelectedAccount = AccountList.stream().filter((Account CurrentAccount) -> CurrentAccount.GetID() == SelectedAccountID).findFirst().get();
                break;
            } catch (Exception Ex) {
                System.out.println("Ошибка: Такого аккаунта нет!");
            }
        }

        System.out.println("Что вы хотите сделать?");
        System.out.println("1. Получить идентификатор счета.");
        System.out.println("2. Получить имя.");
        System.out.println("3. Получить баланс счета.");
        System.out.println("4. Получить годовую процентную ставку.");
        System.out.println("5. Получить сумму ежемесячных процентов.");
        System.out.println("6. Получить дату создания счета.");
        System.out.println("7. Изменить идентификатор счета.");
        System.out.println("8. Изменить имя.");
        System.out.println("9. Снять деньги со счета.");
        System.out.println("10. Пополнить счет.");
        System.out.println("11. Посмотреть список транзакций.");
        System.out.println("12. Выйти в главное меню.");
        while (true) {
            int ChosenAccountOption = GetIntInput(1, 12, "Введите номер варианта: ");
            switch (ChosenAccountOption) {
                case 1:
                    System.out.println("ID: " + SelectedAccount.GetID());
                    break;
                case 2:
                    System.out.println("Имя: " + SelectedAccount.GetName());
                case 3:
                    System.out.println("Баланс: " + SelectedAccount.GetBalance());
                    break;
                case 4:
                    System.out.println("Годовая процентная ставка: " + SelectedAccount.GetAnnualInterestRate());
                    break;
                case 5:
                    System.out.println("Сумма ежемесячных процентов: " + SelectedAccount.GetMonthlyInterest());
                    break;
                case 6:
                    System.out.println("Дата создания: " + SelectedAccount.GetDateCreated());
                    break;
                case 7:
                    int ID = GetIntInputOnlyMin(0, "Введите Новый ID Счета: ");
                    if (AccountList.stream().anyMatch((Account CurrentAccount) -> CurrentAccount.GetID() == ID)) {
                        System.out.println("Ошибка: Этот ID Занят!");
                    }
                    else {
                        SelectedAccount.SetID(ID);
                    }
                    break;
                case 8:
                    String Name = GetStringInput("Введите новое имя: ");
                    SelectedAccount.SetName(Name);
                case 9:
                    double SumToWithdraw = GetDoubleInputOnlyMin(0, "Введите сумму, которую хотите снять: ");
                    if (!SelectedAccount.Withdraw(SumToWithdraw)) {
                        System.out.println("Ошибка: Сумма слишком большая!");
                    }
                    break;
                case 10:
                    double SumToDeposit = GetDoubleInputOnlyMin(0, "Введите сумму, которую хотите положить: ");
                    SelectedAccount.Deposit(SumToDeposit);
                    break;
                case 11:
                    ArrayList<Transaction> Transactions = SelectedAccount.GetTransactions();
                    for (int Count = 0; Count < Transactions.size(); Count = Count + 1) {
                        System.out.println("Транзакция " + (Count + 1) + " :");
                        System.out.println("Дата: " + Transactions.get(Count).GetDate());
                        String Type;
                        if (Transactions.get(Count).GetIsWithdrawal()) {
                            Type = "Списание";
                        }
                        else {
                            Type = "Зачисление";
                        }
                        System.out.println("Тип: " + Type);
                        System.out.println("Сумма: " + Transactions.get(Count).GetAmount());
                        System.out.println("Баланс: " + Transactions.get(Count).GetBalance());
                        System.out.println("Описание: " + Transactions.get(Count).GetDescription());
                        if (Count != Transactions.size() - 1) {
                            System.out.println("----------");
                        }
                    }
                case 12:
                    return;
            }
        }
    }
}
