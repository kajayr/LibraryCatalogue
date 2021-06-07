package com.leo;

        import java.util.HashMap;
        import java.util.Map;

public class LibraryCatalogue {
    Map<String, Book> bookCollection = new HashMap<>();
    int currentDay = 0;
    int lengthOfCheckoutPeriod = 7;
    double initialLateFee = 0.50;
    double feePerLateDay = 1.00;

    public LibraryCatalogue(Map<String, Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    public LibraryCatalogue(Map<String, Book> bookCollection, int currentDay, int lengthOfCheckoutPeriod, double initialLateFee, double feePerLateDay) {
        this.bookCollection = bookCollection;
        this.currentDay = currentDay;
        this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;
    }

    public Map<String, Book> getBookCollection() {
        return bookCollection;
    }
    public Book getBook(String bookTitle){
        return getBookCollection().get(bookTitle);
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public int getLengthOfCheckoutPeriod() {
        return lengthOfCheckoutPeriod;
    }

    public double getInitialLateFee() {
        return initialLateFee;
    }

    public double getFeePerLateDay() {
        return feePerLateDay;
    }

    public void nextDay(){
        currentDay++;
    }
    public void setDay(int day){
        currentDay = day;
    }
    public void checkoutBook(String title){
    Book book = getBook(title);
    if(book.isCheckedOut()){
        sorryBookAlreadyCheckedOut(book);
    }else{
        book.setCheckedOut(true, currentDay);
        System.out.println("You just checked out " + title + ". It is due on day " + (getCurrentDay() + getLengthOfCheckoutPeriod()) + ".");
    }
    }
    public void returnBook(String title){
        Book book = getBook(title);
        int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckoutPeriod());
        if(daysLate > 0){
            System.out.println("You owe the library $" + (getInitialLateFee() + daysLate * getFeePerLateDay()) + " because your book is " + daysLate + " days overdue." );
        }else{
            System.out.println("Book returned. Thank you");
        }
      book.setCheckedOut(false, -1);
    }
    public void sorryBookAlreadyCheckedOut(Book book){
        System.out.println("Sorry, the book " + book.getTitle() + " is already checked out. It will be returned in " + (book.getDayCheckedOut() + getLengthOfCheckoutPeriod()) + ".");
    }

    public static void main(String[] args) {
     Map<String, Book> bookCollection = new HashMap<>();
     Book goodLife = new Book("Good Life", 340, 83827273);
     bookCollection.put(goodLife.title, goodLife);
     LibraryCatalogue lib = new LibraryCatalogue(bookCollection);
     lib.checkoutBook("Good Life");
     lib.nextDay();
     lib.nextDay();
     lib.checkoutBook("Good Life");
     lib.setDay(14);
     lib.returnBook("Good Life");
     lib.checkoutBook("Good Life");
    }
}
