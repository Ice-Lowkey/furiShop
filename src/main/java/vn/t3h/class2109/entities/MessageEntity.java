package vn.t3h.class2109.entities;


import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "message", schema = "sanphamnoithat", catalog = "")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstname", nullable = true, length = 100)
    private String firstname;

    @Column(name = "lastname", nullable = true, length = 100)
    private String lastname;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "mess", nullable = false, length = 2000)
    private String mess;

    @Column(name = "time", nullable = false)
    private Time time;

}
