package Tests;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Communicate;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Communicate.readFromXML;


public class TestActorPackage {
     public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {


        // Testing Client
        readFromXML("clients.xml", "client");
        
        /*
        List<Client> cleintList = new ArrayList<Client>();

        Client client;
        S

        client = (Client) Client.getByIdIfNExistCreateIt(cleintList, 1);
        System.out.println("client id = " + String.valueOf(client.getId()));
        System.out.println("clientList size = " + String.valueOf(cleintList.size()));

        client = (Client) Client.getByIdIfNExistCreateIt(cleintList, 2);
        System.out.println("client id = " + String.valueOf(client.getId()));
        System.out.println("clientList size = " + String.valueOf(cleintList.size()));

        client = (Client) Client.getByIdIfNExistCreateIt(cleintList, 2);
        System.out.println("client id = " + String.valueOf(client.getId()));
        System.out.println("clientList size = " + String.valueOf(cleintList.size()));

        client = (Client) Client.getByIdIfNExistCreateIt(cleintList, 3);
        System.out.println("client id = " + String.valueOf(client.getId()));
        System.out.println("clientList size = " + String.valueOf(cleintList.size()));

        */

        // Testing Client
        /*

        List<Client> supplierList = new ArrayList<Client>();

        Client supplier;

        supplier = (Client) Client.getByIdIfNExistCreateIt(supplierList, 1);
        System.out.println("supplier id = " + String.valueOf(supplier.getId()));
        System.out.println("clientList size = " + String.valueOf(supplierList.size()));

        supplier = (Client) Client.getByIdIfNExistCreateIt(supplierList, 2);
        System.out.println("supplier id = " + String.valueOf(supplier.getId()));
        System.out.println("clientList size = " + String.valueOf(supplierList.size()));

        supplier = (Client) Client.getByIdIfNExistCreateIt(supplierList, 2);
        System.out.println("supplier id = " + String.valueOf(supplier.getId()));
        System.out.println("clientList size = " + String.valueOf(supplierList.size()));

        supplier = (Client) Client.getByIdIfNExistCreateIt(supplierList, 3);
        System.out.println("supplier id = " + String.valueOf(supplier.getId()));
        System.out.println("clientList size = " + String.valueOf(supplierList.size()));
        */
    }
}
