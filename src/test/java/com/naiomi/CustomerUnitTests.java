package com.naiomi;

import com.naiomi.customer.CustomerController;
import com.naiomi.customer.CustomerServiceImp;
import com.naiomi.customer.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerUnitTests {

    @Mock
    private CustomerServiceImp customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void testCreateCustomer() {
        Customer inputCustomer = new Customer();
        inputCustomer.setName("Jon");
        inputCustomer.setLastname("Doe");
        inputCustomer.setId(1L);
        inputCustomer.setStatus("ACTIVE");

        when(customerService.create(inputCustomer)).thenReturn(inputCustomer);

        Customer resultCustomer = customerController.create(inputCustomer);

        assertEquals(inputCustomer, resultCustomer);
    }

    @Test
    public void testUpdateCustomer() {
        Customer inputCustomer = new Customer();
        inputCustomer.setName("Jon");
        inputCustomer.setLastname("Doe");
        inputCustomer.setId(1L);
        inputCustomer.setStatus("ACTIVE");

        when(customerService.update(1L, inputCustomer)).thenReturn(inputCustomer);

        Customer resultCustomer = customerController.update(1L, inputCustomer);

        assertEquals(inputCustomer, resultCustomer);
    }

    @Test
    public void testDeleteCustomer() {
        customerController.delete(1L);
    }



}