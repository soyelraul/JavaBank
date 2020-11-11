package org.academiadecodigo.javabank.view.customer;

import org.academiadecodigo.javabank.view.PromptView;

public class ShowCustomerPromptView extends PromptView {

    private String allCustomersInfo;

    public ShowCustomerPromptView(String allCustomersInfo) {
        this.allCustomersInfo = allCustomersInfo;
    }

    @Override
    public void success() {
        System.err.println("\n" + allCustomersInfo);
    }

    @Override
    public void error() {
        System.err.println("\nPlease create a costumer before proceeding...");
    }
}