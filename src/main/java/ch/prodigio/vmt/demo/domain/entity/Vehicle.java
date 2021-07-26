package ch.prodigio.vmt.demo.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Gloria R. Leyva Jerez
 */
@Accessors(chain = true)
@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "vehicles_id_seq")
	@Column(name = "id")
	private Long id;

	@Column(name = "county_fips", nullable = false)
	private int countyFips;

	@Column(name = "county_name", nullable = false)
	private String countyName;

	@Column(name = "state_name", nullable = false)
	private String stateName;

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@Column(name = "county_vmt")
	private Double countyVmt;

	@Column(name = "baseline_jan_vmt")
	private Double baselineVmt;

	@Column(name = "percent_change_from_jan")
	private Double percentChange;

	@Column(name = "mean7_county_vmt")
	private Double meanCountyVmt;

	@Column(name = "mean7_percent_change_from_jan")
	private Double meanPercentChange;

	@Column(name = "date_at_low", nullable = false)
	private LocalDate dateAtLow;

	@Column(name = "mean7_county_vmt_at_low")
	private Double meanCountyVmtAtLow;

	@Column(name = "percent_change_from_low")
	private Double percentChangeFromLow;
}
