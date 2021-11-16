package Tests;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.WoodPiece;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Communicate.readFromXML;


public class TestActorPackage {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, ParseException {


        // Testing Client
        String tagName = "client";
        List<WoodPiece> wood = readFromXML("clients.xml", tagName);
        for(int i = 0 ; i < wood.size(); i++)
            System.out.println("Selected " + tagName + " : id " + wood.get(i).getTypeId()
                    + " with wood id " + wood.get(i).getTypeId()
                    + ", number " +wood.get(i).getNbrPiecesFromType()
                    + ", date " + wood.get(i).getCritical_date()
                    + " and price " + wood.get(i).getPrice());
        /*

        List<Client> cleintList = new ArrayList<Client>();

        Client client;


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
