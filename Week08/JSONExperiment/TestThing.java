package Week08.JSONExperiment;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.JSONExperiment                          *
 *************************************************************************/

public class TestThing {

    public String wobble;
    public String module;

    public int[] numbers;

    @JsonIgnore
    public String ignorethis;

}

                                                                           
