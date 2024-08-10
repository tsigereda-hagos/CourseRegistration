package edu.miu.cs.cs425.courseregistration.domain;
import edu.miu.cs.cs425.courseregistration.Utils.Utils;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

import java.util.List;

public class Block {


    @Column
    private Integer month;

    @Column
    private Integer year;



    @Transient
    public String getName() {
        return Utils.getMonth(month) + " " + year;
    }

    @OneToMany(mappedBy = "block")
    private List<Lesson> lessons;
}
