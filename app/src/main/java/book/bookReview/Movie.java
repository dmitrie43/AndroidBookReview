package book.bookReview;

//Класс для записи и вывода данных
class Movie {
    private String name, description, author, image, url;
    private int date;

    Movie(String name, String description, String author, String image, String url, int date) {
        super();
        this.name = name;
        this.description = description;
        this.author = author;
        this.image = image;
        this.url = url;
        this.date = date;
    }

    String getName() {
        return this.name;
    }

    String getDescription() {
        return this.description;
    }

    String getAuthor() {
        return this.author;
    }

    String getImage() {
        return this.image;
    }

    String getUrl() {
        return this.url;
    }

    int getDate() { return this.date; }

}
