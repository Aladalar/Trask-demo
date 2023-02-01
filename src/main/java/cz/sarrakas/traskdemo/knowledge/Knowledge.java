package cz.sarrakas.traskdemo.knowledge;

import cz.sarrakas.traskdemo.certification.Certification;
import cz.sarrakas.traskdemo.technology.Tech;
import cz.sarrakas.traskdemo.user.User;
import jakarta.persistence.*;

@Entity
@Table
public class Knowledge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "certification")
    private Certification certification;

    @ManyToOne
    @JoinColumn(name = "tech_id")
    private Tech tech;

    private int techLevel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Knowledge() {
    }

    public Knowledge(long id, Certification certification, Tech tech, int techLevel) {
        this.id = id;
        this.certification = certification;
        this.tech = tech;
        this.techLevel = techLevel;
    }

    public Knowledge(long id, Certification certification) {
        this.id = id;
        this.certification = certification;
    }

    public Knowledge(long id, Tech tech, int techLevel) {
        this.id = id;
        this.tech = tech;
        this.techLevel = techLevel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public Tech getTech() {
        return tech;
    }

    public void setTech(Tech tech) {
        this.tech = tech;
    }

    public int getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }
}
