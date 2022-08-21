import com.bridgelap.censusanalyser.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


    public class StateCensusAnalyser {
        static int readFile(String path) throws IOException, StateCensusAnalyserException, CsvException {
            File file = new File(path);
            if (!file.exists()) {
                throw new StateCensusAnalyserException("File does not exist");
            }

            int index = path.lastIndexOf(".");
            String extension = path.substring(index+1);
            if(!extension.equals("csv"))
                throw new StateCensusAnalyserException("File type does not match");

            FileReader reader = new FileReader(file);
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> records = csvReader.readAll();
            String[] record = records.get(0);

            if(!(record[0].equals("State") || record[1].equals("Population") || record[2].equals("AreaInSqKm") || record[3].equals("DensityPerSqKm")))
                throw new StateCensusAnalyserException("Header in the file is wrong");
            records.remove(0);
            return records.size();
        }
}
