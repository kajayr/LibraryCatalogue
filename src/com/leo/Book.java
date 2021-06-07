package com.leo;

public class Book {
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut;
    int dayCheckedOut = -1;

    public Book(String title, int pageCount, int ISBN) {
        this.title = title;
        this.pageCount = pageCount;
        this.ISBN = ISBN;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getISBN() {
        return ISBN;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public int getDayCheckedOut() {
        return dayCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut, int currentDayCheckedOut) {
        isCheckedOut = checkedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }
    private void setDayCheckedOut(int day){
        this.dayCheckedOut = day;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", ISBN=" + ISBN +
                ", isCheckedOut=" + isCheckedOut +
                ", dayCheckedOut=" + dayCheckedOut +
                '}';
    }
}
