package live.evsianna.stylist.model.projection;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author Rustam Mamedov
 */

public interface UserProjection {

    String getId();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPhone();

    int getAge();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    LocalDateTime getCreated();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    LocalDateTime getUpdated();

}
