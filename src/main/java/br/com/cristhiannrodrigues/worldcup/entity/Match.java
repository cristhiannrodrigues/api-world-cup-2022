package br.com.cristhiannrodrigues.worldcup.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "match")
public class Match implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private boolean finished;

    @NonNull
    private String local_date;

    @NonNull
    private Integer matchday;

    @NonNull
    private String home_team_en;

    @NonNull
    private String away_team_en;

    @NonNull
    private String home_flag;

    @NonNull
    private String away_flag;

}
