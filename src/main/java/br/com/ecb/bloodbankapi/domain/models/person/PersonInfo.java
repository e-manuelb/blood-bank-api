package br.com.ecb.bloodbankapi.domain.models.person;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "person_infos")
public class PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", nullable = false, unique = true)
    public String cpf;

    @Column(name = "rg", nullable = false)
    public String rg;

    @Column(name = "gender", nullable = false)
    public String gender;

    @Column(name = "mother_name", nullable = false)
    public String motherName;

    @Column(name = "father_name", nullable = false)
    public String fatherName;

    @Column(name = "height", nullable = false)
    public Double height;

    @Column(name = "weight", nullable = false)
    public Double weight;

    @Column(name = "blood_type", nullable = false)
    private String bloodType;

    @JsonBackReference
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
