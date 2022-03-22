package com.cts.knowledgebasesystem.questionservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questions implements Comparable<Questions>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qId;

    @NotBlank(message = "Question description is required")
    private String questionDesc;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="q_id", nullable = false)
    private List<Options> options;

    private Long techId;

    @Enumerated(EnumType.STRING)
    private SkillType skillType;

    @Override
    public int compareTo(Questions o) {
        return this.qId == null? 0 : this.qId.compareTo(o.qId);
    }
}
