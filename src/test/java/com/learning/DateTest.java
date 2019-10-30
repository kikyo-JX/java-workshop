package com.learning;

import org.junit.Test;

/**
 * User: Chen Liu
 * Date: 2019/10/8
 * Time: 10:20 pm
 */
public class DateTest {

    @Test
    public void a() {
        String str = "Dr David Oswald - http://www.cs.bham.ac.uk/~oswalddf/student-projects.phpLinks to an external site.\n" +
                "\n" +
                "Dr Hayo Thielecke - http://www.cs.bham.ac.uk/~hxt/student-projects.shtmlLinks to an external site.\n" +
                "\n" +
                "Prof Ela Claridge - http://www.cs.bham.ac.uk/~exc/student-miniprojects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Manfred Kerber - http://www.cs.bham.ac.uk/~mmk/student-projects.phpLinks to an external site. and http://www.cs.bham.ac.uk/~mmk/asc-projects.phpLinks to an external site.\n" +
                "\n" +
                "Dr Rami Bahsoon - http://www.cs.bham.ac.uk/~rzb/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Prof Russell Beale - http://www.cs.bham.ac.uk/~rxb/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr John A. Bullinaria - http://www.cs.bham.ac.uk/~jxb/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Tom Chothia - http://www.cs.bham.ac.uk/~tpc/projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Hamid Dehghani - http://www.cs.bham.ac.uk/~dehghanh/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Martín Escardó - http://www.cs.bham.ac.uk/~mhe/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Dan Ghica - https://www.cs.bham.ac.uk/~drg/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Peter Hancox - http://www.cs.bham.ac.uk/~pjh/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Shan He - http://www.cs.bham.ac.uk/~szh/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Bob Hendley - http://www.cs.bham.ac.uk/~rjh/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Prof Andrew Howes -  http://www.cs.bham.ac.uk/~howesa/student-projects.html\n" +
                "\n" +
                "Prof Achim Jung - http://www.cs.bham.ac.uk/~axj/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Ata Kaban - http://www.cs.bham.ac.uk/~axk/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Joshua Knowles - http://www.cs.bham.ac.uk/internal/courses/projects/2015/files/joshua.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Paul B Levy - http://www.cs.bham.ac.uk/~pbl/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr David Parker - http://www.cs.bham.ac.uk/~parkerdx/student-projects.phpLinks to an external site.\n" +
                "\n" +
                "Prof Uday Reddy - http://www.cs.bham.ac.uk/~udr/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Eike Ritter - http://www.cs.bham.ac.uk/~exr/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Prof Jon Rowe - http://www.cs.bham.ac.uk/~jer/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Prof Mark Ryan - http://www.cs.bham.ac.uk/~mdr/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Alan P Sexton - http://www.cs.bham.ac.uk/~aps/student-projects.pdfLinks to an external site.\n" +
                "\n" +
                "Dr Volker Sorge - http://www.cs.bham.ac.uk/~vxs/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Ian Styles - http://www.cs.bham.ac.uk/~ibs/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Peter Tino - http://www.cs.bham.ac.uk/~pxt/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Dr Steve Vickers - http://www.cs.bham.ac.uk/~sjv/student-projects.htmlLinks to an external site.\n" +
                "\n" +
                "Prof Jeremy L Wyatt - http://www.cs.bham.ac.uk/~jlw/student-projects.htmlLinks to an external site.";
        String[] strs = str.split("\n");
        for (String s : strs) {
            if (s.length() == 0) {
                continue;
            }
            String[] n = s.replace("Links to an external site.", "").split(" - ");
            System.out.println(n[0] + ", " + n[1]);
        }
    }
}
