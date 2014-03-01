package components.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import au.com.bytecode.opencsv.CSVReader;

public class CsvUtil {

  private static final char CSV_SEPARATOR = ',';

  private static final char CSV_QUOTECHAR = '"';

  public static CSVReader parsedLine(FileInputStream input, char csvSeparator,
      char csvQuote) throws FileNotFoundException, UnsupportedEncodingException {
    CSVReader reader = null;

    InputStreamReader inReader = new InputStreamReader(input, "Windows-31J");
    reader = new CSVReader(inReader, csvSeparator, csvQuote, 1);
    return reader;
  }

  public static CSVReader readCsv(String filePath) throws FileNotFoundException, UnsupportedEncodingException {
    CSVReader reader = null;
    try {
      FileInputStream input = new FileInputStream(filePath);
      reader = parsedLine(input, CSV_SEPARATOR, CSV_QUOTECHAR);
    } catch (FileNotFoundException e) {
    	throw new FileNotFoundException(e.getMessage());
    } catch (UnsupportedEncodingException e) {
    	throw new UnsupportedEncodingException(e.getMessage());
    }
    return reader;
  }

  public static CSVReader readCsv(FileInputStream input)throws FileNotFoundException, UnsupportedEncodingException {
    CSVReader reader = null;
    try {
      reader = parsedLine(input, CSV_SEPARATOR, CSV_QUOTECHAR);
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException(e.getMessage());
    } catch (UnsupportedEncodingException e) {
        throw new UnsupportedEncodingException(e.getMessage());
    }
    return reader;
  }
}
