package com.yyh.status.key.new_add;

/**
 * Created by desaco on 2018/7/20.
 */

public class PgcSubscribeBean {
    private String pgcAuthor;
    private String pgcAuthorDesript;
    private boolean isSuscribe;//true表示已经订阅了；
    private int newType;
    private int itemPostion;

    public String getPgcAuthor() {
        return pgcAuthor;
    }

    public void setPgcAuthor(String pgcAuthor) {
        this.pgcAuthor = pgcAuthor;
    }

    public String getPgcAuthorDesript() {
        return pgcAuthorDesript;
    }

    public void setPgcAuthorDesript(String pgcAuthorDesript) {
        this.pgcAuthorDesript = pgcAuthorDesript;
    }

    public boolean isSuscribe() {
        return isSuscribe;
    }

    public void setSuscribe(boolean suscribe) {
        isSuscribe = suscribe;
    }

    public int getNewType() {
        return newType;
    }

    public void setNewType(int newType) {
        this.newType = newType;
    }

    public int getItemPostion() {
        return itemPostion;
    }

    public void setItemPostion(int itemPostion) {
        this.itemPostion = itemPostion;
    }
}
