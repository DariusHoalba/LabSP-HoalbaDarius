package uvt.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Section.class, name = "section"),
})
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseElement implements Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
}