package domain.Roads;

import domain.Settlements.SettlementLocation;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

public class RoadTests {
    
    @Test
    public void Test_getOwner_ofAnUnownedRoad_expect0(){
        int expected  = 0;
        Road road = new Road();
        int actual = road.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void Test_getOwner_ofRoadOwnedbyP1_expect1(){
        int expected = 1;
        Road road = new Road();
        road.setOwner(expected);
        int actual = road.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void Test_getOwner_ofRoadOwnedbyP2_expect2(){
        int expected = 2;
        Road road = new Road();
        road.setOwner(expected);
        int actual = road.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void Test_getOwner_ofRoadOwnedbyP3_expect3(){
        int expected = 3;
        Road road = new Road();
        road.setOwner(expected);
        int actual = road.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void Test_setOwner_ofRoadToUnowned_expectTrue(){
        int expectedVal = 0;
        Road road = new Road();
        boolean actualReturn = road.setOwner(0);
        int actualVal = road.getOwner();
        Assertions.assertTrue(actualReturn);
        Assertions.assertEquals(expectedVal,actualVal);
    }

    @Test
    public void Test_setOwner_ofRoadToPlayer1_expectTrue(){
        int expectedVal = 1;
        Road road = new Road();
        boolean actualReturn = road.setOwner(1);
        int actualVal = road.getOwner();
        Assertions.assertTrue(actualReturn);
        Assertions.assertEquals(expectedVal,actualVal);
    }

    @Test
    public void Test_setOwner_ofRoadToPlayer2_expectTrue(){
        int expectedVal = 2;
        Road road = new Road();
        boolean actualReturn = road.setOwner(2);
        int actualVal = road.getOwner();
        Assertions.assertTrue(actualReturn);
        Assertions.assertEquals(expectedVal,actualVal);
    }

    @Test
    public void Test_setOwner_ofRoadToPlayer3_expectTrue(){
        int expectedVal = 3;
        Road road = new Road();
        boolean actualReturn = road.setOwner(3);
        int actualVal = road.getOwner();
        Assertions.assertTrue(actualReturn);
        Assertions.assertEquals(expectedVal,actualVal);
    }

    @Test
    public void Test_setOwner_ofAnAlreadyOwnedRoad_throwsException(){
        Road road = new Road();
        road.setOwner(1);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            road.setOwner(2);}, "This road is already owned");
    }

    @Test
    public void Test_setOwner_ofAnIllegalPlayerNum_throwsException(){
        Road road = new Road();
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            road.setOwner(5);}, "Player IDs can only be 0,1,2,3");
    }

    @Test
    public void Test_setOwner_forPlayer4_expectOwner4() {
        int expectedVal = 4;
        Road road = new Road();
        boolean actualReturn = road.setOwner(4);
        int actualVal = road.getOwner();
        Assertions.assertTrue(actualReturn);
        Assertions.assertEquals(expectedVal,actualVal);
    }


    @Test
    public void Test_setOwner_ofAnIllegalPlayerNegNum_throwsException(){
        Road road = new Road();
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            road.setOwner(-1);}, "Player IDs can only be 0,1,2,3");
    }


    @Test
    public void Test_getSettlement_ofDefaultRoad_returnsTwoUnowned(){
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        EasyMock.expect(s1.getOwner()).andReturn(0);
        EasyMock.expect(s2.getOwner()).andReturn(0);
        Road road = new Road(s1,s2);
        EasyMock.replay(s1,s2);
        List<SettlementLocation> actual = road.getSettlements();
        Assertions.assertEquals(0,actual.get(0).getOwner());
        Assertions.assertEquals(0,actual.get(1).getOwner());
        Assertions.assertEquals(2,actual.size());
        EasyMock.verify(s1,s2);
    }

    @Test
    public void Test_getSettlement_ofRoadWithADefaultSettlement_returnsOneUnownedAndTheOwnedRoad(){
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        EasyMock.expect(s1.getOwner()).andReturn(0);
        EasyMock.expect(s2.getOwner()).andReturn(1);
        Road road = new Road(s1,s2);
        EasyMock.replay(s1,s2);
        List<SettlementLocation> actual = road.getSettlements();
        Assertions.assertEquals(0,actual.get(0).getOwner());
        Assertions.assertEquals(1,actual.get(1).getOwner());
        Assertions.assertEquals(2,actual.size());
        EasyMock.verify(s1,s2);
    }

    @Test
    public void Test_getSettlement_ofRoadWithAOwnedCity_returnsOneUnownedAndTheCityOwnedRoad(){
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        EasyMock.expect(s1.getOwner()).andReturn(2);
        EasyMock.expect(s2.getOwner()).andReturn(0);
        Road road = new Road(s1,s2);
        EasyMock.replay(s1,s2);
        List<SettlementLocation> actual = road.getSettlements();
        Assertions.assertEquals(2,actual.size());
        Assertions.assertEquals(2,actual.get(0).getOwner());
        Assertions.assertEquals(0,actual.get(1).getOwner());
        EasyMock.verify(s1,s2);
    }

    @Test
    public void Test_addSettlement_ofRoadWithNoSettlementLocations_returnsTrue(){
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        EasyMock.expect(s1.getOwner()).andReturn(2);
        Road road = new Road();
        EasyMock.replay(s1);
        Assertions.assertTrue(road.addSettlement(s1));
        List<SettlementLocation> settlements = road.getSettlements();
        Assertions.assertEquals(2, settlements.get(0).getOwner());
        Assertions.assertEquals(1,settlements.size());
        EasyMock.verify(s1);
    }

    @Test
    public void Test_addSettlement_ofRoadWithOneSettlementLocation_returnsTrue(){
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        EasyMock.expect(s2.getOwner()).andReturn(1);
        Road road = new Road();
        road.addSettlement(s1);
        EasyMock.replay(s1, s2);
        Assertions.assertTrue(road.addSettlement(s2));
        List<SettlementLocation> settlements = road.getSettlements();
        Assertions.assertEquals(1, settlements.get(1).getOwner());
        Assertions.assertEquals(2,settlements.size());
        EasyMock.verify(s1, s2);
    }

    @Test
    public void Test_addSettlement_ofRoadWithTwoUnownedSettlementLocation_returnsFalse(){
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        EasyMock.expect(s1.getOwner()).andReturn(0);
        EasyMock.expect(s2.getOwner()).andReturn(0);
        Road road = new Road();
        road.addSettlement(s1);
        road.addSettlement(s2);
        EasyMock.replay(s1, s2, s3);
        Assertions.assertFalse(road.addSettlement(s2));
        List<SettlementLocation> settlements = road.getSettlements();
        Assertions.assertEquals(0, settlements.get(0).getOwner());
        Assertions.assertEquals(0, settlements.get(1).getOwner());
        Assertions.assertEquals(2,settlements.size());
        EasyMock.verify(s1, s2, s3);
    }


}
