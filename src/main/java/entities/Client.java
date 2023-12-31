package entities;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
public class Client {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private String email;
    private LocalDate birthDate;

    public Client(){}

    public Client(String name, String email, LocalDate birthDate) {
        super();
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name
                + " (" + sdf.format(birthDate)
                + ") - "
                + email ;
    }
}
