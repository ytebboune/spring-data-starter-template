package com.commonstarter.model.common;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @Author : Xavier PHILIPPONNEAU
 *
 * How to use it ?
 *
 * declare a class extending it and override "id" attribute, so you don't need to redeclare an @Id field
 *
 * snippet :
 *
 * @Entity
 * @Table(name = "my_concrete_entity")
 * @AttributeOverride(name = "id", column = @Column(name = "my_entity_id") // will override @Id column name in DB
 *
 * public class ConcreteEntity extends BaseEntity{
 *
 *     // getters/setters/constructor if not done with lombok
 *
 *      @Column(name = "firstname")
 *      private String firstname;
 *
 * }
 *
 */

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

}
