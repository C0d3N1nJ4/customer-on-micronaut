package com.naiomi.exceptions;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.hateoas.JsonError;

@Controller
public class GlobalExceptionHandler {

    @Error(global = true, exception = CustomerNotFoundException.class)
    public HttpResponse<JsonError> handleCustomerNotFoundException(HttpRequest request, CustomerNotFoundException e) {
        JsonError error = new JsonError(e.getMessage())
                .link("title", "Customer not found");
        return HttpResponse.status(HttpStatus.NOT_FOUND).body(error);
    }

    @Error(global = true, exception = StatusNotFoundException.class)
    public HttpResponse<JsonError> handleStatusNotFoundException(HttpRequest request, StatusNotFoundException e) {
        JsonError error = new JsonError(e.getMessage())
                .link("title", "Status not found");
        return HttpResponse.status(HttpStatus.NOT_FOUND).body(error);
    }

    @Error(global = true, exception = AddressNotFoundException.class)
    public HttpResponse<JsonError> handleAddressNotFoundException(HttpRequest request, AddressNotFoundException e) {
        JsonError error = new JsonError(e.getMessage())
                .link("title", "Address not found");
        return HttpResponse.status(HttpStatus.NOT_FOUND).body(error);
    }

    @Error(global = true, exception = ContactNotFoundException.class)
    public HttpResponse<JsonError> handleContactNotFoundException(HttpRequest request, ContactNotFoundException e) {
        JsonError error = new JsonError(e.getMessage())
                .link("title", "Contact not found");
        return HttpResponse.status(HttpStatus.NOT_FOUND).body(error);
    }

}
