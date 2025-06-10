package exercise;

import exercise.model.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public List<Post> getPosts(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer limit) {
        return posts.stream()
                .skip((long) (page - 1) * limit)
                .limit(limit)
                .toList();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPost(@PathVariable("id") String id) {
        return posts.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable("id") String id, @RequestBody Post post) {
        posts.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .ifPresent(p -> {
                    p.setId(post.getId());
                    p.setTitle(post.getTitle());
                    p.setBody(post.getBody());
                });
        return post;
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") String id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
    // END
}
