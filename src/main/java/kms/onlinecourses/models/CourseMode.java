package kms.onlinecourses.models;

public enum CourseMode {
    ONLINE("online"),
    OFFICE("at office"),
    SELF_STUDY("self-study");

    private String alias;

    CourseMode(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

}
