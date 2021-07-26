package ch.prodigio.vmt.demo.application.controller.vehicle.imports;

import ch.prodigio.vmt.demo.application.contract.Mapper;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleImportMapper implements Mapper<byte[], List<Vehicle>> {

	@Override
	public List<Vehicle> map(byte[] files) {
		List<Vehicle> vehicleList = new ArrayList<>();
		ByteArrayInputStream inputFilestream = new ByteArrayInputStream(files);
		BufferedReader br = new BufferedReader(new InputStreamReader(inputFilestream));

		BufferedReader fileReader = null;
		CSVParser csvParser = null;

		try {
			fileReader = new BufferedReader(new InputStreamReader(inputFilestream, "UTF-8"));
			csvParser = new CSVParser(
				fileReader,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
			);

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for(CSVRecord csvRecord : csvRecords) {
				Vehicle vehicle = new Vehicle();
				vehicle.setCountyFips(Integer.parseInt(csvRecord.get("county_fips")));
				vehicle.setCountyName(csvRecord.get("county_name"));
				vehicle.setStateName(csvRecord.get("state_name"));
				vehicle.setDate(LocalDate.parse(csvRecord.get("date")));
				vehicle.setCountyVmt(Double.parseDouble(csvRecord.get("county_vmt")));
				vehicle.setBaselineVmt(Double.parseDouble(csvRecord.get("baseline_jan_vmt")));
				vehicle.setPercentChange(Double.parseDouble(csvRecord.get("percent_change_from_jan")));
				vehicle.setMeanCountyVmt(Double.parseDouble(csvRecord.get("mean7_county_vmt")));
				vehicle.setMeanPercentChange(Double.parseDouble(csvRecord.get("mean7_percent_change_from_jan")));
				vehicle.setDateAtLow(LocalDate.parse(csvRecord.get("date_at_low")));
				vehicle.setMeanCountyVmtAtLow(Double.parseDouble(csvRecord.get("mean7_county_vmt_at_low")));
				vehicle.setPercentChangeFromLow(Double.parseDouble(csvRecord.get("percent_change_from_low")));
				vehicleList.add(vehicle);
			}
		} catch(Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvParser.close();
			} catch(IOException e) {
				System.out.println("Closing fileReader/csvParser Error!");
				e.printStackTrace();
			}
		}
		return vehicleList;
	}
}
