package Models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String val;

    //Lien ket toi user
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") //tạo khóa ngại
    @JsonBackReference//khi liên kết bảng thì ta sẽ có thuộc tính này để tạo liên kết bảng JsonBackReference
    private User user;

}