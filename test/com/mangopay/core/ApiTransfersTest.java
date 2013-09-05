package com.mangopay.core;

import com.mangopay.entities.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiTransfers test methods
 */
public class ApiTransfersTest extends BaseTest {

    @Test
    public void test_Transfers_Create() throws Exception {
        UserNatural john = this.getJohn();
        Transfer transfer = this.getJohnsTransfer();
        
        assertTrue(transfer.Id.length() > 0);
        assertEquals(transfer.AuthorId, john.Id);
        assertEquals(transfer.CreditedUserId, john.Id);
    }
    
    @Test
    public void test_Transfers_Get() throws Exception {
        UserNatural john = this.getJohn();
        Transfer transfer = this.getJohnsTransfer();
        
        Transfer getTransfer = this._api.Transfers.get(transfer.Id);
        
        assertEquals(transfer.Id, getTransfer.Id);
        assertEquals(getTransfer.AuthorId, john.Id);
        assertEquals(getTransfer.CreditedUserId, john.Id);
        assertEqualInputProps(transfer, getTransfer);
    }
    
}