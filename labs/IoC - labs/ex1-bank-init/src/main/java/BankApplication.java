import com.luxoft.bankapp.exceptions.ActiveAccountNotSet;
import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.AccountType;
import com.luxoft.bankapp.model.CheckingAccount;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.model.SavingAccount;
import com.luxoft.bankapp.service.BankReportService;
import com.luxoft.bankapp.service.BankReportServiceImpl;
import com.luxoft.bankapp.service.Banking;
import com.luxoft.bankapp.service.BankingImpl;
import com.luxoft.bankapp.model.Client.Gender;
import com.luxoft.bankapp.service.feed.BankFeedService;
import com.luxoft.bankapp.service.feed.BankFeedServiceImpl;
import com.luxoft.bankapp.service.storage.ClientStorage;
import com.luxoft.bankapp.service.storage.Storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BankApplication {
    private static final String[] CLIENT_NAMES =
            {"Jonny Bravo", "Adam Budzinski", "Anna Smith"};

    public static void main(String[] args) {
        Storage<Client> storage = new ClientStorage();
        Banking banking = initialize(storage);

        workWithExistingClients(banking);

        bankingServiceDemo(banking);

//        bankReportsDemo(storage);

//        bankFeedDemo(banking);
    }

    public static void bankFeedDemo(Banking banking) {
        System.out.println("\n=== Using BankFeedService ===\n");

        String fileName = "test.feed";

        BankFeedService feedService = new BankFeedServiceImpl(banking);

        feedService.saveFeed(fileName);

        System.out.println("Stored Clients");
        System.out.println("==============");
        try (BufferedReader reader = new BufferedReader(new FileReader("feeds/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nLoading clients from file.");
        System.out.println("==========================");

        banking = new BankingImpl();

        Storage<Client> newStorage = new ClientStorage();
        banking.setStorage(newStorage);

        feedService = new BankFeedServiceImpl(banking);

        feedService.loadFeed(new File(fileName));

        banking.getClients().forEach(System.out::println);
    }

    public static void bankReportsDemo(Storage<Client> storage) {
        System.out.println("\n=== Using BankReportService ===\n");

        BankReportService reportService = new BankReportServiceImpl();
        reportService.setStorage(storage);

        System.out.println("Number of clients: " + reportService.getNumberOfBankClients());


        System.out.println("Number of accounts: " + reportService.getAccountsNumber());


        System.out.println("Bank Credit Sum: " + reportService.getBankCreditSum());
    }

    public static void bankingServiceDemo(Banking banking) {
        System.out.println("\n=== Initialization using Banking implementation ===\n");

        Client anna = new Client(CLIENT_NAMES[2], Gender.FEMALE);
        anna = banking.addClient(anna);

        Account saving = banking.createAccount(anna, AccountType.SAVING);
        saving.deposit(1000);

        banking.updateAccount(anna, saving);

        Account checking = banking.createAccount(anna, AccountType.CHECKING);
        checking.deposit(3000);

        banking.updateAccount(anna, checking);

        banking.getAllAccounts(anna).stream().forEach(System.out::println);
    }

    public static void workWithExistingClients(Banking banking) {
        System.out.println("\n=======================================");
        System.out.println("\n===== Work with existing clients ======");

        Client jonny = banking.getClient(CLIENT_NAMES[0]);
        try {
            jonny.deposit(5_000);
        } catch (ActiveAccountNotSet e) {
            System.out.println(e.getMessage());

            jonny.setDefaultActiveAccountIfNotSet();
            jonny.deposit(5_000);
        }

        System.out.println(jonny);

        Client adam = banking.getClient(CLIENT_NAMES[1]);
        adam.setDefaultActiveAccountIfNotSet();

        adam.withdraw(1500);

        double balance = adam.getBalance();
        System.out.println("\n" + adam.getName() + ", current balance: " + balance);

        banking.transferMoney(jonny, adam, 1000);

        System.out.println("\n=======================================");
        banking.getClients().forEach(System.out::println);
    }

    /*
     * Method that creates a few clients and initializes them with sample values
     */
    public static Banking initialize(Storage<Client> storage) {
        Banking banking = new BankingImpl();
        banking.setStorage(storage);

        Client client_1 = new Client(CLIENT_NAMES[0], Gender.MALE);

        Account savingAccount = new SavingAccount(1000);
        client_1.addAccount(savingAccount);

        Account checkingAccount = new CheckingAccount(1000);
        client_1.addAccount(checkingAccount);


        Client client_2 = new Client(CLIENT_NAMES[1], Gender.MALE);

        Account checking = new CheckingAccount(1500);
        client_2.addAccount(checking);

        banking.addClient(client_1);
        banking.addClient(client_2);


        return banking;
    }
}
