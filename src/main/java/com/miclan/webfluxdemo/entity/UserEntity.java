package com.miclan.webfluxdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity implements Persistable<String> {
    @Id
    private String id;

    private String name;

    private String phone;

    @Transient
    @JsonIgnore
    @Builder.Default
    private boolean newEntry = true;

    @Override
    public boolean isNew() {
        return newEntry;
    }
}
