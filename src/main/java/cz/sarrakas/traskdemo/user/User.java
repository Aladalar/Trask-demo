package cz.sarrakas.traskdemo.user;

import cz.sarrakas.traskdemo.knowledge.Knowledge;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
       strategy = GenerationType.SEQUENCE,
       generator = "user_sequence"
    )
    private long id;
    private String name;

    private String email;

    @OneToMany(mappedBy = "user")
    private List<Knowledge> knowledgeList;

    public List<Knowledge> getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowledgeList(List<Knowledge> knowledgeList) {
        this.knowledgeList = knowledgeList;
    }

    public User() {
    }

    public User(long id, String name, List<Knowledge> knowledgeList) {
        this.id = id;
        this.name = name;
        this.knowledgeList = knowledgeList;

    }

    public User(String name, List<Knowledge> knowledgeList) {
        this.name = name;
        this.knowledgeList = knowledgeList;
    }

    public User(long id, String name, String email, List<Knowledge> knowledgeList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.knowledgeList = knowledgeList;
    }

    public User(String name) {
        this.name = name;
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

    public List<Knowledge> getKnowledgeList(List<Knowledge> knowledgeList) {
        return this.knowledgeList;
    }

    public void setKnowledgeListList(List<Knowledge> knowledgeList) {
        this.knowledgeList = knowledgeList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "<p>User{" +
                "<br>>id=" + id +
                ",<br>name='" + name + '\'' +
                ",<br>>techList=" + knowledgeList +
                "}</p>";
    }

}
