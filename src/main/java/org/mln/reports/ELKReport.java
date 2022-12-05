package org.mln.reports;

import lombok.Getter;
import lombok.Setter;
import org.mln.enums.Categories;


public final class ELKReport {

    @Setter
    @Getter
    private String testName;

    @Setter
    @Getter
    private String teststatus;

    @Setter
    @Getter
    private  Categories[] testCategory;

    @Setter
    @Getter
    private String[] testAuthor;

    @Setter
    @Getter
    private long testExecutionTime;


}
