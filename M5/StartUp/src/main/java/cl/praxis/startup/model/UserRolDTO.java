package cl.praxis.startup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRolDTO {
    private int idUserRol;
    private int userId;
    private int rolId;

    public UserRolDTO(int userId, int rolId) {
        this.userId = userId;
        this.rolId = rolId;
    }
}
