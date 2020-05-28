import com.luxoft.bankapp.model.Account;
import com.luxoft.bankapp.model.AccountType;
import com.luxoft.bankapp.model.CheckingAccount;
import com.luxoft.bankapp.model.Client;
import com.luxoft.bankapp.service.Banking;
import com.luxoft.bankapp.service.BankingImpl;
import com.luxoft.bankapp.service.storage.ClientStorage;
import com.luxoft.bankapp.service.storage.Storage;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:application-context.xml")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BankApplicationTask1Tests {
    private static final String[] CLIENT_NAMES =
            {"Jonny Bravo", "Adam Budzinski", "Anna Smith"};

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Banking banking;

    @Autowired
    private Storage storage;

    @BeforeEach
    public void init() {
        try {
            BankApplication.class.getMethod("initialize", ApplicationContext.class).invoke(null, applicationContext);
        } catch (Exception e) {
            // ignore
        }

        // TODO you can replace code above with this when will have the method
//        BankApplication.initialize(applicationContext);
    }

    @Test
    public void storageBeanConfiguration() {
        assertNotNull(storage, "storage bean should be configured");
        assertTrue((storage instanceof ClientStorage), "storage should be instantiated with ClientStorage class");
    }

    @Test
    public void bankingBeanConfiguration() {
        assertNotNull(banking, "banking bean should be configured");
        assertTrue((banking instanceof BankingImpl), "storage should be instantiated with BankingImpl class");
    }

    @Test
    public void initializationClient1() {
        Client client = banking.getClient(CLIENT_NAMES[0]);
        assertNotNull(client, "banking should have client with name: " + CLIENT_NAMES[0]);

        assertEquals(2, client.getAccounts().size());
    }

    @Test
    public void client1SavingAccount() {
        Client client = banking.getClient(CLIENT_NAMES[0]);

        Account account = client.getAccount(AccountType.SAVING);

        assertNotNull(account,
                client.getName() + "should have " + AccountType.SAVING + " account");

        assertEquals(1000, account.getBalance());
    }

    @Test
    public void client1CheckingAccount() {
        Client client = banking.getClient(CLIENT_NAMES[0]);

        CheckingAccount account = (CheckingAccount) client.getAccount(AccountType.CHECKING);

        assertNotNull(account,
                client.getName() + "should have " + AccountType.CHECKING + " account");

        assertEquals(0, account.getBalance());
        assertEquals(1000, account.getOverdraft());
    }

    @Test
    public void initializationClient2() {
        Client client = banking.getClient(CLIENT_NAMES[1]);
        assertNotNull(client, "banking should have client with name: " + CLIENT_NAMES[1]);

        assertEquals(1, client.getAccounts().size());
    }

    @Test
    public void client2CheckingAccount() {
        Client client = banking.getClient(CLIENT_NAMES[1]);

        CheckingAccount account = (CheckingAccount) client.getAccount(AccountType.CHECKING);

        assertNotNull(account,
                client.getName() + "should have " + AccountType.CHECKING + " account");

        assertEquals(0, account.getBalance());
        assertEquals(1500, account.getOverdraft());
    }

    @Test
    public void workWithExistingClientsTest() {
        BankApplication.workWithExistingClients(banking);

        Client jonny = banking.getClient(CLIENT_NAMES[0]);
        assertEquals(4000, jonny.getActiveAccount().getBalance());

        Client adam = banking.getClient(CLIENT_NAMES[1]);
        assertEquals(-500, adam.getActiveAccount().getBalance());
    }

    @Test
    public void bankingServiceDemoTest() {
        BankApplication.bankingServiceDemo(banking);

        Client anna = banking.getClient(CLIENT_NAMES[2]);
        assertNotNull(anna, "banking should have client with name: " + CLIENT_NAMES[2]);

        Account saving = anna.getAccount(AccountType.SAVING);

        assertNotNull(saving, CLIENT_NAMES[2] + " should have "
                + AccountType.SAVING + " account.");
        assertEquals(1000, saving.getBalance());


        Account checking = anna.getAccount(AccountType.CHECKING);

        assertNotNull(checking, CLIENT_NAMES[2] + " should have "
                + AccountType.CHECKING + " account.");
        assertEquals(3000, checking.getBalance());
    }

}
