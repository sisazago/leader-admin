package com.co.leader.admin.application.question.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {

    @NotNull
    private String question;

    @Pattern(regexp = "X|Y", message = "Values must be either 'X' or 'Y'")
    private String axis;
}
