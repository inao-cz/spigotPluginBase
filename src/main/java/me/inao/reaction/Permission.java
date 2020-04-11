package me.inao.reaction;

public enum Permission {
    COMMAND_TEST("reactions.commands.test");
    private String permission;
    Permission(String value){
        this.permission = value;
    }

    public String get(){
        return this.permission;
    }
}
