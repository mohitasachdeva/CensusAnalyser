
    import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

    public class IndianCensusTest {

        private static final String CSV_FILE_PATH = "F:\\practice3\\CensusAnalyser\\src\\main\\resources\\IndianCensusData.csv";
        private static final String CSV_WRONG_FILE_PATH = "C:\\practice3\\CensusAnalyser\\src\\main\\resources\\IndianCensusData.csv";
        private static final String CSV_WRONG_FILE_EXTENSION = "F:\\practice3\\CensusAnalyser\\src\\main\\resources\\IndianCensusData.txt";
        private static final String CSV_WRONG_FILE_HEADER = "F:\\practice3\\CensusAnalyser\\src\\main\\resources\\IndianStateCensus.csv";

        @Test
        void givenFileToMatchTheNoOfRecords() throws IOException, CsvException, StateCensusAnalyserException {
            int actual =  StateCensusAnalyser.readFile(CSV_FILE_PATH);
            Assertions.assertEquals(29,actual);
        }

        @Test
        void givenWrongFileNameShouldThrowCustomException(){
            StateCensusAnalyserException exception =  Assertions.assertThrows(StateCensusAnalyserException.class,() -> StateCensusAnalyser.readFile(CSV_WRONG_FILE_PATH));
            Assertions.assertEquals("File does not exist",exception.getMessage());
        }

        @Test
        void givenWrongFileTypeShouldThrowCustomException(){
            Assertions.assertThrows(StateCensusAnalyserException.class,() -> StateCensusAnalyser.readFile(CSV_WRONG_FILE_EXTENSION));
        }

        @Test
        void givenFileToMatchTheNoOfRec()  {
            Assertions.assertThrows(StateCensusAnalyserException.class,() -> StateCensusAnalyser.readFile(CSV_WRONG_FILE_HEADER));
        }
}
