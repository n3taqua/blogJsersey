package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topic implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "nvarchar(45)")
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "categoriesID")
    private Categories categories;
}
