package com.hit.baiktraweb.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Timespan;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nationalized
    private String name;

    @Timestamp Timespan created;
    @Timestamp Timespan updated;
    @ManyToOne
    @JoinColumn(name = "darling_id")
    private Darling darling;
}
