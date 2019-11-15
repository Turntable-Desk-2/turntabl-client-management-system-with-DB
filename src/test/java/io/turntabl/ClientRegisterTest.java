package io.turntabl;

import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Level;

import static org.junit.Assert.*;

public class ClientRegisterTest{
    Client client1 = new Client(001, "Isaac Agyen", "Dome Pillar2", "+23345454664542", "isaac@gmail.com", ClientLevel.GOLD);
    Client client2 = new Client(002, "Shadrack Amoakohene", "Dankoman", "+2355454458272", "shad@gmail.com", ClientLevel.PLATINUM);
    Client client3 = new Client(003, "Yaa Nuamah", "Dansoman", "+23355345572", "yaa@gmail.com", ClientLevel.PREMIUM);
    Client client4 = new Client(004, "Sam Bartels", "Ashaiman", "+23355554572", "sam@gmail.com", ClientLevel.GOLD);
    Client client5 = new Client(005, "Sam Moorehouse", "Dansoma", "+233553458272", "Moore@gmail.com", ClientLevel.PLATINUM);
    Client client6 = new Client(006, "Isaac Barsely", "London", "+233553454472", "james96@gmail.com", ClientLevel.PREMIUM);
    Client client7 = new Client(007, "Ibrahim Inusa", "Nsawam", "+2335534355456", "ibra@gmail.com", ClientLevel.GOLD);

    ClientRegister register = new ClientRegister(Arrays.asList(client1,client2,client3,client4,client5,client6,client7));

// Test for getting client by level
    @Test
    public void getClientsByLevel_Gold_Empty(){
        assertNotEquals(Arrays.asList(), register.getClientsLevel(ClientLevel.GOLD));
    }

    @Test
    public void getClientByLevel_Gold_NotAllGoldClients(){
        assertNotEquals(Arrays.asList(client1), register.getClientsLevel(ClientLevel.GOLD));
    }
    @Test
    public void getClientByLevel_Gold_AllGoldClients(){
        assertEquals(Arrays.asList(client1,client4,client7),register.getClientsLevel(ClientLevel.GOLD));
    }
    @Test
    public void getClientByLevel_Gold_NotGoldClients(){
        assertNotEquals(Arrays.asList(client2,client3,client6),register.getClientsLevel(ClientLevel.GOLD));
    }

    @Test
    public void getClientByLevel_Premium_Empty() {
        assertNotEquals(Arrays.asList(), register.getClientsLevel(ClientLevel.PREMIUM));
    }
    @Test
    public void getClientByLevel_Premium_NotAllPremiumClients() {
        assertNotEquals(Arrays.asList(client6), register.getClientsLevel(ClientLevel.PREMIUM));
    }
    @Test
    public void getClientByLevel_Premium_AllPremiumClients() {
        assertEquals(Arrays.asList(client3, client6), register.getClientsLevel(ClientLevel.PREMIUM));
    }
    @Test
    public void getClientByLevel_Premium_NotPremiumClients() {
        assertNotEquals(Arrays.asList(client1, client2,client7), register.getClientsLevel(ClientLevel.PREMIUM));
    }
    @Test
    public void geClientByLevel_Platinum_Empty(){
        assertNotEquals(Arrays.asList(), register.getClientsLevel(ClientLevel.PLATINUM));
    }
    @Test
    public void geClientByLevel_Platinum_NotAllPlatinumClients(){
        assertNotEquals(Arrays.asList(client2), register.getClientsLevel(ClientLevel.PLATINUM));
    }
    @Test
    public void geClientByLevel_Platinum_AllPlatinumClients(){
        assertEquals(Arrays.asList(client2,client5), register.getClientsLevel(ClientLevel.PLATINUM));
    }
    @Test
    public void geClientByLevel_Platinum_NotPlatinumClients(){
        assertNotEquals(Arrays.asList(client1,client3,client4), register.getClientsLevel(ClientLevel.PLATINUM));
    }

    // Test for searching client by ID
    @Test
    public void testGetClientById_IdEqualsClientsId(){
        assertEquals(Arrays.asList(client4), register.getClientsById(004));
    }
    @Test
    public void testGetClientById_IdNotEqualsClientsId(){
        assertNotEquals(Arrays.asList(client4), register.getClientsById(001));
    }

    // Test for searching clients by name
    @Test
    public void testGetClientByName_NameEqualClientsName(){
        assertEquals(Arrays.asList(client1), register.getClientsByName("Isaac Agyen"));
    }
    @Test
    public void testGetClientByName_AllinLowerCase(){
        assertEquals(Arrays.asList(client1), register.getClientsByName(("isaac agyen")));
    }
    @Test
    public void testGetClientByName_AllinUpperCase(){
        assertEquals(Arrays.asList(client1), register.getClientsByName(("ISAAC AGYEN")));
    }
    @Test
    public void testGetClientByName_UpperAndLowerMixed(){
        assertEquals(Arrays.asList(client1), register.getClientsByName("IsAac AgYen"));
    }
    @Test
    public void testGetClientByName_OnlyFirstName(){
        assertNotEquals(Arrays.asList(client1), register.getClientsByName("Isaac"));
    }
    @Test
    public void testGetClientByName_DifferentClientWithSameFirstName(){
        assertEquals(Arrays.asList(client1,client6), register.getClientsByName("Isaac"));
    }
    @Test
    public void testGetClientname_NameDoesNotEqualsClientsName(){
        assertNotEquals(Arrays.asList(client6), register.getClientsByName("Yaa"));
    }

}