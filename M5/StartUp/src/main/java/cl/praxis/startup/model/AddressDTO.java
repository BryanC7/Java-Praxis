package cl.praxis.startup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddressDTO {
    private int addressId;
    private String addressName;
    private String numbering;
    private int userId;

    public AddressDTO(String addressName, String numbering, int userId) {
        this.addressName = addressName;
        this.numbering = numbering;
        this.userId = userId;
    }
}