package maven.consumer.influxdb.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import org.influxdb.InfluxDB;

import maven.consumer.influxdb.api.InfluxAPI;

public class InfluxService {
	
	private final InfluxAPI influxAPI;
	
	public InfluxService() {
		influxAPI = new InfluxAPI();
	}
	
	/**
	 * To transmit the target database a single metric
	 * @param influxDB		InfluxDB instance with a database configured
	 * @param metric		The name of the target sampling time metric
	 * @param host			The host(tag) of the metric
	 * @param value			Value that should be sent
	 */
	public void writeSingleMetricToInfluxDB(InfluxDB influxDB, String metric, String host, String value) {
		influxAPI.writeMetricDataUnderHost(influxDB, metric, host, value);
	}

}
