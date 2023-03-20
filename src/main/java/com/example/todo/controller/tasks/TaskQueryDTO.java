package com.example.todo.controller.tasks;

import java.util.List;

public record TaskQueryDTO(
        String summary,
        List<String> statusList
) {
    public boolean isChecked(String status) {
        return statusList.contains(status);
    }
}
