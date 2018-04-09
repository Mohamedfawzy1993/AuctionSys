package model.entities;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime locDateTime) {

        return (locDateTime == null ? null : Date.from(locDateTime.toInstant(ZoneOffset.UTC)));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date sqlTimestamp) {
        return (sqlTimestamp == null ? null : LocalDateTime.ofInstant(Instant.ofEpochMilli(sqlTimestamp.getTime()), ZoneOffset.UTC));
    }
}