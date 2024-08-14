package edu.wgu.d387_sample_code.i18n;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.time.*;
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = "http://localhost:4200")
public class TimeZoneConverter {

    public static String getZoneTime() {
        ZonedDateTime time = ZonedDateTime.now();

        ZonedDateTime est = time.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime mst = time.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime utc = time.withZoneSameInstant(ZoneId.of("UTC"));

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        String times = est.format(timeFormat) + "EST, " + mst.format(timeFormat) + "MST, " + utc.format(timeFormat) + "UTC";

        return times;
    }
}
