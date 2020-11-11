package org.academiadecodigo.javabank.controller.menu;

import org.academiadecodigo.javabank.controller.CustomerController;
import org.academiadecodigo.javabank.service.AccountService;
import org.academiadecodigo.javabank.controller.AccountController;
import org.academiadecodigo.javabank.controller.account.*;
import org.academiadecodigo.javabank.view.PromptView;
import org.academiadecodigo.javabank.view.menu.EditCustomerMenuView;
import org.academiadecodigo.javabank.view.menu.MainMenuView;
import org.academiadecodigo.javabank.ui.MenuItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class EditCustomerMenuController extends CustomerController {

    private final EditCustomerMenuView view;

    public EditCustomerMenuController(AccountService customerServiceImplementation) {
        super(customerServiceImplementation);

        view = new EditCustomerMenuView();
    }

    @Override
    public void execute() {

        int chosenCostumer = view.createCustomerMenu(getBank());
        if (chosenCostumer == -1) {
            view.error();
            return;
        }

        view.success();

        Map<Integer, AccountController> menuMap = new LinkedHashMap<>();

        MenuItem[] menuItems = new MenuItem[]{ MenuItem.ADDACCOUNT, MenuItem.CLOSEACCOUNTS, MenuItem.SHOWACCOUNTS,
                MenuItem.TRANSFERMONEY, MenuItem.DEPOSITMONEY, MenuItem.WITHDRAWMONEY, MenuItem.BACK };

        menuMap.put(1, new AddAccountController(getBank(), getBank().get(chosenCostumer)));
        menuMap.put(2, new CloseAccountController(getBank(), getBank().get(chosenCostumer)));
        menuMap.put(3, new ShowAccountController(getBank(), getBank().get(chosenCostumer)));
        menuMap.put(4, new TransferMoneyController(getBank(), getBank().get(chosenCostumer)));
        menuMap.put(5, new DepositMoneyController(getBank(), getBank().get(chosenCostumer)));
        menuMap.put(6, new WithdrawMoneyController(getBank(), getBank().get(chosenCostumer)));

        int option = view.createMenu(menuItems);
        if (option == menuItems.length) {
            PromptView menuView = new MainMenuView();
            menuView.execute();
            return;
        }

        menuMap.get(option).execute();

        execute();
    }
}
