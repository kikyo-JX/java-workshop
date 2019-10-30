package com.birmingham.hci.workshop.chen.worksheet3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * User: Chen Liu
 * Date: 2019/10/30
 * Time: 3:23 pm
 */
public class GenerateClass {

    /**
     * Fields
     */
    private String classname;
    private String[] variableNames;
    private String[] variableTypes;

    /**
     * Constructor
     *
     * @param classname     classname
     * @param variableNames variableNames
     * @param variableTypes variableTypes
     */
    public GenerateClass(String classname, String[] variableNames, String[] variableTypes) {
        if (variableNames.length != variableTypes.length) {
            throw new IllegalArgumentException("VariableNames and variableTypes must have the same length.");
        }
        this.classname = classname;
        this.variableNames = variableNames;
        this.variableTypes = variableTypes;
    }

    /**
     * Field format
     */
    private final static String FIELD_FORMAT = "  private %s %s;\n";

    /**
     * Return s a String with a declaration of the corresponding field variables.
     *
     * @return String of fields
     */
    public String makeFields() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.variableTypes.length; i++) {
            String type = this.variableTypes[i];
            String name = this.variableNames[i];
            sb.append(String.format(FIELD_FORMAT, type, name));
        }

        return sb.toString();
    }

    /**
     * Constructor format
     */
    private final static String CONSTRUCTOR_FORMAT = "  public %s(%s) {\n%s  }\n";
    private final static String CONSTRUCTOR_PARAMETER_FORMAT = "%s %s, ";
    private final static String CONSTRUCTOR_ASSIGNMENT_FORMAT = "    this.%s = %s;\n";

    /**
     * Returns a String with a corresponding constructor.
     *
     * @return String of constructor
     */
    public String makeConstructor() {
        StringBuilder sbParameter = new StringBuilder();
        StringBuilder sbAssignment = new StringBuilder();
        for (int i = 0; i < this.variableTypes.length; i++) {
            String type = this.variableTypes[i];
            String name = this.variableNames[i];
            sbParameter.append(String.format(CONSTRUCTOR_PARAMETER_FORMAT, type, name));
            sbAssignment.append(String.format(CONSTRUCTOR_ASSIGNMENT_FORMAT, name, name));
        }
        String parameters = sbParameter.toString();
        // Remove the last comma and space
        parameters = parameters.substring(0, parameters.length() - 2);

        return String.format(CONSTRUCTOR_FORMAT, this.classname, parameters, sbAssignment.toString());
    }

    /**
     * Getter format
     */
    private final static String GETTER_FORMAT = "  public %s get%s() {\n    return this.%s;\n  }\n";

    /**
     * Returns a String with all getters in the order given by variableNames.
     *
     * @return String of getters
     */
    public String makeGetters() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.variableTypes.length; i++) {
            String type = this.variableTypes[i];
            String name = this.variableNames[i];
            char upperCaseOfFirstCharOfName = name.toUpperCase().charAt(0);
            sb.append(String.format(GETTER_FORMAT,
                    type,
                    upperCaseOfFirstCharOfName + name.substring(1),
                    name));
        }

        return sb.toString();
    }

    /**
     * Getter format
     */
    private final static String SETTER_FORMAT = "  public void set%s(%s %s) {\n    this.%s = %s;\n  }\n";

    /**
     * Returns a String with all setters in the order given by variableNames.
     *
     * @return String of setters
     */
    public String makeSetters() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.variableTypes.length; i++) {
            String type = this.variableTypes[i];
            String name = this.variableNames[i];
            char upperCaseOfFirstCharOfName = name.toUpperCase().charAt(0);
            sb.append(String.format(SETTER_FORMAT,
                    upperCaseOfFirstCharOfName + name.substring(1),
                    type,
                    name,
                    name,
                    name));
        }

        return sb.toString();
    }

    /**
     * Class format
     */
    private final static String CLASS_FORMAT = "public class %s {\n%s}";

    /**
     * Write the class to the file with the name of name.java
     */
    public void writeFile() {
        String clazz = String.format(CLASS_FORMAT,
                this.classname,
                this.makeFields() +
                this.makeConstructor() +
                this.makeGetters() +
                this.makeSetters());

        String filename = this.classname + ".java";
        File file = new File(filename);
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(clazz);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Can't write to file: " + filename);
        }
    }

    /// Getter and Setter ///
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String[] getVariableNames() {
        return variableNames;
    }

    public void setVariableNames(String[] variableNames) {
        this.variableNames = variableNames;
    }

    public String[] getVariableTypes() {
        return variableTypes;
    }

    public void setVariableTypes(String[] variableTypes) {
        this.variableTypes = variableTypes;
    }

    public static void main(String[] args) {
        GenerateClass generateClass = new GenerateClass("Person",
                new String[]{"name", "dob"},
                new String[]{"String", "Date"});
//        System.out.println(generateClass.makeFields());
//        System.out.println(generateClass.makeConstructor());
//        System.out.println(generateClass.makeGetters());
//        System.out.println(generateClass.makeSetters());
        generateClass.writeFile();
    }
}
