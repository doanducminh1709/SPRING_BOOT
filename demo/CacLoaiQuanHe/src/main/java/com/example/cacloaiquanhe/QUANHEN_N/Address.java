package com.example.cacloaiquanhe.QUANHEN_N;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String province;


//    When you use CascadeType.ALL, whenever you do any
//    operation on the parent all those operations would
//    also get cascaded to the child.

   // FetchType.LAZY is on demand (i.e. when we required the data).
  //==> Gọi theo yêu cầu , khi mà chúng ta yêu cầu dữ liệu
    //FetchType.EAGER is immediate (i.e. before our requirement
    //comes we are unnecessarily fetching the record)
    // ==> Gọi ngay lập tức
    //tức là trước khi yêu cầu của chúng tôi đến,
    //chúng tôi đang tìm nạp bản ghi một cách không cần thiết
   @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
   @ToString.Exclude // Khoonhg sử dụng trong toString()

   @JoinTable(name = "address_person", //Tạo ra một join Table tên là "address_person"
           joinColumns = @JoinColumn(name = "address_id"),  // TRong đó, khóa ngoại chính là address_id trỏ tới class hiện tại (Address)
           inverseJoinColumns = @JoinColumn(name = "person_id") //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Person)
   )

   // để kết nối hai bảng mình phải tạo 1 tên cho nó là tên của bảng gộp lại
   //kết nối sẽ thông qua id của 2 bảng address_id và person_id
   //tạo khóa ngoại trỏ đến bảng
   private Collection<Person> persons;
}
