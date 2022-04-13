package com.example.ontapkienthuc;

public class Todo {

  private String title;
  private String deteil;

    public Todo(String title, String deteil) {
        this.title = title;
        this.deteil = deteil;
    }

    public Todo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeteil() {
        return deteil;
    }

    public void setDeteil(String deteil) {
        this.deteil = deteil;
    }
}
