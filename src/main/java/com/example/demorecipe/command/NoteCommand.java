package com.example.demorecipe.command;

import lombok.Data;

@Data
public class NoteCommand {
    private Long id;
    private String text;
//    private RecipeCommand recipe;
}
