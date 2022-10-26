package za.ac.cput.gui.Chulu.Table;
/*
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Tables;
import za.ac.cput.factory.TablesFactory;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class httpsmethodsTable {
    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    //Main Controller Url
    private String MainUrl = "http://localhost:8080/table";

    //Save Method with parameters
    public void saveTable(String tableID,
                            String tableStatus,
                            String capacity,
                            String tableType) {

        //Use parameters to build new Item
        Tables tables = TablesFactory.createTables(tableID,
                tableStatus, capacity, tableType);

        //Url used to create new Item
        String url = MainUrl + "/create";

        //Applying Password and username to hearders
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Tables> httpEntityCreate = new HttpEntity<>(tables, headers);

        //PostForEntity using url to create
        ResponseEntity<Tables> responseCreate = restTemplate.postForEntity(url, httpEntityCreate, Tables.class);

        if (responseCreate.getStatusCode() == HttpStatus.valueOf(200)) {
            JOptionPane.showMessageDialog(null, "Table Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Table not Saved");
        }
    }


    //Delete Method with ID parameter
    public void deleteTable(String id){
        Tables c = null;

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
    public Tables findTable(String id){
        Tables c = null;

        //Url used to read Item
        String url = MainUrl+ "/read/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Tables> httpEntityRead = new HttpEntity<>(c, headers);

        //PostForEntity using url to read
        ResponseEntity<Tables> responseRead = restTemplate.postForEntity(url, httpEntityRead, Tables.class);

        return responseRead.getBody();
    }

    //Update method with Item Parameter
    public void updateTable(Tables tables){

        //Url used to update Item
        String url =MainUrl +"/update";

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Tables> httpEntityUpdate = new HttpEntity<>(tables, headers);

        //PostForEntity - exchange with Post method
        ResponseEntity<Tables> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntityUpdate, Tables.class);
    }

    //Get All method with Set Parameter
    public Set<Tables> getTables(){

        //Create new Set
        Set<Tables> tablesSet = new HashSet<>();

        //Create Array
        Tables[] tables;

        //Url used to get All Items
        String url = MainUrl+"/findAll";

        //Applying Password and username to headers
        headers.setBasicAuth("user","password");

        //HttpEntity
        HttpEntity<String> httpEntityGetAll = new HttpEntity<>(null, headers);

        //ResponseEntity - exchange
        ResponseEntity<Tables[]> responseGetAll =restTemplate.exchange(url, HttpMethod.GET, httpEntityGetAll, Tables[].class);

        //Store response body in array
        tables = responseGetAll.getBody();

        //loop through array and add each item into the set
        for (Tables table : tables){
            tablesSet.add(table);
        }
        return tablesSet;
    }

}
