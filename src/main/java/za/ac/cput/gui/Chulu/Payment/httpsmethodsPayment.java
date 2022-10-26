package za.ac.cput.gui.Chulu.Payment;

/*
 *  Entity for Payments
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Payments;
import za.ac.cput.factory.PaymentsFactory;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class httpsmethodsPayment {
    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    //Main Controller Url
    private String MainUrl = "http://localhost:8080/payment";

    //Save Method with parameters
    public void savePayment(String paymentID,
                             String customerID,
                             String paymentType,
                             String amount) {

        //Use parameters to build new Item
        Payments payments = PaymentsFactory.createPayments(paymentID,
                customerID, paymentType, amount);

        //Url used to create new Item
        String url = MainUrl + "/create";

        //Applying Password and username to hearders
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Payments> httpEntityCreate = new HttpEntity<>(payments, headers);

        //PostForEntity using url to create
        ResponseEntity<Payments> responseCreate = restTemplate.postForEntity(url, httpEntityCreate, Payments.class);

        if (responseCreate.getStatusCode() == HttpStatus.valueOf(200)) {
            JOptionPane.showMessageDialog(null, "Payment Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Payment not Saved");
        }
    }


    //Delete Method with ID parameter
    public void deletePayment(String id){
        Customer c = null;

        //Url used to delete Item
        String url = MainUrl+ "/delete/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //HTTpEntity with null
        HttpEntity<String> httpEntityDelete = new HttpEntity<>(null, headers);

        //PostForEntity - exchange with Delete method
        ResponseEntity<String> responseDelete = restTemplate.exchange(url, HttpMethod.DELETE, httpEntityDelete, String.class);

    }

    //Find Method with ID parameter
    public Payments findPayment(String id){
        Payments c = null;

        //Url used to read Item
        String url = MainUrl+ "/read/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Payments> httpEntityRead = new HttpEntity<>(c, headers);

        //PostForEntity using url to read
        ResponseEntity<Payments> responseRead = restTemplate.postForEntity(url, httpEntityRead, Payments.class);

        return responseRead.getBody();
    }


    //Update method with Item Parameter
    public void updatePayment(Payments payments){

        //Url used to update Item
        String url =MainUrl +"/update";

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Payments> httpEntityUpdate = new HttpEntity<>(payments, headers);

        //PostForEntity - exchange with Post method
        ResponseEntity<Payments> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntityUpdate, Payments.class);
    }

    //Get All method with Set Parameter
    public Set<Payments> getPayments(){

        //Create new Set
        Set<Payments> paymentsSet = new HashSet<>();

        //Create Array
        Payments[] payments;

        //Url used to get All Items
        String url = MainUrl+"/findAll";

        //Applying Password and username to headers
        headers.setBasicAuth("user","password");

        //HttpEntity
        HttpEntity<String> httpEntityGetAll = new HttpEntity<>(null, headers);

        //ResponseEntity - exchange
        ResponseEntity<Payments[]> responseGetAll =restTemplate.exchange(url, HttpMethod.GET, httpEntityGetAll, Payments[].class);

        //Store response body in array
        payments = responseGetAll.getBody();

        //loop through array and add each item into the set
        for (Payments payment : payments){
            paymentsSet.add(payment);
        }
        return paymentsSet;
    }


}

