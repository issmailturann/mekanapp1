package com.mekanapp.mekanuserms.userprofile;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class UserBaseEntity {

    @Id
    @GeneratedValue
    private UUID id;
    @CreatedDate
    @Column(name = "user_created_date")
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(name = "user_updated_date")
    private LocalDateTime updatedDate;

}
