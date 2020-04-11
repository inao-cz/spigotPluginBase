package me.inao.reaction;

public enum Message {
    PERMS_NOPERMS("§cSorry, but you don't have enough permissions for that :("),
    GENERIC_SUCCESS("§5Success!");

    private String message;
    Message(String value){
        this.message = value;
    }

    public String get(){
        return this.message;
    }
}
