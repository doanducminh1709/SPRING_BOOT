package com.example.cacloaiquanhe.QUANHEN_N;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // mappedBy trỏ tới tên biến persons ở trong Address.
    @ManyToMany(mappedBy = "persons")
    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
    @EqualsAndHashCode.Exclude
    private Collection<Address> addresses;
}
