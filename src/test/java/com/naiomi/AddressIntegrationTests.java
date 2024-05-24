//package com.naiomi;
//
//import io.micronaut.http.HttpStatus;
//import io.micronaut.http.client.RxHttpClient;
//import io.micronaut.http.client.annotation.Client;
//import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
//import jakarta.inject.Inject;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//@MicronautTest
//public class AddressIntegrationTests {
//
//    @Inject
//    @Client("/")
//    RxHttpClient client;
//
//    @Test
//    public void getAddressById_StatusOK() {
//        var response = client.toBlocking()
//                .exchange("/address/1", String.class);
//
//        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
//    }
//
//    @Test
//    public void getAddressById_StatusNotFound() {
//        var response = client.toBlocking()
//                .exchange("/address/66", String.class);
//
//        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatus());
//    }
//
//    @Test
//    public void getAddressByCity_StatusOK() {
//        var response = client.toBlocking()
//                .exchange("/address/filter/city/Chicago", String.class);
//
//        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
//    }
//
//    @Test
//    public void getAddressByCity_StatusOK_EmptyList() {
//        var response = client.toBlocking()
//                .exchange("/address/filter/city/TEST", String.class);
//
//        Assertions.assertEquals(HttpStatus.OK, response.getStatus());
//        Assertions.assertEquals("[]", response.body());
//    }
//
//    @Test
//    public void saveAddress_StatusCREATED() {
//        var newCustomer = """
//                {
//                    "id": "6",
//                    "street": "STREETSIX",
//                    "number": "6",
//                    "suburb": "PAULSHOF",
//                    "city": "SANDTON",
//                    "postalCode": "1234"
//                }""";
//
//        var response = client.toBlocking()
//                .exchange(HttpRequest.POST("/customers", newCustomer)
//                        .contentType(MediaType.APPLICATION_JSON), String.class);
//
//        Assertions.assertEquals(HttpStatus.CREATED, response.getStatus());
//    }
//}