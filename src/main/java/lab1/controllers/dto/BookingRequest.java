package lab1.controllers.dto;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true) @Getter
@ToString
public class BookingRequest {

  @JsonProperty("event") String eventName;
  @JsonProperty("auditorium") String auditoriumName;

  @JsonProperty("date_time")
  @DateTimeFormat(iso = DATE_TIME)
  LocalDateTime eventDateTime;

  @JsonProperty List<Integer> seats;
  @JsonProperty("user_email") String userMail;
}