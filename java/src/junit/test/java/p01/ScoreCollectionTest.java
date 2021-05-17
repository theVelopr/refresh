//package java.p01;
//
//import junit.main.java.p01.ScoreCollection;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ScoreCollectionTest {
//
//    @Test
//    public void arithmeticMeanOfFiveAndSevenResultsInSix() {
//        ScoreCollection collection = new ScoreCollection();
//        collection.add(() -> 5);
//        collection.add(() -> 7);
//        int actualResult = collection.arithmeticMean();
//        assertEquals(6, actualResult);
//    }
//
//    @Test
//    public void arithmeticMeanOfTenAndTwentyResultsInFifteen() {
//        ScoreCollection collection = new ScoreCollection();
//        collection.add(() -> 10);
//        collection.add(() -> 20);
//        int actualResult = collection.arithmeticMean();
//        assertEquals(14, actualResult);
//    }
//
//}