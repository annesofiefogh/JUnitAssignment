package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test //INSERT
    public void testNewAccountBalance_After_Insert(){
        //Arrange
        Account account = new Account("1430", "Fred Jinx", 199);
        int expectedBalance = 200;
        //Act
        account.insert(1);
        //Assert
        assertEquals(expectedBalance, account.getAccountBalance());
    }

    @Test //INSERT
    public void testNewAccountBalance_TooSmallAmount_Or_TooBigAmount(){
        //Arrange
        Account account = new Account("1455", "Fred Jinx", 101);

        //Act + Assert
        assertThrows(IllegalArgumentException.class, () -> account.insert(156));
    }

    @Test //WITHDRAW
    public void testOverExceed_With_WithdrawAmount(){
        //Arrange
        Account account = new Account("4153", "Fred Jacks", 50);

        //Act + Assert
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(54));
    }

    @Test //TRANSFER
    public void testOverExceed_With_TransferAmount(){
        //Arrange
        Account account1 = new Account("4576", "Britt Large", 50);
        Account account2 = new Account("4576", "Britt Large");

        //Act + Assert
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(200, account2));
    }

}