package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @RequestMapping("/book")
    public Book getBook() {
        return new Book("Domain Driven Design", "Eric Evans");
    }
}
