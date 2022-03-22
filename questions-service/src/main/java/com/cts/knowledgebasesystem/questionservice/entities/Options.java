package com.cts.knowledgebasesystem.questionservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("optionFilter")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pId;

    @NotBlank(message = "choice is required field")
    String choice;

    @JoinColumn(name="q_id", insertable = false, updatable = false)
    @ManyToOne
    private Questions questions;
}
