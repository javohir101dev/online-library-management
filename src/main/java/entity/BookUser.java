package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUser {

    private Integer id;
    private Date takenDate =  new Date(System.currentTimeMillis());
    private Date returnedDate;
    private Integer bookId;
    private Integer takenNumberOfBooks;
    private Integer userId;
    private boolean isReturned = false;

    public BookUser(Date takenDate, Date returnedDate, Integer bookId, Integer takenNumberOfBooks, Integer userId, boolean isReturned) {
        this.takenDate = takenDate;
        this.returnedDate = returnedDate;
        this.bookId = bookId;
        this.takenNumberOfBooks = takenNumberOfBooks;
        this.userId = userId;
        this.isReturned = isReturned;
    }
}
