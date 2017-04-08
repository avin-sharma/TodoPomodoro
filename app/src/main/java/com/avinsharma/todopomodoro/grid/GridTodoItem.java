package com.avinsharma.todopomodoro.grid;

/**
 * Created by Avin on 07-04-2017.
 */

public class GridTodoItem {
    private String title;
    private int itemCount;
    private int pomodoroCount;

    public GridTodoItem(String title, int items, int pomodoroCount) {
        this.title = title;
        this.itemCount = items;
        this.pomodoroCount = pomodoroCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getPomodoroCount() {
        return pomodoroCount;
    }

    public void setPomodoroCount(int pomodoroCount) {
        this.pomodoroCount = pomodoroCount;
    }
}
