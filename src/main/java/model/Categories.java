package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categories implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "nvarchar(45)")
    private String title;
    @OneToMany(mappedBy = "categories")
    private List<Topic> topicList;

}
