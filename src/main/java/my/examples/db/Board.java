package my.examples.db;

import java.util.Date;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-15
 * Github : https://github.com/YeoHoonYun
 */
public class Board {
    private Long id;
    private String title;
    private String content;
    private String name;
    private Date regdate;
    private int readCount;

    public Board(){
        this.regdate = new Date();
        this.readCount = 0;
    }

    public Board(String title, String content, String name) {
        this();
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public Board(Long id, String title, String content, String name, Date regdate, int readCount) {
        this(title, content, name);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }


    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", regdate=" + regdate +
                ", readCount=" + readCount +
                '}';
    }
}
