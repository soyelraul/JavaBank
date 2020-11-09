package org.academiadecodigo.javabank.ui;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.ui.operations.Operation;
import org.academiadecodigo.javabank.ui.operations.account.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class EditCustomerMenu extends Menu {

    public EditCustomerMenu(Prompt prompt, Bank bank) {
        super(prompt, bank);
    }

    @Override
    public void init() {
        super.init();

        int customerId = createCustomerMenu();
        if (customerId == -1) {
            return;
        }

        Map<Integer, Operation> menuMap = new LinkedHashMap<>();

        MenuItem[] menuItems = new MenuItem[]{ MenuItem.ADDACCOUNT, MenuItem.CLOSEACCOUNTS, MenuItem.SHOWACCOUNTS,
                MenuItem.TRANSFERMONEY, MenuItem.DEPOSITMONEY, MenuItem.WITHDRAWMONEY, MenuItem.BACK };

        menuMap.put(1, new AddAccount(customerId, getPrompt(), getBank(), this));
        menuMap.put(2, new CloseAccount(customerId, getPrompt(), getBank(), this));
        menuMap.put(3, new ShowAccount(customerId, getPrompt(), getBank(), this));
        menuMap.put(4, new TransferMoney(customerId, getPrompt(), getBank(), this));
        menuMap.put(5, new DepositMoney(customerId, getPrompt(), getBank(), this));
        menuMap.put(6, new WithdrawMoney(customerId, getPrompt(), getBank(), this));

        int option = createMenu(menuItems);
        if (option == menuItems.length) {
            Menu menu = new MainMenu(getPrompt(), getBank());
            menu.init();
            return;
        }

        menuMap.get(option).execute();

        init();
    }
}
