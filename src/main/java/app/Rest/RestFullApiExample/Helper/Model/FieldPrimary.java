package app.Rest.RestFullApiExample.Helper.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldPrimary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}