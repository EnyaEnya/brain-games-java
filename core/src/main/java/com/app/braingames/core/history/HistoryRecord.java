package com.app.braingames.core.history;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "record")
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoryRecord {

    private String user;

    private String game;

    private String result;

    private Date date;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HistoryRecord{" +
                "user='" + user + '\'' +
                ", game='" + game + '\'' +
                ", result='" + result + '\'' +
                ", date=" + date +
                '}';
    }
}
