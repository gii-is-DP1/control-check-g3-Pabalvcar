package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recoveryroom")
public class RecoveryRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	
	@NotNull
	@Length(min = 3, max = 50)
    String name;
    
	@NotNull
	@Min(0)
    double size;
    
	@NotNull
    boolean secure;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id")
    RecoveryRoomType roomType;
}
