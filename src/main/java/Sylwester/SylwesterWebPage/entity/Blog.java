package Sylwester.SylwesterWebPage.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Blog {
    // nazwy zmiennych i tak dalej zostały zmienione dla testu bo cała mechanika wpisywania do bazy danych działa prawidłowo i trzeba sprawdzić czy będę również działała z użytkownikami
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "topic is mandatory")
    @Column(name = "topic")
    private String topic;

    @NotBlank(message = "message is mandatory")
    @Column(name = "message")
    private String message;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return id == blog.id &&
                Objects.equals(name, blog.name) &&
                Objects.equals(topic, blog.topic) &&
                Objects.equals(message, blog.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, topic, message);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}