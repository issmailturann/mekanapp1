package com.mekanapp.userservice.userprofile;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user_details", schema = "util_sch")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProfile extends UserBaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "biography")
    private String biography;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "pleasures_and_hobbies")
    private String pleasures_and_hobbies;
    @Column(name = "preferred_places")
    private String preferred_places;

}
