package uvt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import uvt.models.AllBooksSubject;
import uvt.services.SseObserver;

@RestController
public class BookSseController {
    private final AllBooksSubject allBooksSubject;
    public BookSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @RequestMapping("/books-sse")
    public ResponseBodyEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter();
        allBooksSubject.attach(new SseObserver(emitter));
        return emitter;
    }

}
